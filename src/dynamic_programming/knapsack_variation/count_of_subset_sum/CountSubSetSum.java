package dynamic_programming.knapsack_variation.count_of_subset_sum;

public class CountSubSetSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};

        System.out.println(countSubSet(arr, 0,10,  arr.length));
        System.out.println(countSubSetTopDown(arr, 10));
    }

   public static int countSubSet(int[] arr, int index, int sum, int n) {
        if (sum == 0) {
            return 1;
        }

        if (index>=n) {
            return 0;
        }

        if (arr[index] > sum) {
            return countSubSet(arr, index+1, sum, n);
        }

        return countSubSet(arr, index+1, sum, n) + countSubSet(arr, index+1, sum-arr[index], n);
    }

    public static int countSubSetTopDown(int[] arr, int sum) {
        int n = arr.length;

        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

}
