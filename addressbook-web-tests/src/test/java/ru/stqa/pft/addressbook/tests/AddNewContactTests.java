package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class AddNewContactTests extends TestBase {
    
    @Test
    public void testAddNewContact() {
        app.getNavigationHelper().goToAddContactPage();
        app.getContactHelper().fillAddContactForm(new ContactData("Test01", "Test02", "Test03", "Null", "Appy", "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "notes_here"));
        app.getContactHelper().submitAddNewContact();
        app.getContactHelper().returnToHomePage();
    }

}
