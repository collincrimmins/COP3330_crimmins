import java.util.ArrayList;

public class TaskList {
    ArrayList<TaskItem> ListArray;

    public TaskList() {
        this.ListArray = new ArrayList<TaskItem>();
    }

    public static void TaskListAdd(TaskList List, TaskItem Task) {
        List.ListArray.add(Task);
    }
}
