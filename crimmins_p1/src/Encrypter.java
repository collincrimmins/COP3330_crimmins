public class Encrypter {
    public static int getMathEncryption(int Number) {
        return (Number + 7) % 10;
    }

    public static String getResultAsString(int r1, int r2, int r3, int r4) {
        String NewString = Integer.toString(r3) + Integer.toString(r4) + Integer.toString(r1) + Integer.toString(r2);
        //System.out.println(NewString);
        return NewString;
    }

    public static String encrypt(String Input) {
        //System.out.println("Input " + Input);
        int digit1 = Input.charAt(0) - '0';
        int digit2 = Input.charAt(1) - '0';
        int digit3 = Input.charAt(2) - '0';
        int digit4 = Input.charAt(3) - '0';
        int result1 = getMathEncryption(digit1);
        int result2 = getMathEncryption(digit2);
        int result3 = getMathEncryption(digit3);
        int result4 = getMathEncryption(digit4);
        return getResultAsString(result1, result2, result3, result4);
    }

    //public static void main(String[] args) {

    //}
}