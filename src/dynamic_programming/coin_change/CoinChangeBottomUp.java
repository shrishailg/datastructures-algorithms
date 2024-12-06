package dynamic_programming.coin_change;

public class CoinChangeBottomUp {

    public int getMaxChanges(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) dp[i][j] = 0;
                else if (j == 0) dp[i][j] = 1;
                else if (j >= arr[i - 1])
                    dp[i][j] += dp[i][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
