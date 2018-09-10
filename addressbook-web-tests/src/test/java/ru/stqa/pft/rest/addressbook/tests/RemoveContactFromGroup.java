package ru.stqa.pft.rest.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.addressbook.models.ContactData;
import ru.stqa.pft.rest.addressbook.models.GroupData;
import ru.stqa.pft.rest.addressbook.models.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

public class RemoveContactFromGroup extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().home();
            app.goTo().add();
            app.contact().create(new ContactData().withFirstname("Test01").withLastname("Test02").withAddress("Moscow").withMobilePhone("89165634156").withEmailOne("dar.lobowa@yandex.ru"));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("18 раз"));
        }
    }

    @Test
    public void removeContactFromGroupTests() {

        ContactData contact = app.db().contacts().iterator().next();
        Groups allGroups = app.db().groups();
        GroupData removedGroup = allGroups.iterator().next();

        if (!removedGroup.equals(contact.getGroups())) {
            app.goTo().home();
            app.contact().addToGroup(contact, removedGroup);
        }

        allGroups.removeAll(contact.getGroups());
        app.goTo().home();
        app.contact().removeFromGroup(contact, removedGroup);
        app.db().refresh(contact);

        assertThat(contact.getGroups(), not(hasItem(removedGroup)));

    }
}

