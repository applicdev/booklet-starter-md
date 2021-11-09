public class Assignments_Q1 {
    public static void main(String[] args) {
        // Q1
        System.out.println("\nQ1");
        // ---
        // Find the number in the fibonacci sequence at position 'n'.
        // ---
        double timeStart = System.nanoTime();
        System.out.println("\n~ a");
        for (int n = 0; n <= 35; n++) System.out.println("fib(" + n + ")\t= " + assignments_q1_a(n));
        System.out.println("\nDone in :" + ((System.nanoTime() - timeStart) / 1000 / 1000) + "ns");

        timeStart = System.nanoTime();
        System.out.println("\n~ b");
        for (int n = 0; n <= 35; n++) System.out.println("fib(" + n + ")\t= " + assignments_q1_b(n));
        System.out.println("\nDone in :" + ((System.nanoTime() - timeStart) / 1000 / 1000) + "ns");

        timeStart = System.nanoTime();
        System.out.println("\n~ c");
        for (int n = 0; n <= 35; n++) System.out.println("fib(" + n + ")\t= " + assignments_q1_c(n));
        System.out.println("\nDone in :" + ((System.nanoTime() - timeStart) / 1000 / 1000) + "ns");
    }

    // linear
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

    // wth; but works~
    public static long assignments_q1_b(int n) {
        double fi = (1 + Math.sqrt(5)) / 2;
        double gr = 1 - fi;
        return (long) Math.floor((Math.pow(fi, n) - Math.pow(gr, n)) / Math.sqrt(5));
    }

    // recursive
    public static long assignments_q1_c(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return assignments_q1_c(n - 2) + assignments_q1_c(n - 1);
    }
}
