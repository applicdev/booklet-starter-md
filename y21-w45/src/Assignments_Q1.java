public class Assignments_Q1 {
    public static void main(String[] args) {
        assignments_q2_a();
    }

    public static void assignments_q2_a() {
        long deivisor = 100000000L;
        int teiler = 2;

        HAUBTSCHLEIFE:
        for (long zahl = 1000000000L; zahl <= 9999999999L; zahl += 10) {

            while (true) {
                long testZahl = zahl / deivisor;
                if (testZahl % teiler != 0) break;

                teiler++;
                deivisor /= 10;

                System.out.println("deivisor: " + deivisor);

                if (deivisor <= 1) {
                    break;
                }

                if (preuefeEindeutigeZiffern(zahl)) {
                    System.out.println("Found number: " + zahl);
                    break;
                }
            }
        }
    }

    public static boolean preuefeEindeutigeZiffern(long zahl) {
        // Long value1 = zahl / 1000000000;
        // Long value2 = (zahl % 1000000000) / 100000000;
        // ...
        // Long value10 = (zahl % 10) / 1;

        boolean[] zahlSchonGesehen = new boolean[10];
        long devisor = 1;
        long modulo = 10;

        for (int i = 0; i < 10; i++) {
            long ziffer = (zahl % modulo) / devisor;

            if (zahlSchonGesehen[(int) ziffer]) return false;

            zahlSchonGesehen[(int) ziffer] = true;
            devisor *= 10;
            modulo *= 10;
        }

        return true;
    }
}
