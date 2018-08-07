package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddNewContactTests extends TestBase {
    
    @Test
    public void testAddNewContact() {
        List<ContactData> before = app.contact().list();
        app.goTo().add();
        ContactData contact = new ContactData().withLastname("Test01").withFirstname("Test02").withMiddlename("Test03").withNickname("Null")
                .withCompany("new_group").withAddress("Moscow").withMobile("89165634156").withWork("home").withEmail("dar.lobowa@yandex.ru").withGroup("edit01")
                 .withNotes("notes_here");
        app.contact().create(contact, true);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size()+1);

        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }

}
