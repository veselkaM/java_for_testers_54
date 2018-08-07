package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationFromDetailsTests extends TestBase {
    //тест для модификации контакта из детальной информации

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobile("89165634156").withEmail("dar.lobowa@yandex.ru"), true);
        }
    }

    @Test
    public void testContactModificationFromDetails() {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("такое себе").withLastname("почему").withWork("Appy puppy").withAddress("Bali").withMobile("891656341X6");
        app.contact().modifyFromDetails(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
