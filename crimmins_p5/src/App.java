import java.io.IOException;
import java.util.Scanner;

public class App {
    public static int startMainMenu() {
        // Print
        System.out.println("Select an Application");
        System.out.println("--------");
        System.out.println(" ");
        System.out.println("1) Task List");
        System.out.println("2) Contact List");
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

    public static void main(String[] args) throws IOException {
        int resume = 0;
        while (resume == 0) {
            int action = startMainMenu();
            if (action == 1) {
                // Load Task List
                try {
                    TaskApp.MainFunction();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action == 2) {
                // Load Contact List
                ContactApp.MainFunction();
            } else {
                // Quit
                resume = 1;
            }
        }
    }
}
