import java.util.Arrays;

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
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        };

        // ~ Brute-force solution
        interviewBruteForceSolution(input);
        interviewBruteForceSolution(inputLarge);

        // ~ Search solution
        interviewSearchSolution(input);
        interviewSearchSolution(inputLarge);
    }

    public static void printGrid(String type, int[][] value) {
        System.out.println("\n" + type + ": ");
        for (int n = 0; n < value.length; n++)
            for (int m = 0; m < value[n].length; m++)
                System.out.print("" + (value[n][m] == -1 ? "?" : value[n][m] == 1 ? "#" : "'") + (m < value[n].length - 1 ? " " : "\n"));

    }

    public static void interviewSearchSolution_search(int m, int n, int[][] input, int[][] result) {
        // ~ not an island or has already been checked & set tile to sate
        if (result[m][n] != -1) return;
        result[m][n] = input[m][n];

        if (input[m][n] == 0) return;

        // ~ check siblings
        //                  above    right   below   left
        int[][] sibling = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int[] sib : sibling) {
            int mSib = m + sib[0];
            int nSib = n + sib[1];

            // ~ skipp cells on border
            if (mSib <= -1 || mSib >= input.length || nSib <= -1 || nSib >= input[0].length) continue;

            // ~ traverse from sibling
            if (input[mSib][nSib] == 1 && result[mSib][nSib] == -1) {
                interviewSearchSolution_search(mSib, nSib, input, result);
            }
        }
    }

    public static void interviewSearchSolution(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        int[][] filter = new int[input.length][input[0].length];

        // ~
        for (int[] row : result) Arrays.fill(row, -1);

        // ~
        for (int m = 0; m < input.length; ++m) {
            // ~ first and last line
            if (m == 0 || m == input.length - 1) for (int n = 0; n < input[0].length; ++n)
                interviewSearchSolution_search(m, n, input, result);
            else {
                // ~ lines inbetween
                interviewSearchSolution_search(m, 0, input, result);
                interviewSearchSolution_search(m, input[0].length - 1, input, result);
            }
        }

        // ~
        for (int m = 0; m < input.length; ++m)
            for (int n = 0; n < input[0].length; ++n)
                if (input[m][n] != result[m][n]) filter[m][n] = input[m][n];

        // ---
        printGrid("input", input);
        printGrid("result", result);
        printGrid("filter", filter);
        // ---
    }

    public static void interviewBruteForceSolution(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        int[][] filter = new int[input.length][input[0].length];

        boolean matchedSomething = true;
        while (matchedSomething) {
            matchedSomething = false;

            for (int n = 0; n < input.length; n++) {
                for (int m = 0; m < input[n].length; m++) {
                    boolean matched = false;

                    // ~
                    if (n - 1 < 0 || result[n - 1][m] == 1) matched = true;
                    if (m - 1 < 0 || result[n][m - 1] == 1) matched = true;
                    if (n + 1 > input.length - 1 || result[n + 1][m] == 1) matched = true;
                    if (m + 1 > input[n].length - 1 || result[n][m + 1] == 1) matched = true;

                    if (matched && result[n][m] != input[n][m]) {
                        matchedSomething = true;

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
