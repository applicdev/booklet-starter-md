public class Assignments_Q2 {
    public static void main(String[] args) {
        // Q2
        System.out.println("\nQ2");
        // ---

        // ~ a & b
        System.out.println("\n~ a & b");
        // ---
        assignments_q2_a_b();

        // ~ b
        System.out.println("\n~ c");
        // ---
        assignments_q2_c();
    }

    public static void assignments_q2_a_b() {
        for (int n = 0; n <= 8; n++)
            for (int m = 0; m <= 8; m++)
                if (m == 8)
                    System.out.print("" + n + "-" + m + "\n");
                else
                    System.out.print("" + n + "-" + m + ",\t");

    }

    public static void assignments_q2_c() {
        System.out.println("Enter an integer for grid width");
        int width = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer for grid height");
        int height = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: width:= " + width + " height:= " + height);

        for (int n = 0; n <= height; n++)
            for (int m = 0; m <= width; m++)
                if (m == width)
                    System.out.print("" + n + "-" + m + "\n");
                else
                    System.out.print("" + n + "-" + m + ",\t");
    }
}
