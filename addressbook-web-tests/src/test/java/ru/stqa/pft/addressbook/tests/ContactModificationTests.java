package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactModificationTests extends TestBase {


    //тест для модификации контакта, при нажатии на кнопку Edit на странице home
    @Test
    public void testContactEdit() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactEdit();
        app.getContactHelper().fillAddContactForm(new ContactData("Edit01", "Edit02", "Edit03", "NOT Null", "Appy puppy", "Bali", "891656341X6", "NOT home", "dar.lobowa55@yandex.ru", null, "notes_here_01"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }

    //тест для модификации контакта из детальной информации
    @Test
    public void testContactModificationFromDetails() {
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactDetails();
        app.getContactHelper().initContactModificationFromDetails();
        app.getContactHelper().fillAddContactForm(new ContactData("01", "02", "03", "04", "05", "06", "07", "08", "d09", null,"10"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
