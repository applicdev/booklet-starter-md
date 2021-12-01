public class TimeConverter {
    public static void main(String[] args) {
        // ~ input time in the unit minutes
        System.out.print("\nEnter a time in minutes: ");
        double time = new java.util.Scanner(System.in).nextDouble();
        // As Example:
        // => time := 100000


        // ~ calc minutes
        int minutes = (int) (time % 60); //  |  "% 60" because 60 minutes = 1 hour, and
        //                                   |  we only need the minutes that are not
        //                                   |  enough to count as the next full hour
        //                                   |
        //                                   |  n mod m = x
        //                                   |  value of x is such that: (n - x) mod m = 0
        //                                   |
        //                                   |  => minutes := time mod 60
        //                                   |             := 100000 mod 60
        //                                   |             := 40 minutes


        // ~ calc hours
        time = (int) (time / 60); //         |  "/ 60" to change "time" from a unit value
        //                                   |   of minutes to a unit value of hours
        //                                   |
        //                                   |  60 minutes / 60 = 1 hour  |  the same as other unit conversions:
        //                                   |                            |  1000g / 1000 = 1kg
        //                                   |
        //                                   |  => time := time / 60      |
        //                                   |          := 100000 / 60    |  (double) 1666.666...
        //                                   |          := 1666 hours     |  (int)    1666
        //
        //
        int hours = ((int) time) % 24; //    |  "% 24" because 24 minutes = 1 day, and
        //                                   |  we only need the days that are not
        //                                   |  enough to count as the next full day
        //                                   |
        //                                   |  => hours := time mod 24
        //                                   |           := 1666 mod 24
        //                                   |           := 10 hours


        // ~ calc days
        time = (int) (time / 24);  //        |  "/ 24" to change "time" from a unit value
        //                                   |  of hours to a unit value of days
        //                                   |
        //                                   |  => time := time / 24      |
        //                                   |          := 1666 / 24      |  (double) 69.41666...
        //                                   |          := 69 days        |  (int)    69
        //
        //
        int days = (int) time; //            |  "time" is in the unit of days and there are
        //                                   |  no larger divisions asked for, so "time" is
        //                                   |  already our value for "days"
        //                                   |
        //                                   | => days := (int) time;
        //                                   |         := 69 days;


        // ~ output
        System.out.println("\n" + days + " days, " + hours + " hours, " + minutes + " minutes");
        // => 69 days, 10 hours, 40 minutes
    }
}
