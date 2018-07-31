package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToAddContactPage();
            app.getContactHelper().createContact(new ContactData("Test01", "Test02", "Test03", "Null", null, "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "new_group", "notes_here"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().acceptDeleteSelectedContact();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()-1);
    }

}
