package dynamic_programming.subset_sum;

import java.util.Objects;

public class SubsetSumBottomUp {

    public boolean isSubsetSum(int[] subset, int n, int sum){
        Boolean[][] dp = new Boolean[n+1][sum+1];

        for (int i = 0; i<= n; i++){
            for(int j=0; j<= sum; j++){
                dp[i][j] = null;
            }
        }

        return isSubsetSumRec(subset, n, sum, dp);
    }

    private boolean isSubsetSumRec(int[] subset, int n, int sum, Boolean[][] dp) {
        if (n == 0){
            return false;
        }

        if (sum == 0){
            return true;
        }

        if (Objects.nonNull(dp[n][sum])){
            return dp[n][sum];
        }

        if (subset[n-1] > sum){
            return dp[n][sum] = isSubsetSumRec(subset, n-1, sum, dp);
        } else {
            return dp[n][sum] = isSubsetSumRec(subset, n-1, sum, dp) || isSubsetSumRec(subset, n-1, sum - subset[n-1], dp);
        }
    }
}
