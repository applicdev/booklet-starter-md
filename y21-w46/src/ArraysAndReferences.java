import java.util.Arrays;

public class ArraysAndReferences {
    public static void main(String[] args) {
        // an primitive variables -> call by value
        int a = 5;
        calc(a);
        System.out.println(a);

        // an array primitive element ->  call by context
        int[] b = {1, 2, 3, 4};
        calc(b);
        System.out.println("" + Arrays.toString(b));

        // an primitive element of an array -> call by value
        calc(b[0]);
        System.out.println("" + Arrays.toString(b));
    }

    public static void calc(int n) {
        n = 42;
    }

    public static void calc(int[] n) {
        n[1] = 42;
    }
}
