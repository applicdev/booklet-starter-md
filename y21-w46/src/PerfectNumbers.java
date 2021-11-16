import java.util.Scanner;

public class PerfectNumbers {

    public static void main(String[] args) {
        int start = new Scanner(System.in).nextInt();
        int limit = new Scanner(System.in).nextInt();

        for (int n = start; n <= limit; n++) {
            if (isPerfect(n))
                System.out.println(n);
        }
    }


    public static int sumFactors(int n) {
        if (n % 2 != 0) return -1;

        int sum = 0;

        for (int factor = 2; factor < (n * 0.5) + 1; ++factor)
            if (n % factor == 0) {
                sum += factor;
                if (sum > n) {
                    sum = -1;
                    break;
                }
            }

        return sum + 1;
    }

    public static boolean isPerfect(int n) {
        return (sumFactors(n) == n);
    }
}
