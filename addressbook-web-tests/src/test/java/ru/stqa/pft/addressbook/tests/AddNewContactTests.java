package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import ru.stqa.pft.addressbook.models.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContactTests extends TestBase {
    
    @Test
    public void testAddNewContact() {
        Contacts before = app.contact().all();
        app.goTo().add();
        ContactData contact = new ContactData().withLastname("Test01").withFirstname("Test02").withMiddlename("Test03").withNickname("Null")
                .withCompany("new_group").withAddress("Moscow").withMobilePhone("89165634156").withWorkPhone("home").withEmailOne("dar.lobowa@yandex.ru").withGroup("edit01")
                 .withNotes("notes_here");
        app.contact().create(contact, true);
        assertThat(app.contact().count(),equalTo (before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
