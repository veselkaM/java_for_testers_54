package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.GroupData;

import java.util.List;

public class AddNewContactTests extends TestBase {
    
    @Test
    public void testAddNewContact() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToAddContactPage();
        app.getContactHelper().createContact(new ContactData("Test01", "Test02", "Test03", "Null", "new_group", "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "new_group", "notes_here"), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()+1);
    }

}
