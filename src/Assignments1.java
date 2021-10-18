import java.util.Scanner;

public class Assignments1 {
    public static void main(String[] args) {
        // Q1
        System.out.println("\nQ1");
        // ---

        // ~ a
        System.out.println("\n~ a");
        // ---
        int a = 3;
        int b = 3 + 2;
        int c = 6 / a;
        int d = b % a;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);

        // ~ b
        System.out.println("\n~ b");
        // ---
        float f = 3f;
        float g = f + 2;
        float h = g / f;
        float i = f % f;

        System.out.println("f: " + f);
        System.out.println("g: " + g);
        System.out.println("h: " + h);
        System.out.println("i: " + i);

        // ---
        System.out.println("\n---\n");
        // ---

        // Q2
        System.out.println("\nQ2");
        // ---

        // ~ a & b
        System.out.println("\n~ a & b");
        // ---
        for (int n = 0; n <= 8; n++) for (int m = 0; m <= 8; m++)
                if (m == 8)
                    System.out.print("" + n + "-" + m + "\n");
                else
                    System.out.print("" + n + "-" + m + ", ") ;

        // ~ c
        System.out.println("\n~ c");
        // ---
        System.out.println("Enter an integer for grid width");
        int width = new java.util.Scanner(System.in).nextInt();
        System.out.println("Enter an integer for grid height");
        int height = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: width:= " + width + " height:= " + height);

        for (int n = 0; n <= height; n++) for (int m = 0; m <= width; m++)
            if (m == width)
                System.out.print("" + n + "-" + m + "\n");
            else
                System.out.print("" + n + "-" + m + ",\t") ;

        // ---
        System.out.println("\n---\n");
        // ---

        // Q3
        System.out.println("\nQ3");
        // ---

        // ~
        System.out.println("Enter an integer for how many lines");
        int lines = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: lines:= " + lines);

        for (int n = 0; n <= lines; n++) for (int m = 0; m <=  n; m++)
            if (m == n)
                System.out.print("*\n");
            else
                System.out.print("*") ;

        // ---
        System.out.println("\n---\n");
        // ---

        // Q4
        System.out.println("\nQ4");
        // ---

        // ~
        System.out.println("Enter an integer 'n'");
        String n = new java.util.Scanner(System.in).nextLine();
        System.out.println("inputs: n:= " + n);

        int result = 0;

        char[] nArray = n.toCharArray();
        for (int j = 0; j < nArray.length; j++) {
            if (j == nArray.length - 1) System.out.print("" + nArray[j]  + "\n");
            else System.out.print("" + nArray[j] + " + ") ;

            result += Character.getNumericValue(nArray[j]);
        }

        System.out.println("result: " + result);

    }
}
