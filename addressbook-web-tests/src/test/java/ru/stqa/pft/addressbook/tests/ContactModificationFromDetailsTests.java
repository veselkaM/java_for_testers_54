package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationFromDetailsTests extends TestBase {
    //тест для модификации контакта из детальной информации

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().home();
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobilePhone("89165634156").withEmailOne("dar.lobowa@yandex.ru").withGroup("new_group"));
        }
    }

    @Test
    public void testContactModificationFromDetails() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        File photo = new File("src/test/resources/BSFQ9517.jpg");
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("такое себе").withLastname("почему").withWorkPhone("Appy puppy").withAddress("Bali").withMobilePhone("891656341X6").withPhoto(photo);
        app.contact().modifyFromDetails(contact);
        assertEquals(app.contact().count(),before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
