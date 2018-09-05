package ru.stqa.pft.rest.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.addressbook.models.ContactData;
import ru.stqa.pft.rest.addressbook.models.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().home();
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobilePhone("89165634156").withEmailOne("dar.lobowa@yandex.ru"));
        }
    }
    
    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertEquals(app.contact().count(),before.size()-1);
        Contacts after = app.db().contacts();
        assertThat(after,CoreMatchers.equalTo(before.without(deletedContact)));
        verifyContactListInUI();
    }



}
