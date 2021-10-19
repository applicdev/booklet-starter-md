public class Assignments1_Q2 {
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
        // 8 9 10 11 ... 16
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
        // n+8 n+9 n+10 n+11 ... n+16
        // ---
        assignments_q2_c();
    }

    public static void assignments_q2_a_b() {
        for (int n = 0; n <= 8; n++)
            for (int m = 0; m <= 8; m++)
                System.out.print("" + (n + m) + (m == 8 ? "\n" : ",\t"));
    }

    public static void assignments_q2_c() {
        System.out.println("Enter an integer as the start value");
        int x = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer for the grid width");
        int width = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer for the grid height");
        int height = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: width:= " + width + " height:= " + height);

        for (int n = 0; n <= height; n++)
            for (int m = 0; m <= width; m++)
                System.out.print("" + (x + n + m) + (m == width ? "\n" : ",\t"));
    }
}
