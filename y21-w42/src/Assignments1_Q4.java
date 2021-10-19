public class Assignments1_Q4 {
    public static void main(String[] args) {
        // Q4
        System.out.println("\nQ4");
        // ---

        // ~ a
        System.out.println("\n~ a");
        // ---
        // 1. Read an integer input
        // 2. Output its checksum
        //
        // @example
        // f(2312) = 2 + 3 + 1 + 2 = 8
        // ---
        assignments_q4_a();
        // ---

        // ~ b
        System.out.println("\n~ b");
        // 1. Read an integer input
        // 2. Output its checksum (Without using any String functions)
        // ---
        assignments_q4_b();
    }

    public static void assignments_q4_a() {
        System.out.println("Enter an integer 'n' to get find its checksum");
        String n = new java.util.Scanner(System.in).nextLine();
        System.out.println("inputs: n:= " + n);

        int result = 0;

        char[] nArray = n.toCharArray();
        for (int j = 0; j < nArray.length; j++) {
            System.out.print("" + nArray[j] + (j == nArray.length - 1 ? "\n" : " + "));
            result += Character.getNumericValue(nArray[j]);
        }

        System.out.println("result: " + result);
    }

    public static void assignments_q4_b() {
        System.out.println("Enter an integer 'n'");
        int n = new java.util.Scanner(System.in).nextInt();
        System.out.println("inputs: n:= " + n);

        int result = 0;
        while (n > 0) {
            int temp1 = n - n % 10;
            System.out.print("" + (n - temp1) + (temp1 / 10 == 0 ? "\n" : " + "));
            result += n - temp1;
            n = temp1 / 10;
        }

        System.out.println("result: " + result);
    }
}
