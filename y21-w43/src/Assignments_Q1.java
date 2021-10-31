public class Assignments_Q1 {
    public static void main(String[] args) {
        // Q4
        System.out.println("\nQ1");
        // ---
        // 1. Read an integer input
        // 2. Output its checksum
        //
        //    n!
        // --------  =  n choose r
        // r!(n-r)!
        //
        // m : total number of possible numbers
        // r : numbers of numbers chosen
        //
        // @example
        // f(46 choose 6) = 9366819
        // ---
        while (true) assignments_q1();
        // ---
    }


    public static void assignments_q1() {
        System.out.println("Enter an integer as range");
        int ran = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer of how many to choose");
        int cho = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: range:= " + ran + " choose:= " + cho);

        // ~
        java.lang.Long result = assignments_q1_binomialCoefficient(ran, cho);
        System.out.println(result == null
                ? "Coefficient too large; Input smaller numbers~\n"
                : "result: " + ran + " choose " + cho + " = " + result + "\n");

        // ~
        System.out.println(result == null ? ""
                : "Given a lottery with " + ran + " possible numbers and " + cho
                + " to choose from, the possibility to match all " + cho + " is 1:" + result + ".\n");
    }

    private static java.lang.Long assignments_q1_binomialCoefficient(int r, int k) {
        // Concept:
        // ~ Finding a function
        //
        //         10! = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
        //          7! =              7 * 6 * 5 * 4 * 3 * 2 * 1
        //     (10-7)! =                              3 * 2 * 1
        //
        // 10 choose 7 =      10!                                     |  issue: n! gets huge fast
        //               --------------                               |  int  max. n! -> 12!
        //                7! * (10-7)!                                |  long max. n! -> 20!
        //
        //             =   10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1     |
        //               -------------------------------------------  | "7 * 6 * 5 * 4 * 3 * 2 * 1" cancel out
        //                (7 * 6 * 5 * 4 * 3 * 2 * 1) * (3 * 2 * 1)   |
        //
        //             =   10 * 9 * 8                                 |
        //               -------------------------------------------  | can be rewritten to prevent large numbers
        //                                               3 * 2 * 1    |
        //
        //             =  (10 / 1) * (9 / 2) * 8 / 3                  | looks loopable; something... something... --n, ++m
        //
        //             =  120
        //
        //
        // ~ Inverse 'k' values share the same coefficient
        //
        //         10! = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
        //          3! =                              3 * 2 * 1
        //     (10-3)! =              7 * 6 * 5 * 4 * 3 * 2 * 1
        //
        // 10 choose 3 =      10!        =      10!
        //               --------------    --------------
        //                3! * (10-3)!      7! * (10-7)!
        //
        //             = 10 choose 7

        // Solution:
        // ~ Use the inverse of 'k' if fewer steps are required
        // a.e.
        // 10 choose 7 == 120; requires 7 steps
        // 10 choose 3 == 120; requires 3 steps
        if (k > r * 0.5F) k = r - k;

        // ~ Calculate the binomial coefficient of (r choose k)
        // a.e.
        // 10 choose 10 =   1
        //              = (((((((((1 * 10 / 1) * 9 / 2) * 8 / 3) * 7 / 4) * 6 / 5) * 5 / 6) * 4 / 7) * 3 / 8) * 2 / 9) * 1 / 10
        //
        // 10 choose  6 = 210
        //              = (((((1 * 10 / 1) * 9 / 2) * 8 / 3) * 7 / 4) * 6 / 5) * 5 / 6
        long result = 1L;
        for (int n = r, m = 1; m <= k; --n, ++m) {
            result = result * n / m;
            if (result < 0) return null; // err; integer overflow
        }
        return result;
    }
}
