package dynamic_programming.knapsack_variation.target_sum;

public class TargetSum {

    public static void main(String[] arrgs) {
        
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;

        for(var num:nums) {
            sum += num;
        }

        if(sum<target) {
            return 0;
        }

        if((sum+target)%2 != 0) {
            return 0;
        }

        int subsetSum = (sum + target)/2;

        if(subsetSum < 0) {
            return 0;
        }

        int[][] dp = new int[n+1][subsetSum+1];

        dp[0][0] = 1;

        for(int i = 1;i <= n; i++) {
            for(int j = 0; j <= subsetSum; j++) {
                if(nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][subsetSum];
    }
}
