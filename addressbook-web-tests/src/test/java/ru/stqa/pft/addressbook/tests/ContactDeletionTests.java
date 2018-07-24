package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddContactPage();
            app.getContactHelper().createContact(new ContactData("Test01", "Test02", "Test03", "Null", null, "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "test_group", "notes_here"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeleteSelectedContact();
    }

}
