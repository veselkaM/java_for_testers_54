package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

public class AddNewContactTests extends TestBase {
    
    @Test
    public void testAddNewContact() {
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().goToAddContactPage();
        app.getContactHelper().createContact(new ContactData("Test01", "Test02", "Test03", "Null", "new_group", "Moscow", "89165634156", "home", "dar.lobowa@yandex.ru", "new_group", "notes_here"), true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }

}
