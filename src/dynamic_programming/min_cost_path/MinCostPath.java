package dynamic_programming.min_cost_path;

public class MinCostPath {

    public static void main(String[] args) {
        int[][] cost = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int m = 2, n = 2;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(findMinCost(cost, m, n));
        System.out.println(findMinCostTopDown(cost, m, n, dp));
        System.out.println(findMinCostBottomDown(cost, m, n));
    }

    public static int findMinCost(int[][] matrix, int m, int n) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return matrix[m][n];
        else
            return matrix[m][n] + getMinValue(findMinCost(matrix, m - 1, n - 1), findMinCost(matrix, m - 1, n), findMinCost(matrix, m, n - 1));
    }

    private static int getMinValue(int x, int y, int z) {
        if (x < y) return Math.min(x, z);
        else return Math.min(y, z);
    }

    public static int findMinCostTopDown(int[][] matrix, int m, int n, int[][] dp) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;

        else if (m == 0 && n == 0)
            return matrix[m][n];

        else if (dp[m][n] != -1)
            return dp[m][n];

        return dp[m][n] = matrix[m][n] +
                getMinValue(findMinCostTopDown(matrix, m - 1, n - 1, dp), findMinCostTopDown(matrix, m - 1, n, dp),
                        findMinCostTopDown(matrix, m, n - 1, dp));
    }

    public static int findMinCostBottomDown(int[][] matrix, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = matrix[0][0];

        //fill up the moves for 1st row
        for (int i = 1; i <= m; i++)
            dp[0][i] = matrix[0][i] + dp[0][i - 1];

        //fill up the moves for 1st column
        for (int i = 1; i <= n; i++)
            dp[i][0] = matrix[i][0] + dp[i - 1][0];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = matrix[i][j] + getMinValue(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
            }
        }

        return dp[m][n];
    }

}
