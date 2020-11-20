import org.junit.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "", "", "", "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creationSucceedsWithBlankEmail() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "test", "", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void creationSucceedsWithBlankFirstName() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "", "test", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void creationSucceedsWithBlankLastName() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "test", "", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void creationSucceedsWithBlankPhone() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "test", "", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void creationSucceedsWithNonBlankValues() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "a", "a", "a", "a", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void editingFailsWithAllBlankValues() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        // Add Item
        String[] Result = ContactApp.addListItem(NewList, "", "", "", "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void editingSucceedsWithBlankEmail() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 0, "", "test", "", "", false);
        if (!Result[0].equals("Valid")) { fail(); }
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
        String[] Result = ContactApp.editListItem(NewList, 0, "", "", "test", "", false);
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
    public void editingSucceedsWithNonBlankValues() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Add Item
        String[] Result = ContactApp.editListItem(NewList, 0, "a", "a", "a", "a", false);
        if (!Result[0].equals("Valid")) { fail(); }
    }

    @Test
    public void testToString() {
        // Create list
        ContactList NewList = ContactApp.CreateNewList();
        ContactApp.addListItem(NewList, "test", "test", "test", "test", false);
        // Get String
        String ListString = "";
        ListString = ContactApp.getPrintListString(NewList);
    }
}