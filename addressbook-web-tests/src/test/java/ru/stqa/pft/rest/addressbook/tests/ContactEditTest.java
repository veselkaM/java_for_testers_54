package ru.stqa.pft.rest.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.addressbook.models.ContactData;
import ru.stqa.pft.rest.addressbook.models.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

//тесты для модификации контакта, при нажатии на кнопку Edit на странице home
public class ContactEditTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().home();
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobilePhone("89165634156").withEmailOne("dar.lobowa@yandex.ru"));
        }
    }

    @Test
    public void testContactEdit() {
        Contacts before = app.db().contacts();
        ContactData editedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId()).withFirstname("такое себе").withLastname("почему").withWorkPhone("Appy puppy").withAddress("Bali").withMobilePhone("891656341X6");
        app.contact().edit(contact);
        assertEquals(app.contact().count(),before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(editedContact).withAdded(contact)));
        verifyContactListInUI();
    }


}
