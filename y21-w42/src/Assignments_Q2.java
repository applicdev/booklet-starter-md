public class Assignments_Q2 {
    public static void main(String[] args) {
        // Q2
        System.out.println("\nQ2");
        // ---

        // ~ a & b
        System.out.println("\n~ a & b");
        // ---
        // 1. output:
        // 1 2  3  4 ...  8
        // 2 3  4  5 ...  9
        // .
        // .
        // .
        // 8 9 10 11 ... 15
        // ---
        assignments_q2_a_b();

        // ~ b
        System.out.println("\n~ c");
        // ---
        // 1. output:
        // n+1 n+2  n+3  n+4 ...  n+8
        // n+2 n+3  n+4  n+5 ...  n+9
        // .
        // .
        // .
        // n+8 n+9 n+10 n+11 ... n+15
        // ---
        assignments_q2_c();
    }

    public static String indentToInclude(int value, int reference) {
        String val = "" + value;
        while (val.length() < ("" + reference).length()) val = " " + val;
        return val;
    }

    public static void assignments_q2_a_b() {
        for (int n = 1; n <= 8; n++)
            for (int m = 0; m < 8; m++)
                System.out.print(m == 0
                        ? indentToInclude(n + m, 8) : m != (8 - 1)
                        ? " " + indentToInclude(n + m, 15)
                        : " " + indentToInclude(n + m, 15) + "\n");
    }

    public static void assignments_q2_c() {
        System.out.println("Enter an integer as the start value");
        int val = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer for the grid width");
        int wid = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer for the grid height");
        int hei = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: inital_value:= " + val + " width:= " + wid + " height:= " + hei);

        for (int n = 0; n <= hei - 1; n++)
            for (int m = 0; m < wid; m++)
                System.out.print(m == 0
                        ? indentToInclude(val + n + m, hei - 1) : m != (wid - 1)
                        ? " " + indentToInclude(val + n + m, val + wid + hei - 1)
                        : " " + indentToInclude(val + n + m, val + wid + hei - 1) + "\n");
    }
}
