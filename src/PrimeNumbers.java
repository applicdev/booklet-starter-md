import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {

        // ~ defining variables 'a' dnd 'b'
        int n = 0;

        while (true) {
            // ~ input values for 'n' and 'm'
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter an integer for 'n'");
            n = scanner.nextInt();
            System.out.println("inputs: n:= " + n);

            // ~
            if (n <= 0 ) {
                System.out.println("error: inputs for 'n' is required to be Z_+");
                break;
            };

            // ~
            int result = PrimeNumbers.isPrime(n);
            if (result == 1) System.out.println("" + n + " is prime");
            else System.out.println("" + n + " is not prime; factors with " + result);
        }
    }

    public static int isPrime(int n) {
        // ~ 0 & 1
        if (n <= 1) return 0;

        // ~ 2 & 3 are prime
        if (n <= 3) return 1;

        // ~ 2 & 3 as factors
        // 0 = n%2 when n = 2,_,4,_,6,_,8,_,10,__,12,__,14,__,16,__,18,__,20,__,22,__,24,__,26,__, ...
        if (n % 2 == 0) return 2;
        // 0 = n%3 when n = _,3,_,_,6,_,_,9,__,__,12,__,__,15,__,__,18,__,__,21,__,__,24,__,__,27, ...
        if (n % 3 == 0) return 3;

        // ~ while thru possible factors
        // 0 = n%[_,_,_,5,_,7,_,_,__,11,__,13,__,__,__,17,__,19,__,__,__,23,__,25,__,__, ...]
        int nRoot = (int) Math.ceil(Math.sqrt(n));
        int count = 5;
        while (count <= nRoot) {
            if (n % count == 0) return count;
            if (n % (count + 2) == 0) return count + 2;

            count += 6;
        }

        return 1;
    }
}
