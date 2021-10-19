public class Assignments_Q1 {
    public static void main(String[] args) {
        // Q1
        System.out.println("\nQ1");
        // ---

        // ~ a
        System.out.println("\n~ a");
        // ---
        assignments_q1_a();

        // ~ b
        System.out.println("\n~ b");
        // ---
        assignments_q1_b();
    }

    public static void assignments_q1_a() {
        int a = 3;
        int b = 3 + 2;
        int c = 6 / a;
        int d = b % a;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
    }

    public static void assignments_q1_b() {
        float f = 3f;
        float g = f + 2;
        float h = g / f;
        float i = f % f;

        System.out.println("f: " + f);
        System.out.println("g: " + g);
        System.out.println("h: " + h);
        System.out.println("i: " + i);
    }
}
