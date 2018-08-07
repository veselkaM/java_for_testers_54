package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

        type(By.name("notes"), contactData.getNotes());
    }

    public void submitAddNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeleteSelectedContact() {
        wd.switchTo().alert().accept();
    }

    public void initContactEdit(int index) {
        wd.findElements(By.xpath("//*[@name = \'entry\']//*[@title = \'Edit\']")).get(index).click();
    }

    public void initContactModificationFromDetails() {
        click(By.name("modifiy"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDetails(int index) {
        wd.findElements(By.xpath("//*[@name = 'entry']//*[@title = 'Details']")).get(index).click();
    }

    public void create(ContactData contact, boolean creation) {
        fillAddContactForm(contact, creation);
        submitAddNewContact();
        returnToHomePage();
    }

    public void edit(int index, ContactData contact) {
        initContactEdit(index);
        fillAddContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public void modifyFromDetails(int index, ContactData contact) {
        initContactDetails(index);
        initContactModificationFromDetails();
        fillAddContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        acceptDeleteSelectedContact();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            List<WebElement> contactEntries = element.findElements(By.cssSelector("td"));
            String firstName = contactEntries.get(2).getText();
            String lastName = contactEntries.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
        }
        return contacts;
    }


}
