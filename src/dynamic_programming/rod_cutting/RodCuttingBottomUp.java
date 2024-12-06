package dynamic_programming.rod_cutting;

public class RodCuttingBottomUp {

    public int geMaxProfit(int[] lengths, int[] profits, int totalLength) {
        int n = lengths.length;

        int[][] dp = new int[n + 1][totalLength + 1];


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= totalLength; j++)
                if (i==0 || j==0)
                    dp[i][j] = 0;
                else if (j < lengths[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1] + dp[i-1][j-lengths[i-1]]);
        }

        return dp[n][totalLength];
    }
}
