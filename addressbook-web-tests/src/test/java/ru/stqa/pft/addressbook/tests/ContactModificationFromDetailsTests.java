package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationFromDetailsTests extends TestBase {
    //тест для модификации контакта из детальной информации

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().home();
        if (app.contact().list().size() == 0) {
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobile("89165634156").withEmail("dar.lobowa@yandex.ru"), true);
        }
    }

    @Test
    public void testContactModificationFromDetails() {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        ContactData contact = new ContactData()
                .withId(before.get(index).getId()).withFirstname("такое себе").withLastname("почему").withWork("Appy puppy").withAddress("Bali").withMobile("891656341X6");
        app.contact().modifyFromDetails(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

    }


}
