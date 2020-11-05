import javax.swing.*;
import java.awt.desktop.SystemSleepEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static int startMainMenu() {
        // Print
        System.out.println("Main Menu");
        System.out.println("--------");
        System.out.println(" ");
        System.out.println("1) create new list");
        System.out.println("2) load existing list");
        System.out.println("3) quit");
        // Take Input
        String Input = "";
        // Input
        Scanner scan = new Scanner(System.in);
        Input = scan.next();
        // Buffer
        String buffer = scan.nextLine();
        // Return
        return Integer.parseInt(Input);
    }

    public static int startListOperationsMenu() {
        // Print
        System.out.println("List Operations Menu");
        System.out.println("--------");
        System.out.println(" ");
        System.out.println("1) view list");
        System.out.println("2) add item");
        System.out.println("3) edit item");
        System.out.println("4) remove item");
        System.out.println("5) mark item completed");
        System.out.println("6) unmark item completed");
        System.out.println("7) save list");
        System.out.println("8) back to main menu");
        // Take Input
        String Input = "";
        // Input
        Scanner scan = new Scanner(System.in);
        Input = scan.next();
        // Buffer
        String buffer = scan.nextLine();
        // Return
        return Integer.parseInt(Input);
    }

    public static String[] getTaskTitle(TaskList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).Title;
        return ReturnStrings;
    }

    public static String[] getTaskDescription(TaskList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).Description;
        return ReturnStrings;
    }

    public static String[] getTaskDueDate(TaskList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).DueDate;
        return ReturnStrings;
    }

    public static int printList(TaskList List, int Type) {
        // Print
        if (Type == 1) {
            // Print all tasks
            System.out.println("Current Tasks");
            System.out.println("--------");
            System.out.println(" ");
        } else if (Type == 2) {
            // Print completed tasks
            System.out.println("Completed Tasks");
            System.out.println("--------");
            System.out.println(" ");
        } else if (Type == 3) {
            // Print uncompleted tasks
            System.out.println("Uncompleted Tasks");
            System.out.println("--------");
            System.out.println(" ");
        }
        int relevantTasks = 0;
        // Print List
        for (int i = 0; i < List.ListArray.size(); i++) {
            if (Type == 1) {
                relevantTasks = relevantTasks + 1;
                System.out.print(i + ") ");
                if (List.ListArray.get(i).Completed) {
                    // Mark completed in main list
                    System.out.print("*** ");
                }
                System.out.print("[" + getTaskDueDate(List, i)[1] + "] ");
                System.out.print(getTaskTitle(List, i)[1] + ": ");
                System.out.print(getTaskDescription(List, i)[1]);
                System.out.println(" ");
            } else if (Type == 2) {
                if (List.ListArray.get(i).Completed) {
                    relevantTasks = relevantTasks + 1;
                    // Print completed tasks
                    System.out.print(i + ") ");
                    System.out.print("[" + getTaskDueDate(List, i)[1] + "] ");
                    System.out.print(getTaskTitle(List, i)[1] + ": ");
                    System.out.print(getTaskDescription(List, i)[1]);
                    System.out.println(" ");
                }
            } else if (Type == 3) {
                if (!List.ListArray.get(i).Completed) {
                    relevantTasks = relevantTasks + 1;
                    // Print uncompleted tasks
                    System.out.print(i + ") ");
                    System.out.print("[" + getTaskDueDate(List, i)[1] + "] ");
                    System.out.print(getTaskTitle(List, i)[1] + ": ");
                    System.out.print(getTaskDescription(List, i)[1]);
                    System.out.println(" ");
                }
            }
        }
        if (Type == 2 || Type == 3) {
            if (relevantTasks == 0) {
                System.out.println("No relevant tasks.");
            }
        }
        System.out.println(" ");
        return relevantTasks;
    }

    public static String getNextInput(String Message) {
        if (!Message.equals("")) {
            System.out.print(Message);
        }
        //Scanner scan = new Scanner(System.in);
        //String Input = scan.next();
        //String buffer = scan.nextLine();
        String Input = "";
        Scanner fileScanner = new Scanner(System.in);
        String line = fileScanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
            Input = lineScanner.next();
        }
        return Input;
    }

    public static String[] getTitle(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // Title
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new title for task " + printEditPrompt + ":");
            } else {
                Input = getNextInput("Task title: ");
            }
        }
        // Error Checking
        ReturnStrings[0] = "Valid";
        ReturnStrings[1] = Input;
        if (Input.length() <= 0) {
            ReturnStrings[0] = "Error";
            ReturnStrings[1] = "Title must be at least 1 character long.";
        }
        return ReturnStrings;
    }

    public static String[] getDescription(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // Description
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new description for task " + printEditPrompt + ":");
            } else {
                Input = getNextInput("Task description: ");
            }
        }
        // Error Checking
        ReturnStrings[0] = "Valid";
        ReturnStrings[1] = Input;
        /*if (Description.length() <= 0) {
            ReturnStrings[0] = "Error";
            ReturnStrings[1] = "Description must be at least 1 character long.";
        }*/
        return ReturnStrings;
    }

    public static String[] getDueDate(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // DueDate
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new due date (YYYY-MM-DD) for task " + printEditPrompt + ":");
            } else {
                Input = getNextInput("Task due date (YYYY-MM-DD): ");
            }
        }
        // Error checking
        ReturnStrings[0] = "Valid";
        ReturnStrings[1] = Input;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(Input);
            if (!Input.equals(format.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            ReturnStrings[0] = "Error";
            ReturnStrings[1] = "Invalid due date.";
        }
        if (date == null) {
            ReturnStrings[0] = "Error";
            ReturnStrings[1] = "Invalid due date.";
        }
        return ReturnStrings;
    }

    public static void addListItem(TaskList List, String title, String description, String date, boolean complete) {
        String Title = "";
        String Description = "";
        String DueDate = "";
        // Input
        String[] titleRequest;
        String[] descriptionRequest;
        String[] duedateRequest;
        if (!title.equals("")) {
            // Predefined
            titleRequest = getTitle(-99, title, false);
        } else {
            titleRequest = getTitle(-99, "", true);
        }
        if (!description.equals("")) {
            // Predefined
            descriptionRequest = getDescription(-99, description, false);
        } else {
            descriptionRequest = getDescription(-99, "", true);
        }
        if (!date.equals("")) {
            // Predefined
            duedateRequest = getDueDate(-99, date, false);
        } else {
            duedateRequest = getDueDate(-99, "", true);
        }
        Title = titleRequest[1];
        Description = descriptionRequest[1];
        DueDate = duedateRequest[1];
        if (titleRequest[0].equals("Error")) {
            System.out.println(titleRequest[1]);
            return;
        }
        if (descriptionRequest[0].equals("Error")) {
            System.out.println(descriptionRequest[1]);
            return;
        }
        if (duedateRequest[0].equals("Error")) {
            System.out.println(duedateRequest[1]);
            return;
        }
        // Add item
        System.out.println("Task added.");
        TaskItem NewTask = new TaskItem(Title, Description, DueDate, complete);
        List.ListArray.add(NewTask);
    }

    public static void editListItem(TaskList List, int Index, String title, String description, String date) {
        int editIndex;
        String Title = "";
        String Description = "";
        String DueDate = "";
        // Input
        System.out.print("Which task will you edit: ");
        if (Index == -99) {
            Scanner scan = new Scanner(System.in);
            String Input = scan.next();
            String buffer = scan.nextLine();
            editIndex = Integer.parseInt(Input);
        } else {
            editIndex = Index;
        }
        // Check Index
        if (editIndex + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            return;
        }
        // Input
        String[] titleRequest;
        String[] descriptionRequest;
        String[] duedateRequest;
        if (!title.equals("")) {
            // Predefined
            titleRequest = getTitle(-99, title, false);
        } else {
            titleRequest = getTitle(-99, "", true);
        }
        if (!description.equals("")) {
            // Predefined
            descriptionRequest = getDescription(-99, description, false);
        } else {
            descriptionRequest = getDescription(-99, "", true);
        }
        if (!date.equals("")) {
            // Predefined
            duedateRequest = getDueDate(-99, date, false);
        } else {
            duedateRequest = getDueDate(-99, "", true);
        }
        Title = titleRequest[1];
        Description = descriptionRequest[1];
        DueDate = duedateRequest[1];
        if (titleRequest[0].equals("Error")) {
            System.out.println(titleRequest[1]);
            return;
        }
        if (descriptionRequest[0].equals("Error")) {
            System.out.println(descriptionRequest[1]);
            return;
        }
        if (duedateRequest[0].equals("Error")) {
            System.out.println(duedateRequest[1]);
            return;
        }
        // Edit
        System.out.println("Task edited.");
        List.ListArray.get(editIndex).Title = Title;
        List.ListArray.get(editIndex).Description = Description;
        List.ListArray.get(editIndex).DueDate = DueDate;
    }

    public static void removeListItem(TaskList List, int Index) {
        int editIndex;
        // Input
        if (Index == -99) {
            System.out.print("Which task will you edit: ");
            Scanner scan = new Scanner(System.in);
            String Input = scan.next();
            String buffer = scan.nextLine();
            editIndex = Integer.parseInt(Input);
        } else {
            editIndex = Index;
        }
        // Check Index
        if (editIndex + 1 > List.ListArray.size()) {
            System.out.println("Invalid list index.");
            return;
        }
        // Remove item
        System.out.println("Task removed.");
        List.ListArray.remove(editIndex);
    }

    public static TaskList CreateNewList() {
        return new TaskList();
    }

    public static void markItemCompleted(TaskList List, int customIndex) {
        int editIndex;
        // Input
        if (customIndex == -99) {
            System.out.print("Which task will you mark as completed? ");
            Scanner scan = new Scanner(System.in);
            String Input = scan.next();
            String buffer = scan.nextLine();
            editIndex = Integer.parseInt(Input);
        } else {
            editIndex = customIndex;
        }
        // Check Index
        if (editIndex + 1 > List.ListArray.size()) {
            System.out.println("Invalid list index.");
            return;
        }
        // Check completed
        if (List.ListArray.get(editIndex).Completed == true) {
            System.out.println("Task is already marked completed.");
            return;
        }
        // Mark completed
        List.ListArray.get(editIndex).Completed = true;
    }

    public static void unmarkItemCompleted(TaskList List, int customIndex) {
        int editIndex;
        // Input
        if (customIndex == -99) {
            System.out.print("Which task will you unmark as completed? ");
            Scanner scan = new Scanner(System.in);
            String Input = scan.next();
            String buffer = scan.nextLine();
            editIndex = Integer.parseInt(Input);
        } else {
            editIndex = customIndex;
        }
        // Check Index
        if (editIndex + 1 > List.ListArray.size()) {
            System.out.println("Invalid list index.");
            return;
        }
        // Check completed
        if (List.ListArray.get(editIndex).Completed == false) {
            System.out.println("Task is already marked incomplete.");
            return;
        }
        // Mark completed
        List.ListArray.get(editIndex).Completed = false;
    }

    public static void saveItemList(TaskList List, String fileName) throws IOException {
        // Input
        String FileName;
        if (fileName.equals("")) {
            System.out.print("Enter the filename to save as: ");
            Scanner scan = new Scanner(System.in);
            FileName = scan.next();
            String buffer = scan.nextLine();
        } else {
            FileName = fileName;
        }
        // Save
        Path newFile = Path.of(FileName);
        String TaskString = "";
        for (int i = 0; i < List.ListArray.size(); i++) {
            TaskString = TaskString + i + ") ";
            if (List.ListArray.get(i).Completed) {
                // Mark completed in main list
                TaskString = TaskString + "*** ";
            }
            TaskString = TaskString + "[" + List.ListArray.get(i).DueDate + "] ";
            TaskString = TaskString + List.ListArray.get(i).Title + ": ";
            TaskString = TaskString + List.ListArray.get(i).Description;
            TaskString = TaskString + " \r\n";
            Files.writeString(newFile, TaskString);
        }
        System.out.println("Task list has been saved.");
    }

    public static TaskList loadItemList(String fileName) throws IOException {
        TaskList NewList = CreateNewList();
        // Input
        String FileName = "";
        if (fileName.equals("")) {
            System.out.print("Enter the filename to load: ");
            Scanner scan = new Scanner(System.in);
            FileName = scan.next();
            String buffer = scan.nextLine();
        } else {
            FileName = fileName;
        }
        // Load
        Path file = Path.of(FileName);
        //String fileText = Files.readString(file);
        //System.out.print("File text: ");
        //System.out.println(file);
        try {
            File myObj = new File(FileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                //System.out.println("Reading in " + Data);
                // Task
                String taskIndex = "";
                String title = "";
                String description = "";
                String duedate = "";
                boolean taskCompleted = false;
                // Read
                int Index = 0;
                // Read Index
                String string = "";
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ')') {
                        taskIndex = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read completed
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == '[') {
                        Index = Index + 1; // Move to due date
                        break;
                    } else if (Data.charAt(i) == '*') {
                        Index = Index + 5; // Move to due date
                        taskCompleted = true;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read due date
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ']') {
                        Index = Index + 1; // Move to title
                        duedate = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read title
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ':') {
                        Index = Index + 1; // Move to description
                        title = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read description
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    // Append string
                    string = string.concat(String.valueOf(Data.charAt(i)));
                }
                description = string;
                // Add item
                addListItem(NewList, title, description, duedate, taskCompleted);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file.");
            return CreateNewList();
        }
        return NewList;
    }

    /*public static void AddTaskListToMaster(ArrayList<TaskList> Master, TaskList List) {
        Master.add(List);
    }*/

    public static void main(String[] args) throws IOException {
        //ArrayList<TaskList> TaskListsArray = new ArrayList<TaskList>();

        int resume = 0;
        boolean justLoadedList = false;
        TaskList NewList = null;
        while (resume == 0) {
            int action = 0;
            if (!justLoadedList) {
                action = startMainMenu();
            }

            if (action == 1 || justLoadedList) {
                // Create Uncomplete list
                if (!justLoadedList){
                    NewList = CreateNewList();
                    System.out.println("New list has been created.");
                } else {
                    System.out.println("List has been loaded.");
                }
                //AddTaskListToMaster(TaskListsArray, NewList);
                // Print
                int resumeListOperations = 0;
                while (resumeListOperations == 0) {
                    int listAction = startListOperationsMenu();
                    if (listAction == 1) {
                        // Print list
                        printList(NewList, 1);
                    } else if (listAction == 2) {
                        // Add item
                        addListItem(NewList, "", "", "", false);
                    } else if (listAction == 3) {
                        // Print list
                        printList(NewList, 1);
                        // Edit item
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to edit.");
                        } else {
                            editListItem(NewList, -99, "", "", "");
                        }
                    } else if (listAction == 4) {
                        // Print list
                        printList(NewList, 1);
                        // Remove item
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to remove.");
                        } else {
                            removeListItem(NewList, -99);
                        }
                    } else if (listAction == 5) {
                        // Print list
                        int relevantTasks = printList(NewList, 3);
                        // Mark item completed
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to mark up.");
                        } else {
                            if (relevantTasks > 0) {
                                markItemCompleted(NewList, -99);
                            }
                        }
                    } else if (listAction == 6) {
                        // Print list
                        int relevantTasks = printList(NewList, 2);
                        // Unmmark item completed
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to mark up.");
                        } else {
                            if (relevantTasks > 0) {
                                unmarkItemCompleted(NewList, -99);
                            }
                        }
                    } else if (listAction == 7) {
                        // Save list
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to save.");
                        } else {
                            saveItemList(NewList, "");
                        }
                    } else if (listAction == 8) {
                        // Back to main menu
                        resumeListOperations = 1;
                    }
                }
                NewList = null;
                justLoadedList = false;
            } else if (action == 2) {
                // Load list
                NewList = loadItemList("");
                justLoadedList = true;
            } else {
                // Quit
                resume = 1;
                justLoadedList = false;
            }
        }
    }
}
