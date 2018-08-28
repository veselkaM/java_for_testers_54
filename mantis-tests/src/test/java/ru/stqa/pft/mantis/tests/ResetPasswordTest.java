package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.models.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTest extends TestBase {

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    public void testRestPassword () throws IOException, MessagingException {
        String user = "user22";
        String newPassword = "testik";
        String email = "user22@mail.ru";
        app.restPassword().start("administrator", "root");
        app.restPassword().selectAccount(user);
        app.restPassword().restPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String conformationLink = findeConformationLink(mailMessages, email);
        app.restPassword().finish(conformationLink, newPassword);
        assertTrue(app.newSession().login(user, newPassword));

    }

    private String findeConformationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
