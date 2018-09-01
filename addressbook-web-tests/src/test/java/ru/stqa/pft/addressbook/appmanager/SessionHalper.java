package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.System.getProperty;

public class SessionHalper extends HelperBase {

    public SessionHalper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        wd.get(getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }
}
