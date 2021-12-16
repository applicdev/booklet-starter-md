import java.util.Scanner;

public class Zahlenschloss {

    public static void main(String[] args) {
        int geheimeZahl = generateNumber();
        Scanner eingabe = new Scanner(System.in);

        boolean gefunden = false;
        do {
            System.out.print("Bitte Tipp geben: ");
            int rateZahl = eingabe.nextInt();

            gefunden = (rateZahl == geheimeZahl);
        } while (!gefunden);

        System.out.println("Jawoll, das war dir richtige Zahl.");
    }

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
}
