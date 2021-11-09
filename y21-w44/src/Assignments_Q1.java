public class Assignments_Q1 {
    public static void main(String[] args) {
        // Q1
        System.out.println("\nQ1");
        // ---
        // Find any number in the fibonacci sequence at position 'n'.
        // ---
        System.out.println("\n~ a");
        System.out.println("fib(1)\t= " + assignments_q1_a(1));
        System.out.println("fib(2)\t= " + assignments_q1_a(2));
        System.out.println("fib(3)\t= " + assignments_q1_a(3));
        System.out.println("fib(4)\t= " + assignments_q1_a(4));
        System.out.println("fib(5)\t= " + assignments_q1_a(5));
        System.out.println("fib(6)\t= " + assignments_q1_a(6));
        System.out.println("fib(7)\t= " + assignments_q1_a(7));
        System.out.println("fib(8)\t= " + assignments_q1_a(8));
        System.out.println("fib(9)\t= " + assignments_q1_a(9));
        System.out.println("fib(10)\t= " + assignments_q1_a(10));
        System.out.println("fib(30)\t= " + assignments_q1_a(30));

        System.out.println("\n~ b");
        System.out.println("fib(1)\t= " + assignments_q1_b(1));
        System.out.println("fib(2)\t= " + assignments_q1_b(2));
        System.out.println("fib(3)\t= " + assignments_q1_b(3));
        System.out.println("fib(4)\t= " + assignments_q1_b(4));
        System.out.println("fib(5)\t= " + assignments_q1_b(5));
        System.out.println("fib(6)\t= " + assignments_q1_b(6));
        System.out.println("fib(7)\t= " + assignments_q1_b(7));
        System.out.println("fib(8)\t= " + assignments_q1_b(8));
        System.out.println("fib(9)\t= " + assignments_q1_b(9));
        System.out.println("fib(10)\t= " + assignments_q1_b(10));
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
