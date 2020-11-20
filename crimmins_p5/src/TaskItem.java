import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem {
    public String Title;
    public String Description;
    public String DueDate;
    public boolean Completed;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public TaskItem(String Title, String Description, String DueDate, boolean Completed) throws Exception {
        if (Title.length() <= 0) {
            throw new Exception("Invalid title");
        }
        if (Title.length() <= 0) {
            throw new Exception("Invalid title");
        }
        Date date = null;
        try {
            date = format.parse(DueDate);
            if (!DueDate.equals(format.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            throw new Exception("Invalid date");
        }
        if (date == null) {
            throw new Exception("Invalid date");
        }
        this.Title = Title;
        this.Description = Description;
        this.DueDate = DueDate;
        this.Completed = Completed;
    }
}
