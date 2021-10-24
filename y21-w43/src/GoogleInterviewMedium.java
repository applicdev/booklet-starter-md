public class GoogleInterviewMedium {
    public static void main(String[] args) {
        int[][] input = {
                {1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 0, 0},
        };

        int[][] result = new int[input.length][input[0].length];
        int[][] filter = new int[input.length][input[0].length];

        for (int d = 0; d < Math.max(input.length, input[0].length) - 1; d++) {
            for (int n = 0; n < input.length; n++) {
                for (int m = 0; m < input[n].length; m++) {
                    boolean matched = false;

                    if (n - 1 < 0 || result[n - 1][m] == 1) matched = true;
                    if (m - 1 < 0 || result[n][m - 1] == 1) matched = true;
                    if (n + 1 > input.length - 1 || result[n + 1][m] == 1) matched = true;
                    if (m + 1 > input[n].length - 1 || result[n][m + 1] == 1) matched = true;

                    if (matched) {
                        result[n][m] = input[n][m];
                        filter[n][m] = 0;
                    } else {
                        filter[n][m] = input[n][m];
                    }
                }
            }

            // ---
            System.out.println("\ninput: ");
            for (int n = 0; n < input.length; n++)
                for (int m = 0; m < input[n].length; m++)
                    System.out.print("" + input[n][m] + (m < input[n].length - 1 ? " " : "\n"));

            System.out.println("\nresult: ");
            for (int n = 0; n < result.length; n++)
                for (int m = 0; m < result[n].length; m++)
                    System.out.print("" + result[n][m] + (m < result[n].length - 1 ? " " : "\n"));

            System.out.println("\nfilter: ");
            for (int n = 0; n < filter.length; n++)
                for (int m = 0; m < filter[n].length; m++)
                    System.out.print("" + filter[n][m] + (m < filter[n].length - 1 ? " " : "\n"));
            // ---
        }
    }
