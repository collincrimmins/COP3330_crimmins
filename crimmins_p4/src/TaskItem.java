public class TaskItem {
    public String Title;
    public String Description;
    public String DueDate;
    public boolean Completed;

    public TaskItem(String Title, String Description, String DueDate, boolean Completed) {
        this.Title = Title;
        this.Description = Description;
        this.DueDate = DueDate;
        this.Completed = Completed;
    }
}
