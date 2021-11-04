import java.math.BigDecimal;
import java.math.BigInteger;

public class Assignments_Q2 {
    public static void main(String[] args) {
        // Q2
        System.out.println("\nQ2");
        // ---
        // 1. Find the magic numbers
        //
        // A number is magic if:
        // - the value of the first 1   digits are divisible by 1
        // -                        1-2            divisible by 2
        // -                        1-3            divisible by 3
        // - ...                    ...            ...
        // -                        1-10           divisible by 10
        // ---
        while (true) assignments_q2();
//        assignments_q2();
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
            // ~ Concatenate 'value' and 'i' -> 12_3 = 123
            String plainValue = assignments_q2_doubleToString(value);
            Double joindValue = assignments_q2_stringToDouble(plainValue + n);

            if (joindValue % stack == 0) {
                System.out.println("stack: " + stack + "\tfound: " + plainValue + "_" + n);

                // ~ Return if done or concatenate the next digit
                Double childValue = stack >= range - 1
                        ? joindValue
                        : assignments_q2_traverse(range, joindValue, stack);

                if (childValue != null) return childValue; // Search has resolved~
            }
        }

        return null; // Null results for range > 17
    }

    public static void assignments_q2() {
        // ---
        System.out.println("\nEnter an integer as the length of the magic number:");
        int digits = new java.util.Scanner(System.in).nextInt();
        double range = assignments_q2_doubleToString(Math.pow(10, digits) - 1).length();
//        for (int digits = 1; digits < 50; ++digits) {
//            double range = assignments_q2_doubleToString(Math.pow(10, digits) - 1).length();
        // ---

        // ~ Find the thing
        Double result = assignments_q2_traverse(range, null, 0);
        String plainResult = assignments_q2_doubleToString(result);

        // f(4) = _1 mod 1 = 0
        //         |
        //         > 1_0 mod 2 = 0
        //             |
        //             > 10_0 mod 3 = 1
        //             > 10_1 mod 3 = 2
        //             > 10_2 mod 3 = 0
        //                  |
        //                  > 102_0 mod 4 = 0
        //                        |
        //                        >  return 1020; final state reached: depth > range
        //      = 1020
        //
        // 1    mod 1 = 0
        // 10   mod 2 = 0
        // 102  mod 3 = 0
        // 1020 mod 5 = 0

        // ---
        System.out.println(plainResult.equals("")
                ? "\nNo magic number with " + digits + " Digits found."
                : "\nFirst magic number with " + digits + " Digits found was " + plainResult + ".");
//        }
        // ---
    }
}
