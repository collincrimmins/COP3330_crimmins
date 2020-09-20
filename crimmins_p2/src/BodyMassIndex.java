import java.lang.Math;

public class BodyMassIndex {
    public final double height;
    public final double weight;
    public final double BMI;
    public final String BMICategory;

    public BodyMassIndex(double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.BMI = getBMIScore(this);
        this.BMICategory = getBMICategory(BMI);
    }

    public static double getBMIScore(BodyMassIndex bmi) {
        return 703 * bmi.weight / Math.pow(bmi.height, 2);
    }

    public static String getBMICategory(double BMI) {
        if (BMI >= 30) {
            return "Obesity";
        } else if (BMI >= 25) {
            return "Overweight";
        } else if (BMI >= 18.5) {
            return "Normal weight";
        } else {
            return "Underweight";
        }
    }
}
