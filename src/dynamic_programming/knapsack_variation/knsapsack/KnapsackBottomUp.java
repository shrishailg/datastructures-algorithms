package dynamic_programming.knapsack_variation.knsapsack;

public class KnapsackBottomUp {

    public int getMaxProfit(int[] wts, int[] vals, int W, int n){
        int[][] dp = new int[n+1][W+1];

        for(int i= 0; i<= n; i++){
            for (int j = 0; j<= W; j++){

                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }

                else if (wts[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(vals[i-1] + dp[i-1][j-wts[i-1]], dp[i-1][j]);
                }
            }
        }

        return dp[n][W];
    }
}
