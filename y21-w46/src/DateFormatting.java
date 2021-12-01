import java.util.*;

public class DateFormatting {
    public static void main(String[] args) {
        DateFormat foo = DateFormat.from("Sat Nov 27 2021 16:34:39 GMT+0100 (Mitteleuropäische Normalzeit)");
        DateFormat boo = DateFormat.from(1638027279465L);
    }

    // ~ Static plain
    public static List<String> langWeekdays = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Son");
    public static List<String> langMonths = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

    // ~ Static values
    public static Integer[][] daysInMonth = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, // => days/month in a non-leap year
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}  // => days/month in a leap year
    };

    private static class DateFormat {
        public DateFormat(long timestamp) {
            System.out.println("\n~ DateFormat");
            System.out.println("\t=> " + timestamp);
            System.out.println("\t=> " + dateToString(timestamp));
        }

        /**
         * @param dateString [weekday] MM DD YYYY hh:mm:ss [GMT+0000]
         * @return DateFormat with specified date values
         */
        public static DateFormat from(String dateString) {
            return from(DateFormatting.parse(dateString));
        }

        /**
         * @param timestamp Milliseconds since Jan 1 1970
         * @return DateFormat with specified date values
         */
        public static DateFormat from(long timestamp) {
            return new DateFormatting.DateFormat(timestamp);
        }
    }

    /**
     * @param timestring - Wed Nov 24 2021 13:56:02 GMT+0100 (Mitteleuropäische Normalzeit)
     * @return Milliseconds since Jan 1 1970
     */
    public static long parse(String timestring) {
        int par = 0;
        String[] params = timestring.split(" ");
        // => { "Wed", "Nov", "24", "2021", "13:56:02", "GMT+0100" [, ... ] }
        // => { "Nov", "24", "2021", "13:56:02", "GMT+0100" }
        // => { "Nov", "24", "2021" }

        // ~ skip weekday
        if (par < params.length && langWeekdays.contains(params[par])) par++;

        // ~ Match Date and Time values
        long matchMonth = 0, matchDay = 0, matchYear = 0;
        long matchHour = 0, matchMinute = 0, matchSecond = 0;

        // + MM; month
        if (par < params.length) {
            // ~ numeric month
            try {
                int paramMonth = Integer.parseInt(params[par]);
                if (paramMonth > 1) {
                    matchMonth = paramMonth;
                    par++;
                } else throw new Error("Invalid date:day parameter: " + params[par]);
            }
            //  ~ plain month
            catch (Exception ignored) {
                if (langMonths.contains(params[par])) {
                    matchMonth = langMonths.indexOf(params[par]) + 1;
                    par++;
                } else throw new Error("Invalid date:month parameter: " + params[par]);
            }
        }

        // + DD; day
        if (par < params.length) {
            int paramDay = Integer.parseInt(params[par]);
            if (paramDay > 1) {
                // FIXME: paramDay can be larger then days in a month
                matchDay = paramDay;
                par++;
            } else throw new Error("Invalid date:day parameter: " + params[par]);
        }

        // + YYYY; year
        if (par < params.length) {
            int paramYear = Integer.parseInt(params[par]);
            if (paramYear > 1) {
                matchYear = paramYear;
                par++;
            } else throw new Error("Invalid date:year parameter: " + params[par]);
        }

        // + hh:mm:ss; time
        if (par < params.length) {
            if (params[par].contains(":")) {
                String[] paramsTime = params[par].split(":");
                par++;
                int tim = 0;

                // ~ hour
                if (tim < paramsTime.length) {
                    matchHour = Integer.parseInt(paramsTime[tim]);
                    tim++;
                }

                // ~ minute
                if (tim < paramsTime.length) {
                    matchMinute = Integer.parseInt(paramsTime[tim]);
                    tim++;
                }

                // ~ second
                if (tim < paramsTime.length) {
                    matchSecond = Integer.parseInt(paramsTime[tim]);
                }
            }
        }

        // + timezone
        if (par < params.length) {
            if (params[par].startsWith("GMT+") || params[par].startsWith("GMT-")) {
                String paramsGMT = params[par].substring(4); // GMT+0100 => 0100

                int direction = (params[par].startsWith("GMT-") ? 1 : -1);
                int gmtH = Integer.parseInt(paramsGMT.substring(0, 2)) * direction;
                int gmtM = Integer.parseInt(paramsGMT.substring(2, 4)) * direction;

                matchHour += gmtH;
                matchMinute += gmtM;
            }
        }

        // ~ Add is all together
        long timestamp = 0L;
        long timeInDay = 86400000;  // => (24 * 60 * 60 * 1000) | in ms


        // + add years since 1970
        for (int year = 1970; year < matchYear; ++year) {
            timestamp += isLeapyear(year)
                    ? 366 * timeInDay  // =>  366 * (24 * 60 * 60 * 1000)
                    : 365 * timeInDay; // =>  365 * (24 * 60 * 60 * 1000)
        }

        // + add the past months of the current year
        for (int month = 0; month < matchMonth - 1; ++month) {
            long monthDays = isLeapyear((int) matchYear)
                    ? ((long) DateFormatting.daysInMonth[1][month])
                    : ((long) DateFormatting.daysInMonth[0][month]);

            timestamp += monthDays * timeInDay; // => days * (24 * 60 * 60 * 1000)
        }

        // + add the past days of the current month
        timestamp += (matchDay - 1) * timeInDay; // => days * (24 * 60 * 60 * 1000)

        // + add time of day
        timestamp += matchHour * 3600000; // => matchHour * 60 * 60 * 1000
        timestamp += matchMinute * 60000; // => matchMinute * 60 * 1000
        timestamp += matchSecond * 1000;

        return timestamp;
    }


    public static String dateToString(long unixtime) {
        unixtime /= 1000;

        // für ein 365er Tage Jahr
        int[] tageSeitJahresanfang = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int sekunde = (int) (unixtime % 60);
        unixtime /= 60;
        int minute = (int) (unixtime % 60);
        unixtime /= 60;
        int stunde = (int) (unixtime % 24);
        unixtime /= 24;
        // unixtime enthält jetzt nur noch Tage

        int jahr = 1970;
        int tageProJahr = 365;
        do {
            tageProJahr = 365;
            if (isLeapyear(jahr))
                tageProJahr = 366;
            if (unixtime >= tageProJahr) {
                unixtime -= tageProJahr;
                jahr++;
            }
        } while (unixtime >= tageProJahr);

        int tag = 1;
        if (isLeapyear(jahr) && unixtime >= 59) {
            if (unixtime == 59) tag = 2;
            unixtime--;
        }

        int monat = 11;
        while (tageSeitJahresanfang[monat] > unixtime) monat--;
        unixtime -= tageSeitJahresanfang[monat];

        tag += unixtime;

        return "" + DateFormatting.langMonths.get(monat) + " " + tag + "th, " + jahr + " " + stunde + ":" + minute + ":" + sekunde;
    }

    private static boolean isLeapyear(int year) {
        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    }
}
