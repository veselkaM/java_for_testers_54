package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddNewContactTests extends TestBase {
    
    @Test
    public void testAddNewContact() {
        Set<ContactData> before = app.contact().all();
        app.goTo().add();
        ContactData contact = new ContactData().withLastname("Test01").withFirstname("Test02").withMiddlename("Test03").withNickname("Null")
                .withCompany("new_group").withAddress("Moscow").withMobile("89165634156").withWork("home").withEmail("dar.lobowa@yandex.ru").withGroup("edit01")
                 .withNotes("notes_here");
        app.contact().create(contact, true);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size()+1);
        
        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);

    }

}
