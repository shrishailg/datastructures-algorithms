package dynamic_programming.knapsack_variation.unbounded_knapsack.coin_change;

public class CoinChangeTopDown {

    public int getMaxChanges(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }

        return getMaxChangesRec(arr, n, sum, dp);
    }

    private int getMaxChangesRec(int[] arr, int n, int sum, int[][] dp) {
        if (sum == 0) {
            return dp[n][sum] = 1;
        }

        if (n == 0 || sum < 0) {
            return 0;
        }

        if (dp[n][sum] != -1) return dp[n][sum];

        int sum1 = 0;
        if (sum >= arr[n - 1]) sum1 = getMaxChangesRec(arr, n, sum - arr[n - 1], dp);

        int sum2 = getMaxChangesRec(arr, n - 1, sum, dp);

        return dp[n][sum] = sum1 + sum2;
    }
}
