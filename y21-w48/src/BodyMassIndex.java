public class BodyMassIndex {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.next();

        System.out.print("Enter your birth year: ");
        int[] bda = {input.nextInt(), 1, 1};

        System.out.print("Enter your weight in KG: ");
        float wei = input.nextFloat();

        System.out.print("Enter your size in centimeter: ");
        float siz = ((float) input.nextInt()) / 100;

        // ~
        float BMI = (float) Math.round((wei / (siz * siz)) * 100) / 100;
        int age = (2021 - bda[0]);

        // ~
        System.out.println("" +
                "\n" + name + "\t" + bda[0] + ", " + wei + "KG, " + siz + "m" +
                "\n" + "" +
                "\n" + "– BMI:\t" + BMI +
                "\n" + "– Age:\t" + age + " Jahre"
        );
    }
}
