package ru.stqa.pft.rest.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.rest.mantis.models.AccountData;

public class RestPasswordHelper extends HelperBase {
    public RestPasswordHelper(ApplicationManager app) {
        super(app);
    }


    public void start(AccountData account) {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        click(By.xpath("//a[text()='" + account.getUsername() + "']"));
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void finish(String conformationLink, String password) {
        wd.get(conformationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
