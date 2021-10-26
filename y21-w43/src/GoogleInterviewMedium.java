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
//        interviewBFSolution(input);
//        interviewBFSolution(inputLarge);

        // ~
        interviewSearchSolution(input);
//        interviewSearchSolution(inputLarge);
    }

    public static void printGrid(String type, int[][] value) {
        System.out.println("\n" + type + ": ");
        for (int n = 0; n < value.length; n++)
            for (int m = 0; m < value[n].length; m++)
                System.out.print("" + (value[n][m] == -1 ? "~" : value[n][m] == 1 ? "X" : " ") + (m < value[n].length - 1 ? " " : "\n"));

    }

    public static void interviewSearchSolution_search(int m, int n, int[][] input, int[][] result) {

        // ~                up      right   down     left
        int[][] sibling = {{-1, 0}, {0, 1}, {1, 0}, {0, -1},};

        // ~ not an island or has already been checked
        if (result[m][n] != -1 || input[m][n] == 0) return;


        // ~ current cell is next to border
//        boolean onBorder = false;
        for (int[] sib : sibling) {
            if (
                    m + sib[0] < 0 ||
                            m + sib[0] > input.length - 1 ||
                            n + sib[1] < 0 ||
                            n + sib[1] > input[0].length - 1
            ) {
//                onBorder = true;
                result[m][n] = input[m][n];
            }
        }

        // ~ check siblings
        for (int[] sib : sibling) {
            int mSib = m + sib[0];
            int nSib = n + sib[1];

            // ~ skipp border cells
            if (mSib <= -1 || nSib <= -1 || mSib >= input.length || nSib >= input[0].length) continue;

            if (input[mSib][nSib] == 1) {
                result[mSib][nSib] = 1;
//                interviewSearchSolution_search(m + sib[0], n + sib[1], input, result);
            }
        }
    }

    public static void interviewSearchSolution(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        int[][] filter = new int[input.length][input[0].length];


        for (int m = 0; m < result.length; m++)
            for (int n = 0; n < result[0].length; n++)
                result[m][n] = -1;


        // ~
        for (int m = 0; /* ~ */ ; m = Math.min(input.length - 1, m + 1)) {
            // ~ first and last line
            if (m == 0 || m == input.length - 1) {
                // ~ first and ever third cell
                for (int n = 0; /* ~ */ ; n = Math.min(input[0].length - 1, n + 1)) {
                    interviewSearchSolution_search(m, n, input, result);

                    if (n == input[0].length - 1) break;
                }
            }

            // ~ lines in between
            else {
                interviewSearchSolution_search(m, 0, input, result);
                interviewSearchSolution_search(m, input[0].length - 1, input, result);
            }

            if (m == input.length - 1) break;
        }

        // ---
        printGrid("input", input);
        printGrid("result", result);
//        printGrid("filter", filter);
        // ---
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
