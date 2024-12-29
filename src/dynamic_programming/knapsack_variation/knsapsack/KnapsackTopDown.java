package dynamic_programming.knapsack_variation.knsapsack;

public class KnapsackTopDown {

    public int getMaxProfit(int[] wts, int[] vals, int W, int n){
        int[][] dp = new int[n+1][W+1];

        for(int i= 0; i<= n; i++){
            for (int j = 0; j<= W; j++){
                dp[i][j] = -1;
            }
        }

        return getKnapsack(wts, vals,  W,  n, dp);
    }

    private int getKnapsack(int[] wts, int[] vals, int W, int n, int[][] dp){
        if (n == 0 || W == 0)
            return 0;
        if (dp[n][W] != -1)
            return dp[n][W];

        if (wts[n-1] > W){
            return dp[n][W] = getKnapsack(wts, vals, W, n-1, dp);
        } else {
            return dp[n][W] = Math.max(vals[n-1] + getKnapsack(wts, vals, W - wts[n-1], n-1, dp), getKnapsack(wts, vals, W, n-1, dp) );
        }
    }
}
