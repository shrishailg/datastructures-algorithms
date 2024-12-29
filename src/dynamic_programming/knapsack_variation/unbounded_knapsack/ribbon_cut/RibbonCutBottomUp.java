package dynamic_programming.knapsack_variation.unbounded_knapsack.ribbon_cut;

public class RibbonCutBottomUp {

    public int countRibbons(int[] arr, int n, int totalLength) {
        int[][] dp = new int[n + 1][totalLength + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalLength; j++) {
                if (arr[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], 1 + dp[i][j - arr[i - 1]]);
            }
        }

        return dp[n][totalLength];
    }
}
