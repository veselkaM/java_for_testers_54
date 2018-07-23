package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddContactForm(ContactData contactData) {
        type (By.name("firstname"), contactData.getFirstname());
        type (By.name("middlename"),contactData.getMiddlename());
        type (By.name("lastname"),contactData.getLastname());
        type (By.name("nickname"), contactData.getNickname());
        type (By.name("company"), contactData.getCompany());
        type (By.name("address"), contactData.getAddress());
        type (By.name("mobile"), contactData.getMobile());
        type (By.name("work"), contactData.getWork());
        type (By.name("email"), contactData.getEmail());
        type (By.name("notes"), contactData.getNotes());
    }

    public void submitAddNewContact() { click(By.xpath("//div[@id='content']/form/input[21]")); }

    public void returnToHomePage() { click(By.linkText("home page")); }

    public void selectContact()  { click (By.name("selected[]")); }

    public void deleteSelectedContact() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }

    public void acceptDeleteSelectedContact() {wd.switchTo().alert().accept();}

    public void initContactEdit() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));}

    public void initContactModificationFromDetails() { click(By.name("modifiy"));}

    public void submitContactModification () {
        click(By.name("update"));
    }

    public void initContactDetails() {  click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));}
}
