public class Assignments_Q2 {
    public static void main(String[] args) {
        // Q2
        System.out.println("\nQ2");
        // ---
        // 1. Find the magic number
        //
        // A number is magic if:
        // - the value of the first 1 digits is divisible by 1
        // - the value of the first 1-2 digits is divisible by 2
        // - the value of the first 1-3 digits is divisible by 3
        // - ...
        // - the value of the first 1-10 digits is divisible by 10
        //
        // ---
        assignments_q1();
    }

    public static void assignments_q1() {
        // ---
        long steps = 0;
        long result = -1;
        // ---

        // ~ Define bounds
        int nLength = 10;
        double nLimit = Math.pow(10, nLength) - 1;
        double nStart = Math.pow(10, nLength - 1);
        double nDelta = nLength - (nStart % nLength);

        // ~ Define checks
        interface Check { }
        Check[] checks = new Check[nLength];
        for (int c = nLength; c >= 0; --c) {
            int finalC = c;
            checks[c] = new Check() { public boolean resolve(int n) { return n % finalC == 0; } };
        }


        // ~ Find
        for (double n = nStart + nDelta; n < nLimit; n += nLength) {
            String val = ("" + n).substring(0, ("" + n).indexOf('.'));
            if (n % 100000 == 0)
                System.out.println("" + Math.floor(100 - ( n / nLimit  ) * 100) + " percent done; n: " + n);

            // ~
            boolean res = false;

            for (int m = val.length(); m > 1; --m, ++steps) {
                if (Double.parseDouble(val.substring(0, m)) % m == 0) break;;
                res = true;
            }

            // ~
            if (res) {
                for (int m = val.length(); m > 1; --m) {
                    System.out.println("" + val.substring(0, m) + " % " + m + " == 0");
                }

                result = (long)
                n; break;
            };
        }

        // ---
        System.out.println("The magic number " + result +  " was found after trying " + steps + " calculation steps.");
        // ---
    }
}
