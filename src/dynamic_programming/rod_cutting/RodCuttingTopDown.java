package dynamic_programming.rod_cutting;

public class RodCuttingTopDown {

    public int geMaxProfit(int[] lengths, int[] profits, int totalLength) {
        int n = lengths.length;

        int[][] dp = new int[n + 1][totalLength + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalLength; j++)
                dp[i][j] = -1;
        }

        if (n == 0 || totalLength == 0 || profits.length == 0) return 0;

        return recursion(lengths, profits, totalLength, n, dp);
    }

    private int recursion(int[] lengths, int[] profits, int totalLength, int n, int[][] dp) {
        if (totalLength == 0 || n == 0) return dp[n][totalLength] = 0;

        if (dp[n][totalLength] != -1) return dp[n][totalLength];

        if (totalLength < lengths[n - 1])
            return dp[n][totalLength] = recursion(lengths, profits, totalLength, n - 1, dp);

        return dp[n][totalLength] = Math.max(recursion(lengths, profits, totalLength, n - 1, dp),
                profits[n - 1] + recursion(lengths, profits, totalLength - lengths[n - 1], n - 1, dp));
    }
}
