public class Assignments_Q3 {
    public static void main(String[] args) {
        // Q3
        System.out.println("\nQ3");
        // ---

        // ~ a
        System.out.println("\n~ a");
        // ---
        // 1. print a stack of "*"
        //
        // @example
        // f() => ~*
        //        ~* *
        //        ~* * *
        //        ~* * * *
        //        ~* * * * *
        //        ~* * * * * *
        // ---
        assignments_q3_a();

        // ~ a
        System.out.println("\n~ b");
        // ---
        // 1. print a stack of "*"
        //
        // @example
        // f() => ~     *
        //        ~    * *
        //        ~   * * *
        //        ~  * * * *
        //        ~ * * * * *
        //        ~* * * * * *
        // ---
        assignments_q3_b();
    }

    public static void assignments_q3_a() {
        System.out.println("Enter an integer for how many lines * should increase");
        int lines = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: lines:= " + lines);

        for (int n = 0; n <= lines; n++)
            for (int m = 0; m <= n; m++)
                System.out.print(m == n ? "*\n" : "* ");
    }

    public static void assignments_q3_b() {
        System.out.println("Enter an integer for how many lines * should increase");
        int lines = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: lines:= " + lines);

        for (int n = 0; n <= lines; n++) {
            for (int o = 0; o <= lines - n - 1; o++)
                System.out.print(" ");
            for (int m = 0; m <= n; m++)
                System.out.print(m == n ? "*\n" : "* ");
        }
    }
}
