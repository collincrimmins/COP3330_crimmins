import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {
    @Test
    public void addingItemsIncreasesSize() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Action
        int ListSize = NewList.ListArray.size();
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        if (NewList.ListArray.size() != ListSize + 1) {
            fail();
        }
    }

    @Test
    public void completingTaskItemChangesStatus() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        TaskApp.markItemCompleted(NewList, 0);
        if (NewList.ListArray.get(0).Completed == completeStart) {
            fail();
        }
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        TaskApp.markItemCompleted(NewList, 1);
        if (NewList.ListArray.get(0).Completed != completeStart) {
            fail();
        }
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String descriptionStart = NewList.ListArray.get(0).Description;
        TaskApp.editListItem(NewList, 1, "new", "new", "2020-12-12", false);
        if (!NewList.ListArray.get(0).Description.equals(descriptionStart)) {
            fail();
        }
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String descriptionStart = NewList.ListArray.get(0).Description;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-12", false);
        if (NewList.ListArray.get(0).Description.equals(descriptionStart)) {
            fail();
        }
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        TaskApp.editListItem(NewList, 0, "new", "new", "2000-01-01", false);
        if (!NewList.ListArray.get(0).DueDate.equals("2000-01-01")) {
            fail();
        }
    }

    @Test
    public void editingItemTitleFailsWithEmptyString() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        TaskApp.editListItem(NewList, 0, "", "new", "2000-01-01", false);
        if (!NewList.ListArray.get(0).Title.equals("Test")) {
            fail();
        }
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        TaskApp.editListItem(NewList, 1, "new", "new", "2000-01-01", false);
        if (NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        TaskApp.editListItem(NewList, 0, "new", "new", "2000-01-01", false);
        if (!NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        TaskApp.editListItem(NewList, 0, "new", "new", "20-01-01", false);
        if (NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        TaskApp.editListItem(NewList, 1, "new", "new", "20-01-01", false);
        if (NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        TaskApp.editListItem(NewList, 0, "new", "new", "20-01-01", false);
        if (NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Result = TaskApp.getTaskDescription(NewList, 1);
        if (Result[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Result = TaskApp.getTaskDescription(NewList, 0);
        if (!Result[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = TaskApp.getTaskDueDate(NewList, 1);
        if (Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = TaskApp.getTaskDueDate(NewList, 0);
        if (!Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = TaskApp.getTaskTitle(NewList, 1);
        if (Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Get Description
        String[] Results = TaskApp.getTaskTitle(NewList, 0);
        if (!Results[0].equals("Valid")) {
            fail();
        }
    }

    @Test
    public void newListIsEmpty() {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Action
        if (NewList.ListArray.size() != 0) {
            fail();
        }
    }

    @Test
    public void removingItemsDecreasesSize() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Action
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        int ListSize = NewList.ListArray.size();
        TaskApp.removeListItem(NewList, 0);
        if (NewList.ListArray.size() != ListSize - 1) {
            fail();
        }
    }

    @Test
    public void removingItemsFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Action
        int ListSize = NewList.ListArray.size();
        TaskApp.removeListItem(NewList, 1);
        if (NewList.ListArray.size() != ListSize) {
            fail();
        }
    }

    @Test
    public void savedTaskListCanBeLoaded() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Save list
        TaskApp.saveItemList(NewList, "test.txt");
        // Load list
        TaskApp.loadItemList("test.txt");
    }

    @Test
    public void uncompletingTaskItemChangesStatus() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        TaskApp.markItemCompleted(NewList, 0);
        if (NewList.ListArray.get(0).Completed == completeStart) {
            fail();
        }
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check completed
        boolean completeStart = NewList.ListArray.get(0).Completed;
        TaskApp.unmarkItemCompleted(NewList, 1);
        if (NewList.ListArray.get(0).Completed != completeStart) {
            fail();
        }
    }
}