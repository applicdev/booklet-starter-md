public class Assignments_Q1 {
    public static void main(String[] args) {
        // Q1
        System.out.println("\nQ1");
        // ---
        // 1. Find the magic number
        //
        // A number is magic if:
        // - the value of the 1   digits is divisible by 1
        // - the value of the 2-3 digits is divisible by 2
        // - the value of the 4-6 digits is divisible by 3
        // - ...
        // - All 10 positions are to
        //
        // ---
        System.out.println("\n~ a");
        System.out.println("fib(7)\t= " + assignments_q1_a(7));
        System.out.println("fib(10)\t= " + assignments_q1_a(10));
        System.out.println("fib(50)\t= " + assignments_q1_a(50));

        System.out.println("\n~ b");
        System.out.println("fib(7)\t= " + assignments_q1_b(7));
        System.out.println("fib(10)\t= " + assignments_q1_b(10));
        System.out.println("fib(50)\t= " + assignments_q1_b(50));
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
