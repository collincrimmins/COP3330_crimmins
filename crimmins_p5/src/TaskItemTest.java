import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {
    @Test
    public void constructorFailsWithInvalidDueDate() throws Exception {
        try {
            TaskItem Task = new TaskItem("test", "test", "12-12-12", false);
        } catch (Exception e) {
            return;
        }
        fail();
    }

    @Test
    public void constructorFailsWithInvalidTitle() {
        try {
            TaskItem Task = new TaskItem("", "test", "12-12-12", false);
        } catch (Exception e) {
            return;
        }
        fail();
    }

    @Test
    public void constructorSucceedsWithValidDueDate() {
        try {
            TaskItem Task = new TaskItem("test", "test", "2020-12-12", false);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void constructorSucceedsWithValidTitle() {
        try {
            TaskItem Task = new TaskItem("test", "test", "2020-12-12", false);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-12", false);
        if (NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-2", false);
        if (!NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-000", false);
        if (!NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-20", false);
        if (NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingTitleFailsWithEmptyString() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        TaskApp.editListItem(NewList, 0, "", "new", "2020-12-20", false);
        if (!NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue() throws Exception {
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

    /*
    @Test
    public void testTaskItemFailsWithInvalidDueDate() {
        String[] Result = TaskApp.getDueDate(-99, "abc", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        String[] Result = TaskApp.getTitle(-99, "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        String[] Result = TaskApp.getDueDate(-99, "2020-12-12", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        String[] Result = TaskApp.getTitle(-99, "Test", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        String[] Result = TaskApp.getDueDate(-99, "abc", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        String[] Result = TaskApp.getDueDate(-99, "2020-12-12", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {
        String[] Result = TaskApp.getTitle(-99, "", false);
        if (!Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        String[] Result = TaskApp.getTitle(-99, "Test", false);
        if (Result[0].equals("Error")) { fail(); }
    }

    @Test
    public void addingTaskItemsIncreasesSize() throws Exception {
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
    public void editingTaskItemChangesValues() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String titleStart = NewList.ListArray.get(0).Title;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-12");
        if (NewList.ListArray.get(0).Title.equals(titleStart)) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDescriptionChangesValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String descriptionStart = NewList.ListArray.get(0).Description;
        TaskApp.editListItem(NewList, 0, "new", "new", "2020-12-12");
        if (NewList.ListArray.get(0).Description.equals(descriptionStart)) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        String descriptionStart = NewList.ListArray.get(0).Description;
        TaskApp.editListItem(NewList, 1, "new", "new", "2020-12-12");
        if (!NewList.ListArray.get(0).Description.equals(descriptionStart)) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateChangesValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        TaskApp.editListItem(NewList, 0, "new", "new", "2000-01-01");
        if (!NewList.ListArray.get(0).DueDate.equals("2000-01-01")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        TaskApp.editListItem(NewList, 1, "new", "new", "2000-01-01");
        if (NewList.ListArray.get(0).DueDate.equals("2000-01-01")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemTitleChangesValue() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check due date
        TaskApp.editListItem(NewList, 0, "new", "new", "2000-01-01");
        if (!NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() throws Exception {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Add Item
        TaskApp.addListItem(NewList, "Test", "Test", "2020-12-12", false);
        // Check title
        TaskApp.editListItem(NewList, 1, "new", "new", "2000-01-01");
        if (NewList.ListArray.get(0).Title.equals("new")) {
            fail();
        }
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() throws Exception {
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
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() throws Exception {
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
    public void gettingTaskItemDueDateFailsWithInvalidIndex() throws Exception {
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
    public void gettingTaskItemDueDateSucceedsWithValidIndex() throws Exception {
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
    public void gettingTaskItemTitleFailsWithInvalidIndex() throws Exception {
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
    public void gettingTaskItemTitleSucceedsWithValidIndex() throws Exception {
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
    public void newTaskListIsEmpty() {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Check size
        if (NewList.ListArray.size() > 0) {
            fail();
        }
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        // Create list
        TaskList NewList = TaskApp.CreateNewList();
        // Check size
        if (NewList.ListArray.size() > 0) {
            fail();
        }
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() throws Exception {
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
     */
}