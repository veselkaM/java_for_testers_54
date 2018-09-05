package ru.stqa.pft.rest.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.addressbook.models.GroupData;
import ru.stqa.pft.rest.addressbook.models.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("17 раз"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.goTo().groupPage();
        app.group().delete(deletedGroup);
        assertEquals(app.group().count(),before.size()-1);
        Groups after = app.db().groups();
        assertThat(after,CoreMatchers.equalTo(before.without(deletedGroup)));
        verifyGroupListInUI();
    }


}

