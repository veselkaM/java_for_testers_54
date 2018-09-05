package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.models.AccountData;
import ru.stqa.pft.mantis.models.MailMessage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTest extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRestPassword() throws Exception {
        int adminId = app.db().accounts().stream().filter((p) -> p.getUsername().equals("administrator")).iterator().next().getId();
        AccountData account = app.db().accounts().stream().filter((p) -> p.getId() != adminId).iterator().next();
        String user = account.getUsername();
        String email = account.getEmail();
        String newPassword = "tester";
        app.loginHelper().loginWeb("administrator", "root");
        app.restPassword().start(account);
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
    public void stopMailServer() {
        app.mail().stop();
    }
}
