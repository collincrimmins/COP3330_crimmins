import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    @org.junit.jupiter.api.Test
    void getBMIScore() {
        BodyMassIndex bmi = new BodyMassIndex(10, 10);
        assertEquals(70.3, BodyMassIndex.getBMIScore(bmi));
    }

    @org.junit.jupiter.api.Test
    void getBMICategory() {
        assertEquals("Underweight", BodyMassIndex.getBMICategory(10));
    }

    @org.junit.jupiter.api.Test
    void getBMICategory2() {
        assertEquals("Normal weight", BodyMassIndex.getBMICategory(19));
    }

    @org.junit.jupiter.api.Test
    void getBMICategory3() {
        assertEquals("Overweight", BodyMassIndex.getBMICategory(26));
    }

    @org.junit.jupiter.api.Test
    void getBMICategory4() {
        assertEquals("Obesity", BodyMassIndex.getBMICategory(30));
    }
}
