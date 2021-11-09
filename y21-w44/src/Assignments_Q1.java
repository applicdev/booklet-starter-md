public class Assignments_Q1 {
    public static void main(String[] args) {
        // Q1
        System.out.println("\nQ1");
        // ---
        // Find any number in the fibonacci sequence at position 'n'.
        // ---
        System.out.println("\n~ a");
        for (int n = 1; n <= 10; n++) System.out.println("fib(" + n + ")\t= " + assignments_q1_a(n));
        System.out.println("fib(30)\t= " + assignments_q1_a(30));

        System.out.println("\n~ b");
        for (int n = 1; n <= 10; n++) System.out.println("fib(" + n + ")\t= " + assignments_q1_b(n));
        System.out.println("fib(30)\t= " + assignments_q1_b(30));
    }

    public static double assignments_q1_a(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long o = 0;
        long m = 1;
        long result = 0;

        for (long i = 2; i <= n; i++) {
            result = m + o;
            o = m;
            m = result;
        }

        return result;
    }

    public static long assignments_q1_b(int n) {
        double fi = (1 + Math.sqrt(5)) / 2;
        double gr = 1 - fi;
        return (long) Math.floor((Math.pow(fi, n) - Math.pow(gr, n)) / Math.sqrt(5));
    }
}
