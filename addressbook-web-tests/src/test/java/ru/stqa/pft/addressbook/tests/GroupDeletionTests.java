package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.models.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("tester","create_group",null));
        }
            app.getGroupHelper().selectGroup();
            app.getGroupHelper().deleteSelectedGroups();
            app.getGroupHelper().returnToGroupPage();
    }
}

