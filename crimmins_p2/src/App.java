import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static boolean moreInput() {
        // Prompt Y or N to continue
        System.out.println("Continue?");
        // Input
        Scanner scan = new Scanner(System.in);
        String Input = scan.next();
        // Buffer
        String buffer = scan.nextLine();
        if (Input.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public static double getUserHeight() {
        System.out.println("Height?");
        int good = 0;
        String Input = "";
        while (good == 0) {
            // Input
            Scanner scan = new Scanner(System.in);
            Input = scan.next();
            // Buffer
            String buffer = scan.nextLine();
            // Negative
            if ((Double.valueOf(Input)) > 0) {
                good = 1;
            } else {
                System.out.println("Enter non-negative.");
            }
        }
        return Double.valueOf(Input);
    }

    public static double getUserWeight() {
        System.out.println("Weight?");
        int good = 0;
        String Input = "";
        while (good == 0) {
            // Input
            Scanner scan = new Scanner(System.in);
            Input = scan.next();
            // Buffer
            String buffer = scan.nextLine();
            // Negative
            if ((Double.valueOf(Input)) > 0) {
                good = 1;
            } else {
                System.out.println("Enter non-negative.");
            }
        }
        return Double.valueOf(Input);
    }

    public static void displayBmiInfo(BodyMassIndex object) {
        System.out.println("BMI: " + object.BMI);
        System.out.println("BMI Category: " + object.BMICategory);
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double sum = 0;
        int arraySize = bmiData.size();
        for (int i = 0; i < arraySize; i++) {
            sum = sum + bmiData.get(i).BMI;
        }
        double average = sum / arraySize;
        System.out.println("BMI Average: " + average);
    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
