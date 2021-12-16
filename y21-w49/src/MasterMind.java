import java.util.Scanner;

public class MasterMind {
    public static int pas = generateNumber();

    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int att = 0;

        boolean matched = false;
        while (!matched) {
            System.out.print("\nEnter a 3 digit number: ");
            int guess = eingabe.nextInt();

            att++;
            matched = matchDigits(guess);
        }

        System.out.println("\nWell done! – found " + pas + " in " + att + " attempts~");
    }


    // ~
    public static int generateNumber() {
        while (true) {
            int n = (int) (Math.random() * 1000);

            int n1 = n % 10;
            int n2 = (n / 10) % 10;
            int n3 = n / 100;

            if (n1 == n2 || n1 == n3 || n2 == n3) continue;
            return n;
        }
    }

    // ~
    public static boolean matchDigits(int valGuess) {
        // ~ Solved
        if (valGuess == pas) return true;

        // ~ Match Digits
        int countR = 0;
        int countV = 0;
        int posGuess = 0;
        int posPas = 0;
        while (valGuess > 0) {
            posGuess++;

            int zifGuess = valGuess % 10;
            int valPas = pas;

            while (valPas > 0) {
                posPas++;

                if (zifGuess == (valPas % 10)) {
                    if (posGuess == posPas) countR++;
                    else countV++;

                    break;
                }

                valPas /= 10;
            }

            valGuess /= 10;
        }

        System.out.println(countR + " Digits are right");
        System.out.println(countV + " Digits are valid");
        return false;
    }
}
