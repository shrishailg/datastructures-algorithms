package dynamic_programming.knapsack_variation.subset_sum;

public class SubsetSumTopUp {

    public boolean isSubsetSum(int[] subset, int n, int sum){
       boolean[][] dp = new boolean[n+1][sum+1];
       for (int i = 0; i<= n; i++){
           dp[i][0] = true;
       }

       for (int j = 0; j<= sum; j++){
            dp[0][j] = false;
       }


       for(int i = 1; i <= n; i++){
           for(int j = 1 ; j <= sum; j++){
               if (subset[i-1] > j){
                   dp[i][j] = dp[i-1][j];
               }
               else {
                   dp[i][j] = dp[i-1][j] || dp[i-1][j - subset[i-1]];
               }
           }
       }

       return dp[n][sum];

    }
}
