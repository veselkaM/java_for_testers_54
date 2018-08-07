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
                .withCompany("new_group").withAddress("Moscow").withMobile("89165634156").withWork("home").withEmail("dar.lobowa@yandex.ru").withGroup("edit01")
                 .withNotes("notes_here");
        app.contact().create(contact, true);
        Contacts after = app.contact().all();
        assertThat(after.size(),equalTo (before.size()+1));

        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
