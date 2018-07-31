package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {


    //тест для модификации контакта, при нажатии на кнопку Edit на странице home
    @Test
    public void testContactEdit() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddContactPage();
            app.getContactHelper().createContact(new ContactData("Test01", "Test02", "Test03", "Null", null, "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "new_group", "notes_here"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactEdit();
        app.getContactHelper().fillAddContactForm(new ContactData("Edit01", "Edit02", "Edit03", "NOT Null", "Appy puppy", "Bali", "891656341X6", "NOT home", "dar.lobowa55@yandex.ru", null, "notes_here_01"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
    }

    //тест для модификации контакта из детальной информации
    @Test
    public void testContactModificationFromDetails() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddContactPage();
            app.getContactHelper().createContact(new ContactData("Test01", "Test02", "Test03", "Null", null, "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "ew_group", "notes_here"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactDetails();
        app.getContactHelper().initContactModificationFromDetails();
        app.getContactHelper().fillAddContactForm(new ContactData("01", "02", "03", "04", "05", "06", "07", "08", "d09", null,"10"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
    }
}
