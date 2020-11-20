import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContactApp {
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
        System.out.println("Contact List Operations Menu");
        System.out.println("--------");
        System.out.println(" ");
        System.out.println("1) view list");
        System.out.println("2) add item");
        System.out.println("3) edit item");
        System.out.println("4) remove item");
        System.out.println("5) save list");
        System.out.println("6) back to main menu");
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

    public static String[] getContactFirstName(ContactList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).FirstName;
        return ReturnStrings;
    }

    public static String[] getContactLastName(ContactList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).LastName;
        return ReturnStrings;
    }

    public static String[] getContactPhoneNumber(ContactList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).PhoneNumber;
        return ReturnStrings;
    }

    public static String[] getContactEmailAddress(ContactList List, int Index) {
        String[] ReturnStrings = {"Valid", ""};
        if (Index + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            ReturnStrings[0] = "Error";
            return ReturnStrings;
        }
        ReturnStrings[1] = List.ListArray.get(Index).EmailAddress;
        return ReturnStrings;
    }

    public static String getPrintListString(ContactList List) {
        String ReturnString = "";
        // Print
        System.out.println("Contacts");
        System.out.println("--------");
        System.out.println(" ");
        int relevantTasks = 0;
        // Print List
        for (int i = 0; i < List.ListArray.size(); i++) {
            relevantTasks = relevantTasks + 1;
            ReturnString = ReturnString + ") ";
            ReturnString = ReturnString + getContactFirstName(List, i)[1] + " " + getContactLastName(List, i)[1];
            ReturnString = ReturnString + getContactPhoneNumber(List, i)[1];
            ReturnString = ReturnString + getContactEmailAddress(List, i)[1];
        }
        return ReturnString;
    }

    public static int printList(ContactList List, int Type) {
        // Print
        System.out.println("Contacts");
        System.out.println("--------");
        System.out.println(" ");
        int relevantTasks = 0;
        // Print List
        for (int i = 0; i < List.ListArray.size(); i++) {
            relevantTasks = relevantTasks + 1;
            System.out.print(i + ") ");
            System.out.println("Name: " + getContactFirstName(List, i)[1] + " " + getContactLastName(List, i)[1]);
            System.out.println("Phone: " + getContactPhoneNumber(List, i)[1]);
            System.out.println("Email: " + getContactEmailAddress(List, i)[1]);
        }
        System.out.println(" ");
        return relevantTasks;
    }

    public static String getNextInput(String Message) {
        if (!Message.equals("")) {
            System.out.print(Message);
        }
        String Input = "";
        Scanner fileScanner = new Scanner(System.in);
        String line = fileScanner.nextLine();
        Scanner lineScanner = new Scanner(line);
        while (lineScanner.hasNext()) {
            Input = lineScanner.next();
        }
        return Input;
    }

    public static String[] getFirstName(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // Title
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new First Name for " + printEditPrompt + ":");
            } else {
                Input = getNextInput("First Name: ");
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

    public static String[] getLastName(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // Description
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new LastName for " + printEditPrompt + ":");
            } else {
                Input = getNextInput("Last Name: ");
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

    public static String[] getPhoneNumber(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // DueDate
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new phone number (xxx-xxx-xxxx) for " + printEditPrompt + ":");
            } else {
                Input = getNextInput("Enter phone number (xxx-xxx-xxxx): ");
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

    public static String[] getEmail(int printEditPrompt, String Input, boolean PromptInput) {
        String[] ReturnStrings = {"", ""};
        // Description
        if (PromptInput == true) {
            if (printEditPrompt != -99) {
                Input = getNextInput("Enter a new Email for " + printEditPrompt + ":");
            } else {
                Input = getNextInput("Email: ");
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

    public static String[] addListItem(ContactList List, String firstname, String lastname, String phonenumber, String email, boolean takeInput) {
        String FirstName = "";
        String LastName = "";
        String PhoneNumber = "";
        String EmailAddress = "";
        // Input
        String[] firstnameRequest;
        String[] lastnameRequest;
        String[] phonenumberRequest;
        String[] emailRequest;
        if (!firstname.equals("") || !takeInput) {
            // Predefined
            firstnameRequest = getFirstName(-99, firstname, false);
        } else {
            firstnameRequest = getFirstName(-99, "", true);
        }
        if (!lastname.equals("") || !takeInput) {
            // Predefined
            lastnameRequest = getLastName(-99, lastname, false);
        } else {
            lastnameRequest = getLastName(-99, "", true);
        }
        if (!phonenumber.equals("") || !takeInput) {
            // Predefined
            phonenumberRequest = getPhoneNumber(-99, phonenumber, false);
        } else {
            phonenumberRequest = getPhoneNumber(-99, "", true);
        }
        if (!email.equals("") || !takeInput) {
            // Predefined
            emailRequest = getEmail(-99, email, false);
        } else {
            emailRequest = getEmail(-99, "", true);
        }
        FirstName = firstnameRequest[1];
        LastName = lastnameRequest[1];
        PhoneNumber = phonenumberRequest[1];
        EmailAddress = phonenumberRequest[1];
        String[] ReturnStrings = {"", ""};
        ReturnStrings[0] = "Error";
        int invalidContactItems = 0;
        if (firstnameRequest[0].equals("Error")) {
            //System.out.println(firstnameRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            FirstName = "";
        }
        if (lastnameRequest[0].equals("Error")) {
            //System.out.println(lastnameRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            LastName = "";
        }
        if (phonenumberRequest[0].equals("Error")) {
            //System.out.println(phonenumberRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            PhoneNumber = "";
        }
        if (emailRequest[0].equals("Error")) {
            //System.out.println(phonenumberRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            EmailAddress = "";
        }
        if (invalidContactItems == 4) {
            System.out.println("Must have 1 valid item to save Contact.");
            return ReturnStrings;
        }
        ReturnStrings[0] = "Valid";
        // Add item
        System.out.println("Contact added.");
        ContactItem NewContact = new ContactItem(FirstName, LastName, PhoneNumber, EmailAddress);
        List.ListArray.add(NewContact);
        return ReturnStrings;
    }

    public static String[] editListItem(ContactList List, int Index, String firstname, String lastname, String phonenumber, String email, boolean takeInput) {
        int editIndex;
        String FirstName = "";
        String LastName = "";
        String PhoneNumber = "";
        String EmailAddress = "";
        // Input
        System.out.print("Which Contact will you edit: ");
        if (Index == -99) {
            Scanner scan = new Scanner(System.in);
            String Input = scan.next();
            String buffer = scan.nextLine();
            editIndex = Integer.parseInt(Input);
        } else {
            editIndex = Index;
        }
        // Check Index
        String[] ReturnStrings = {"", ""};
        ReturnStrings[0] = "Error";
        if (editIndex + 1 > List.ListArray.size()) {
            System.out.print("Invalid list index.");
            return ReturnStrings;
        }
        // Input
        String[] firstnameRequest;
        String[] lastnameRequest;
        String[] phonenumberRequest;
        String[] emailRequest;
        if (!firstname.equals("") || !takeInput) {
            // Predefined
            firstnameRequest = getFirstName(-99, firstname, false);
        } else {
            firstnameRequest = getFirstName(-99, "", true);
        }
        if (!lastname.equals("")|| !takeInput) {
            // Predefined
            lastnameRequest = getLastName(-99, lastname, false);
        } else {
            lastnameRequest = getLastName(-99, "", true);
        }
        if (!phonenumber.equals("")|| !takeInput) {
            // Predefined
            phonenumberRequest = getPhoneNumber(-99, phonenumber, false);
        } else {
            phonenumberRequest = getPhoneNumber(-99, "", true);
        }
        if (!email.equals("")|| !takeInput) {
            // Predefined
            emailRequest = getEmail(-99, email, false);
        } else {
            emailRequest = getEmail(-99, "", true);
        }
        FirstName = firstnameRequest[1];
        LastName = lastnameRequest[1];
        PhoneNumber = phonenumberRequest[1];
        EmailAddress = emailRequest[1];
        int invalidContactItems = 0;
        if (firstnameRequest[0].equals("Error")) {
            //System.out.println(firstnameRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            FirstName = "";
        }
        if (lastnameRequest[0].equals("Error")) {
            //System.out.println(lastnameRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            LastName = "";
        }
        if (phonenumberRequest[0].equals("Error")) {
            //System.out.println(phonenumberRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            PhoneNumber = "";
        }
        if (emailRequest[0].equals("Error")) {
            //System.out.println(phonenumberRequest[1]);
            invalidContactItems = invalidContactItems + 1;
            EmailAddress = "";
        }
        if (invalidContactItems == 4) {
            System.out.println("Must have 1 valid item to save Contact.");
            return ReturnStrings;
        }
        ReturnStrings[0] = "Valid";
        // Edit
        System.out.println("Contact edited.");
        List.ListArray.get(editIndex).FirstName = FirstName;
        List.ListArray.get(editIndex).LastName = LastName;
        List.ListArray.get(editIndex).PhoneNumber = PhoneNumber;
        List.ListArray.get(editIndex).EmailAddress = EmailAddress;
        return ReturnStrings;
    }

    public static String[] removeListItem(ContactList List, int Index) {
        int editIndex;
        String[] ReturnStrings = {"", ""};
        ReturnStrings[0] = "Error";
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
            return ReturnStrings;
        }
        ReturnStrings[0] = "Valid";
        // Remove item
        System.out.println("Task removed.");
        List.ListArray.remove(editIndex);
        return ReturnStrings;
    }

    public static ContactList CreateNewList() {
        return new ContactList();
    }

    public static void saveItemList(ContactList List, String fileName) throws IOException {
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
            String FirstName = List.ListArray.get(i).FirstName;
            String LastName = List.ListArray.get(i).LastName;
            String PhoneNumber = List.ListArray.get(i).PhoneNumber;
            String EmailAddress = List.ListArray.get(i).EmailAddress;
            if (List.ListArray.get(i).FirstName.equals("")) {
                FirstName = "null";
            }
            if (List.ListArray.get(i).LastName.equals("")) {
                LastName = "null";
            }
            if (List.ListArray.get(i).PhoneNumber.equals("")) {
                PhoneNumber = "null";
            }
            if (List.ListArray.get(i).EmailAddress.equals("")) {
                EmailAddress = "null";
            }
            TaskString = TaskString + i + ") Name: ";
            TaskString = TaskString + FirstName + " " + LastName;
            TaskString = TaskString + " ";
            //TaskString = TaskString + " \r\n";
            TaskString = TaskString + "Phone: " + PhoneNumber;
            TaskString = TaskString + " ";
            //TaskString = TaskString + " \r\n";
            TaskString = TaskString + "Email: " + EmailAddress;
            TaskString = TaskString + " \r\n";
            Files.writeString(newFile, TaskString);
        }
        System.out.println("Task list has been saved.");
    }

    public static ContactList loadItemList(String fileName) throws IOException {
        ContactList NewList = CreateNewList();
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
        try {
            File myObj = new File(FileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                // Task
                String taskIndex = "";
                String firstName = "";
                String lastName = "";
                String phoneNumber = "";
                String emailAddress = "";
                // Read
                int Index = 0;
                // Read Index
                String string = "";
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ')') {
                        Index = Index + 8;
                        taskIndex = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read First Name
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ' ') {
                        Index = Index + 1;
                        firstName = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read Last Name
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ' ') {
                        Index = Index + 8; // Move to Phone Number
                        lastName = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                string = "";
                // Read Phone Number
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ' ') {
                        Index = Index + 7; // Move to Email
                        phoneNumber = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                // Read Email Address
                for (int i = Index; i < Data.length(); i++) {
                    Index = i;
                    if (Data.charAt(i) == ' ') {
                        Index = Index;
                        emailAddress = string;
                        break;
                    } else {
                        // Append string
                        string = string.concat(String.valueOf(Data.charAt(i)));
                    }
                }
                // Check
                if (firstName.equals("null")) {
                    firstName = "";
                }
                if (lastName.equals("null")) {
                    lastName = "";
                }
                if (phoneNumber.equals("null")) {
                    phoneNumber = "";
                }
                if (emailAddress.equals("null")) {
                    emailAddress = "";
                }
                //System.out.println("[" + taskIndex + "] [" + firstName + "] [" + lastName + "] [" + phoneNumber + "] [" + emailAddress + "]");
                // Add item
                addListItem(NewList, firstName, lastName, phoneNumber, emailAddress, false);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file.");
            return CreateNewList();
        }
        return NewList;
    }

    public static void MainFunction() throws IOException {
        int resume = 0;
        boolean justLoadedList = false;
        ContactList NewList = null;
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
                // Print
                int resumeListOperations = 0;
                while (resumeListOperations == 0) {
                    int listAction = startListOperationsMenu();
                    if (listAction == 1) {
                        // Print list
                        printList(NewList, 1);
                    } else if (listAction == 2) {
                        // Add item
                        addListItem(NewList, "", "", "", "", true);
                    } else if (listAction == 3) {
                        // Print list
                        printList(NewList, 1);
                        // Edit item
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to edit.");
                        } else {
                            editListItem(NewList, -99, "", "", "", "", true);
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
                        // Save list
                        if (NewList.ListArray.size() == 0) {
                            System.out.println("No list to save.");
                        } else {
                            saveItemList(NewList, "");
                        }
                    } else if (listAction == 6) {
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
