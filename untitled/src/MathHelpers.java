public class MathHelpers {
    public static void main(String[] args) {
        while (true) {
            java.util.Scanner input = new java.util.Scanner(System.in);

            System.out.print("\nEnter a radius in centimeter: ");
            double r = input.nextDouble();

            System.out.println("kreisumfang:\t" + round(kreisumfang(r), 3) + " cm");
            System.out.println("kreisfläche:\t" + round(kreisflaeche(r), 3) + " cm²");
            System.out.println("kugelvolumen:\t" + round(kugelvolumen(r), 3) + " cm³");
        }
    }

    public static double round(double n, int digits) {
        double m = Math.pow(10, digits);
        return Math.round(n * m) / m;
    }

    public static double kreisumfang(double r) {
        return Math.PI * r * 2d;
    }

    public static double kreisflaeche(double r) {
        return Math.PI * (r * r);
    }

    public static double kugelvolumen(double r) {
        return Math.PI * (r * r * r) * (4d / 3d);
    }
}
