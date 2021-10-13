import java.util.Scanner;

public class EuclideanAlgorithm {

    public static void main(String[] args) {
        // ~ defining variables 'a' dnd 'b'
        int n = 0, m = 0;

        while (true) {
            // ~ input values for 'n' and 'm'
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an integer for 'n'");
            n = scanner.nextInt();
            System.out.println("Enter an integer for 'm'");
            m = scanner.nextInt();
            System.out.println("inputs: n:= " + n + " m:= " + m);

            // ~
            if (n <= 0 | m <= 0) {
                System.out.println("error: inputs for 'n' and 'm' are required to be Z_+");
                break;
            };

            // ~
            int result = EuclideanAlgorithm.algorithm(n, m);
            System.out.println("result: " + result);
        }
    }

    public static int algorithm(int n, int m) {
        while (n != m) if (n > m) { n -= m; } else { m -= n; };
        return n;
    }

}
