package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobile("89165634156").withEmail("dar.lobowa@yandex.ru"), true);
        }
    }
    
    @Test
    public void testContactDeletion() {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size()-1);

        before.remove(deletedContact);
        Assert.assertEquals(before,after);
    }



}
