import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        // ~
        int n = 0;
        // ...

        while (true) {
            // ~ input values for 'n'
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("\n---\nEnter an integer for 'n'; enter '0' to exit");
                n = scanner.nextInt();

                if (n <= 0 ) throw new Exception();
            }

            // ~ invalid inputs
            catch(Exception e) {
                System.out.println("invalid input: 'n' is required to be a positive integer smaller then 2147483647");
                break;
            }

            // ~ check for factors
            System.out.println("inputs: n:= " + n);
            java.lang.Integer result = PrimeNumbers.isNPrime(n);
            System.out.println(result != null && result == 1
                    ? "" + n + " is prime" : result == null
                    ? "" + n + " is not prime"
                    : "" + n + " is not prime; factors with " + result);
        }
    }

    public static java.lang.Integer isNPrime(int n) {
        // ~ 0 & 1
        if (n <= 1) return null;

        // ~ 2 & 3 are prime
        if (n <= 3) return 1;

        // ~ 2 & 3 as factors
        // 0 = n%2 when n = 2,_,4,_,6,_,8,_,10,__,12,__,14,__,16,__,18,__,20,__,22,__,24,__,26,__, ...
        if (n % 2 == 0) return 2;
        // 0 = n%3 when n = _,3,_,_,6,_,_,9,__,__,12,__,__,15,__,__,18,__,__,21,__,__,24,__,__,27, ...
        if (n % 3 == 0) return 3;

        // ~ while thru other possible factors
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
