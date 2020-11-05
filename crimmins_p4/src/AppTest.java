import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    /*InputStream Input = System.in;
    public void setInput(String Input) {
        InputStream in = new ByteArrayInputStream(Input.getBytes());
        System.setIn(in);
    }*/

    @Test
    public void testTaskItemFailsWithInvalidDueDate() {
        String[] Result = App.getDueDate(-99, "abc", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        String[] Result = App.getTitle(-99, "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        String[] Result = App.getDueDate(-99, "2020-12-12", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        String[] Result = App.getTitle(-99, "Test", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        String[] Result = App.getDueDate(-99, "abc", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        String[] Result = App.getDueDate(-99, "2020-12-12", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        String[] Result = App.getTitle(-99, "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        String[] Result = App.getTitle(-99, "Test", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void addingTaskItemsIncreasesSize() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Action
        int ListSize = NewList.ListArray.size();
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        if (NewList.ListArray.size() != ListSize + 1) {
            fail();
        }
    }

    @Test
    public void completingTaskItemChangesStatus() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        App.markItemCompleted(NewList, 0);
        if (NewList.ListArray.get(0).Completed == completeStart) {
            fail();
        }
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        App.markItemCompleted(NewList, 1);
        if (NewList.ListArray.get(0).Completed != completeStart) {
            fail();
        }
    }

    @Test
    public void editingTaskItemChangesValues() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        App.editListItem(NewList, 0, "new", "new", "2020-12-12");
        if (NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String descriptionStart = NewList.ListArray.get(0).Description;
        App.editListItem(NewList, 0, "new", "new", "2020-12-12");
        if (NewList.ListArray.get(0).Description.equals(descriptionStart)) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String descriptionStart = NewList.ListArray.get(0).Description;
        App.editListItem(NewList, 1, "new", "new", "2020-12-12");
        if (!NewList.ListArray.get(0).Description.equals(descriptionStart)) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        App.editListItem(NewList, 0, "new", "new", "2000-01-01");
        if (!NewList.ListArray.get(0).DueDate.equals("2000-01-01")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        App.editListItem(NewList, 1, "new", "new", "2000-01-01");
        if (NewList.ListArray.get(0).DueDate.equals("2000-01-01")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemTitleChangesValue() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        App.editListItem(NewList, 0, "new", "new", "2000-01-01");
        if (!NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        App.editListItem(NewList, 1, "new", "new", "2000-01-01");
        if (NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Result = App.getTaskDescription(NewList, 1);
        if (Result[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Result = App.getTaskDescription(NewList, 0);
        if (!Result[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = App.getTaskDueDate(NewList, 1);
        if (Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = App.getTaskDueDate(NewList, 0);
        if (!Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = App.getTaskTitle(NewList, 1);
        if (Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = App.getTaskTitle(NewList, 0);
        if (!Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void newTaskListIsEmpty() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Check size
        if (NewList.ListArray.size() > 0) {
            fail();
        }
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Check size
        if (NewList.ListArray.size() > 0) {
            fail();
        }
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Action
        int ListSize = NewList.ListArray.size();
        App.removeListItem(NewList, 1);
        if (NewList.ListArray.size() != ListSize) {
            fail();
        }
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Save list
        App.saveItemList(NewList, "test.txt");
        // Load list
        App.loadItemList("test.txt");
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        App.markItemCompleted(NewList, 0);
        if (NewList.ListArray.get(0).Completed == completeStart) {
            fail();
        }
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        // Create list
        TaskList NewList = App.CreateNewList();
        // Add Item
        App.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        App.unmarkItemCompleted(NewList, 1);
        if (NewList.ListArray.get(0).Completed != completeStart) {
            fail();
        }
    }
}