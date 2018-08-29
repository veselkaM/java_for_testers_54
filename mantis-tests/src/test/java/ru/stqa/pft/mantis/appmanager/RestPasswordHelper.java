package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.models.AccountData;

public class RestPasswordHelper extends HelperBase {
    public RestPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    }

    public void selectAccount (AccountData account) {
        click(By.xpath("//a[text()='" + account.getUsername() + "']"));
    }

    public void restPassword(){
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void finish(String conformationLink, String password) {
        wd.get(conformationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
