import java.math.BigDecimal;
import java.math.BigInteger;

public class Assignments_Q2 {
    public static void main(String[] args) {
        // Q2
        System.out.println("\nQ2");
        // ---
        // 1. Find the magic number
        //
        // A number is magic if:
        // - the value of the first 1 digits is divisible by 1
        // - the value of the first 1-2 digits is divisible by 2
        // - the value of the first 1-3 digits is divisible by 3
        // - ...
        // - the value of the first 1-10 digits is divisible by 10
        //
        // ---
        while (true) assignments_q2();
    }

    public static String assignments_q2_doubleToString(Double n) {
        return n == null ? "" : new BigDecimal(n).toPlainString();
    }

    public static Double assignments_q2_stringToDouble(String n) {
        return n.equals("") ? 0d : Double.parseDouble(n);
    }

    public static Double assignments_q2_traverse(Double range, Double value, int stack) {
        stack += 1;

        // ~
        for (int n = value == null ? 1 : 0; n <= 9; ++n) {
            // ~ Double type Concatenate 'value' and 'i' -> 12 + 3 = 123
            String foundValueString = assignments_q2_doubleToString(value) + n;
            Double foundValue = assignments_q2_stringToDouble(foundValueString);

            // ~
            if (foundValue % stack == 0) {
                System.out.println("stack: " + stack + "\tfoundValue: " + foundValueString);

                Double childValue = stack >= range
                        ? foundValue
                        : assignments_q2_traverse(range, foundValue, stack);

                if (childValue != null) return childValue; // Search has resolved~
            }
        }

        return null;
    }

    public static void assignments_q2() {
        // ---
        System.out.println("Enter an integer as the length of the magic number:");
        int digits = new java.util.Scanner(System.in).nextInt();
        double range = assignments_q2_doubleToString(Math.pow(10, digits) - 1).length();
        // ---

        // ~ Find the thing
        Double result = assignments_q2_traverse(range, null, 0);
        String resultString = assignments_q2_doubleToString(result);

        // ---
        System.out.println(resultString.equals("") // 'result' may be null... idk/ when but it may...
                ? "\nNo magic number with " + digits + " Digits found.\n"
                : "\nFirst magic number with " + digits + " Digits found was " + resultString + ".\n");
        // ---
    }
}
