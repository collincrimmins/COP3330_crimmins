import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    @Test
    public void testTaskItemFailsWithInvalidDueDate() {
        String[] Result = App.getDueDate(-99, "abc");
        if (Result[0] == "Error") { fail(); }
        
    }

   /* @Test
    public void creatingTaskItemFailsWithInvalidTitle() {

    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {

    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {

    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {

    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {

    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle() {

    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {

    }*/
}