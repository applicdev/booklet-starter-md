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
        // - a value to any digit (0-9) can only be used once
        // - the value of the first 1   digits are divisible by 1
        // -                        1-2            divisible by 2
        // -                        1-3            divisible by 3
        // - ...                    ...            ...
        // -                        1-10           divisible by 10
        // ---

        // ~ recursive search
//        assignments_q2_a(false); // Found up to 18 -> 120054249048585600
        assignments_q2_a(true); // Found up to 10 -> 3816547290

        // ~ linear search
//        assignments_q2_b(false); // Found up to 25 -> 3608528850368400786036725
        assignments_q2_b(true); // Found up to 10 -> 3816547290
    }

    public static String assignments_q2_a_doubleToString(Double n) {
        return n == null ? "" : new BigDecimal(n).toPlainString();
    }

    public static Double assignments_q2_a_stringToDouble(String n) {
        return n.equals("") ? 0d : Double.parseDouble(n);
    }

    public static Double assignments_q2_a_traverse(boolean uniqueDigits, int range, Double value, int stack) {
        stack += 1;

        // ~
        for (int n = value == null ? 1 : 0; n <= Math.min(range - 1, 9); ++n) {
            // ~ Concatenate 'value' and 'i' -> 12_3 = 123
            String plainValue = assignments_q2_a_doubleToString(value);
            Double joindValue = assignments_q2_a_stringToDouble(plainValue + n);
            boolean unique = !uniqueDigits || !plainValue.contains(String.valueOf(n));

            if (joindValue % stack == 0 && unique) {
                System.out.println("range:" + range + "\tstack: " + stack + "\tfound: " + plainValue + "_" + n);

                // ~ Return if done or concatenate the next digit
                Double childValue = stack > range - 1
                        ? joindValue
                        : assignments_q2_a_traverse(uniqueDigits, range, joindValue, stack);

                if (childValue != null) return childValue; // Search has resolved~
            }
        }

        return null;
    }

    public static void assignments_q2_a(boolean uniqueDigits) {
        // ---
        System.out.println("\nEnter an integer as the length of the magic number:");
        int digits = new java.util.Scanner(System.in).nextInt();

//        for (int digits = 1; digits < 50; ++digits) {
//            double range = assignments_q2_doubleToString(Math.pow(10, digits) - 1).length();
        // ---

        // ~ Find the thing
        Double result = assignments_q2_a_traverse(uniqueDigits, digits, null, 0);
        String plainResult = assignments_q2_a_doubleToString(result);

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

    public static void assignments_q2_b(boolean uniqueDigits) {
        // ---
        System.out.println("\nEnter an integer as the length of the magic number:");
        int digits = new java.util.Scanner(System.in).nextInt();
        // ---

        BigInteger result = new BigInteger("0");

        int[] positionCache = new int[digits];
        String[] resultCache = new String[digits];

        for (int n = 0, m = 1; ; ++m) {
            // Generally the same search pattern used as in Q2.a,
            // but with cached state history instead of recursion.
            //
            //  |--n----|
            //   10_____
            //     ^
            //    'm' a value (between 0 and 9) of the digit at position 'n'

            // ~ none possible at all; null case
            if (m > Math.min(digits - 1, 9) && n == 0) {
                result = new BigInteger("-1");
                break;
            }

            // ~ none possible in current path; move back up
            if (m > Math.min(digits - 1, 9)) {
                --n;
                result = new BigInteger(resultCache[n]);
                m = positionCache[n];
                continue;
            }

            // ~ check next 'm'
            BigInteger resultNext = result
                    .multiply(new BigInteger("10"))
                    .add(new BigInteger(String.valueOf(m)));
            BigInteger mod = new BigInteger(String.valueOf(n + 1));

            boolean unique = !uniqueDigits || !result.toString().contains(String.valueOf(m));
            boolean divisible = new BigInteger("0").equals(resultNext.mod(mod));

            if (divisible && unique) {
                System.out.println("n: " + n + "\tm: " + m + "\tmod: " + mod + "\tvalue: " + resultNext);

                resultCache[n] = result.toString();
                positionCache[n] = m;

                result = resultNext;
                m = -1;
                ++n;

                if (result.toString().length() >= digits) break;
            }
        }

        // ---
        String plainResult = result.toString();

        if (!plainResult.equals("-1")) for (int i = 1; i <= resultCache.length; ++i)
            System.out.print(i < resultCache.length
                    ? "\n" + resultCache[i] + " ≡ 0 (mod " + i + ")"
                    : "\n" + plainResult + " ≡ 0 (mod " + digits + ")\n");

        System.out.println(plainResult.equals("-1")
                ? "\nNo magic number with " + digits + " Digits found."
                : "\nFirst magic number with " + digits + " Digits found was " + plainResult + ".");
        // ---
    }
}
