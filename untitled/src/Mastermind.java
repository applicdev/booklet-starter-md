public class Mastermind {
    public static void main(String[] args) {
        int pas = (int) (Math.random() * 1000);
        int[] pasDigits = getDigits(pas);

        int att = 0;
        while (true) {
            System.out.print("\nEnter a 3 digit number: ");
            int[] entDigits = getDigits(new java.util.Scanner(System.in).nextInt());
            ++att;

            // ~ Validate
            if (entDigits.length > pasDigits.length) continue;

            String found = "";
            found += (entDigits[0] == pasDigits[0]) ? entDigits[0] : "_";
            found += (entDigits[1] == pasDigits[1]) ? entDigits[1] : "_";
            found += (entDigits[2] == pasDigits[2]) ? entDigits[2] : "_";

            // ~ Found all
            if (!found.contains("_")) break;

            // ~ Found some /  Found none
            if (!found.equals("___")) System.out.println(found + " is correct!");
            else System.out.println("None of the digits are correct...");
        }

        System.out.println("\nWell done! – found " + pas + " in " + att + " attempts~");
    }

    public static int[] getDigits(int n) {
        return new int[]{n / 100, (n % 100) / 10, n % 10,};
    }
}
