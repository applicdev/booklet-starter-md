import java.util.Scanner;

public class PerfectNumbers {

    public static void main(String[] args) {
        int limit = new Scanner(System.in).nextInt();

        for (int n = 2; n <= limit; n++) {
            if (isPerfect(n))
                System.out.println(n);
        }
    }


    public static int getSum(int[] nList) {
        int result = 0;
        for (int n : nList) result += n;
        return result;
    }

    public static int[] getFactors(int n) {
        int[] nList = new int[n];

        for (int pos = 0, factor = 2; factor < (n / 2) + 1; ++factor)
            if (n % factor == 0) {
                nList[pos] = factor;
                pos++;
            }

        nList[nList.length - 1] = 1;

        // System.out.println(n + "\t" + Arrays.toString(nList));

        return nList;
    }

    public static boolean isPerfect(int n) {
        return (getSum(getFactors(n)) == n);
    }
}
