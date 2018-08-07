package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Set;

//тесты для модификации контакта, при нажатии на кнопку Edit на странице home
public class ContactEditTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().all().size() == 0) {
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobile("89165634156").withEmail("dar.lobowa@yandex.ru"), true);
        }
    }

    @Test
    public void testContactEdit() {
        Set<ContactData> before = app.contact().all();
        ContactData editedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId()).withFirstname("такое себе").withLastname("почему").withWork("Appy puppy").withAddress("Bali").withMobile("891656341X6");
        app.contact().edit(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(editedContact);
        before.add(contact);
        Assert.assertEquals(before,after);
    }


}
