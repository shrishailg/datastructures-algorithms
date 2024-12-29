package dynamic_programming.knapsack_variation.count_min_subset_sum_difference;


public class CountMinSubsetSumDiff {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int diff = 3;

        System.out.println(countMinSubsetSumDiff(arr, diff));
        System.out.println(countMinSubsetSumDiffRecursion(arr, diff));
    }

    public static int countMinSubsetSumDiffRecursion(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;

        for (var num : arr) {
            sum += num;
        }

        int subsetSum = (sum + diff) / 2;

        return recursion(arr, n, subsetSum);
    }

    static int recursion(int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (n <= 0) {
            return 0;
        }

        if (arr[n - 1] > sum) {
            return recursion(arr, n - 1, sum);
        }
        return recursion(arr, n - 1, sum) + recursion(arr, n - 1, sum - arr[n - 1]);
    }


    public static int countMinSubsetSumDiff(int[] arr, int diff) {
        int n = arr.length;
        int sum = 0;

        for (var num : arr) {
            sum += num;
        }

        int subsetSum = (sum + diff) / 2;

        int[][] dp = new int[n + 1][subsetSum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= subsetSum; j++) {
                if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][subsetSum];
    }
}
