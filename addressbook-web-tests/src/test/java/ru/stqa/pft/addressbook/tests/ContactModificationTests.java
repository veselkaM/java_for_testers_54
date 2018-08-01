package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Collections;
import java.util.HashSet;
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
        app.getContactHelper().initContactEdit(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Edit01", "Edit02", "Edit03",
                "NOT Null", "Appy puppy", "Bali", "891656341X6", "NOT home", "dar.lobowa55@yandex.ru", null,
                "notes_here_01");
        app.getContactHelper().fillAddContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
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
        app.getContactHelper().initContactDetails(before.size()-1);
        app.getContactHelper().initContactModificationFromDetails();
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Edit01", "Edit02", "Edit03",
                "NOT Null", "Appy puppy", "Bali", "891656341X6", "NOT home", "dar.lobowa55@yandex.ru", null,
                "notes_here_01");
        app.getContactHelper().fillAddContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }
}
