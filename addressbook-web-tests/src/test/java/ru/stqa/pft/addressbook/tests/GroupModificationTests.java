package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;
import ru.stqa.pft.addressbook.models.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("17 раз"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("edit01").withFooter("edit02").withHeader("edit03");
        app.group().modify(group);
        assertEquals(app.group().count(),before.size());
        Groups after = app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}
