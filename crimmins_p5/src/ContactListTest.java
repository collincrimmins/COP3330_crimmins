import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class ContactListTest {
    @Test
    public void addingItemsIncreasesSize() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Action
        int ListSize = NewList.ListArray.size();
        ContactApp.addListItem(NewList, "test", "", "", "", false);
        if (NewList.ListArray.size() != ListSize + 1) {
            fail();
        }
    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 0, "", "", "", "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 1, "", "", "", "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void editingSucceedsWithBlankFirstName() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 0, "", "test", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void editingSucceedsWithBlankLastName() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 0, "test", "", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void editingSucceedsWithBlankPhone() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 0, "", "test", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void newListIsEmpty() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Action
        if (NewList.ListArray.size() != 0) {
            fail();
        }
    }

    @Test
    public void removingItemsDecreasesSize() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Action
        int ListSize = NewList.ListArray.size();
        ContactApp.removeListItem(NewList, 0);
        if (NewList.ListArray.size() != ListSize - 1) {
            fail();
        }
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Action
        int ListSize = NewList.ListArray.size();
        String[] Result = ContactApp.removeListItem(NewList, 1);
        if (NewList.ListArray.size() != ListSize) {
            fail();
        }
    }

    @Test
    public void savedContactListCanBeLoaded() throws IOException {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Save List
        ContactApp.saveItemList(NewList, "test1.txt");
        ContactApp.loadItemList("test1.txt");
    }

}