public class GoogleInterviewMedium {
    public static void main(String[] args) {
        int[][] input = {
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 0, 0, 0, 0},
        };
        int[][] inputLarge = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        };

        // ~ bruteforce solution
        interviewBFSolution(input);
        interviewBFSolution(inputLarge);

        // ~
        interviewSearchSolution(input);
        interviewSearchSolution(inputLarge);
    }

    public static void printGrid(String type, int[][] value) {
        System.out.println("\n" + type + ": ");
        for (int n = 0; n < value.length; n++)
            for (int m = 0; m < value[n].length; m++)
                System.out.print("" + (value[n][m] == 1 ? "X" : " ") + (m < value[n].length - 1 ? " " : "\n"));

    }

    public static void interviewSearchSolution(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        int[][] filter = new int[input.length][input[0].length];

        // ~
    }

    public static void interviewBFSolution(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        int[][] filter = new int[input.length][input[0].length];

        boolean matchedSomthing = true;
        while (matchedSomthing) {
            matchedSomthing = false;

            for (int n = 0; n < input.length; n++) {
                for (int m = 0; m < input[n].length; m++) {
                    boolean matched = false;

                    // ~
                    if (n - 1 < 0 || result[n - 1][m] == 1) matched = true;
                    if (m - 1 < 0 || result[n][m - 1] == 1) matched = true;
                    if (n + 1 > input.length - 1 || result[n + 1][m] == 1) matched = true;
                    if (m + 1 > input[n].length - 1 || result[n][m + 1] == 1) matched = true;

                    if (matched && result[n][m] != input[n][m]) {
                        matchedSomthing = true;

                        // ~
                        result[n][m] = input[n][m];
                        filter[n][m] = 0;
                    } else if (!matched) {
                        // ~
                        filter[n][m] = input[n][m];
                    }
                }
            }
        }

        // ---
        printGrid("input", input);
        printGrid("result", result);
        printGrid("filter", filter);
        // ---
    }
}
