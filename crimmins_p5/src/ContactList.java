import java.util.ArrayList;

public class ContactList {
    ArrayList<ContactItem> ListArray;

    public ContactList() {
        this.ListArray = new ArrayList<ContactItem>();
    }

    public static void TaskListAdd(ContactList List, ContactItem Contact) {
        List.ListArray.add(Contact);
    }
}
