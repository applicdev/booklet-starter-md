import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PerfectNumbers {
    public static void main(String[] args) {
        long n = 0, limit = (long) Math.pow(2, 64);
        ArrayList<Long> divisors = null;
        ArrayList<Long> continuousDivisors = null;

        while (true) {
            // ~
            System.out.println(" ");
            System.out.println("e  Searching for next perfect numbers n > " + (divisors != null ? divisors.get(divisors.size() - 1) : 0) + ".");

            // ~
            for (; n < limit; ++n) {
                if (n != 0 && n % 1_000_000L == 0) System.out.println("+ none until " + n);

                // ~
                ArrayList<Long> resultDivisors = PerfectNumbers.evaluate(n, continuousDivisors);
                if (resultDivisors == null) continue;

                // ~
                long sum = 0;
                for (long f : resultDivisors) sum += f;

                // ~
                if (sum - n == n) {
                    continuousDivisors = new ArrayList<Long>();

                    Collections.sort(resultDivisors);
                    for (long divisor : resultDivisors) {
                        if (divisors == null) break;
                        if (!divisors.contains(divisor)) {
                            if (divisors.contains(divisor + 1)) continuousDivisors.add(divisor + 1);
                            break;
                        }

                        continuousDivisors.add(divisor);
                    }

                    divisors = resultDivisors;

                    // ~
                    System.out.println("e  Found: " + (sum - n));
                    System.out.println(resultDivisors);

                    if (sum == -1L) break;

                    // ~
                    System.out.println("\nPress any key to continue... ");
                    new Scanner(System.in).nextLine();

                    ++n;
                    break;
                }
            }

            if (n >= limit) break;
        }

        System.out.println("e  Found no more perfect numbers after n > " + (divisors != null ? divisors.get(divisors.size() - 1) : 0) + ".");
    }

    public static ArrayList<Long> evaluate(long n, ArrayList<Long> continuousDivisors) {
        // ~ No even perfect numbers in 0 > n > 2^{64}
        if (n <= 0 || n % 2 != 0) return null;

        // ~ Known even perfect numbers have some shared divisors...
        // 6          => 1, 2, 3, 6                                 divisors: 4
        // 28         => 1, 2, 4, 7,  ...                           divisors: 6   share to pre.: 2  (and 3th + 1)
        // 496        => 1, 2, 4, 8, 16, 31, ...                    divisors: 10  share to pre.: 3  (and 4th + 1)
        // 8128       => 1, 2, 4, 8, 16, 32, 64, 127, ...           divisors: 14  share to pre.: 5  (and 6th + 1)
        // 33550336   => 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, ... divisors: 26  share to pre.: 7  (and 8th + 1)
        // 8589869056 => 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, ... divisors: 34  share to pre.: 13 (and 14th + 1)
        // ...
        if (continuousDivisors != null) {
            for (long divisor : continuousDivisors) if (n % divisor != 0) return null;
        }

        // ~ go through the remaining possible divisor
        ArrayList<Long> divisors = new ArrayList<Long>();

        long sum = 0;

        for (long divisor = 1; ; divisor += 1) {
            if (sum - n > n) return null;
            if (divisor * divisor > n) break;

            if (n % divisor == 0) {
                divisors.add(divisor);
                sum += divisor;

                long div = n / divisor;
                divisors.add(div);
                sum += div;
            }
        }

        return divisors;
    }
}
