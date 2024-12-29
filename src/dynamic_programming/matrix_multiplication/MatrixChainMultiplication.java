package dynamic_programming.matrix_multiplication;

import java.util.Arrays;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};

        System.out.println(findMinCost(arr));
        System.out.println(findMinCostTabulation(arr));
    }

    public static int findMinCost(int[] arr) {
        int n = arr.length;

        int i=1;
        int j = n-1;

        return recursion(arr, i, j);
    }

    private static int recursion(int[] arr, int i, int j) {
        if (i>=j) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int temp = recursion(arr, i, k) + recursion(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
            cost = Math.min(cost, temp);
        }

        return cost;
    }

    private static int findMinCostTabulation(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        // Initialize the diagonal with 0
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i=1;i<n;i++) {
            for (int j=n-1;j>=0;j--) {
                int cost = Integer.MAX_VALUE;

                for(int k=i;k<j;k++) {
                    int temp = dp[i][k] + dp[k+1][j] + (arr[i-1] * arr[k] * arr[j]);
                    cost = Math.min(cost, temp);
                }
                dp[i][j] = cost;
            }
        }

        // Fill in the dp array using bottom-up approach
//        for (int i = n - 1; i >= 1; i--) {
//            for (int j = i + 1; j < n; j++) {
//                int minOperations = Integer.MAX_VALUE;
//
//                // Partitioning loop to find the optimal split point
//                for (int k = i; k <= j - 1; k++) {
//                    int operations = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
//                    minOperations = Math.min(minOperations, operations);
//                }
//
//                dp[i][j] = minOperations;
//            }
//        }

        // The result is stored in dp[1][N-1]
        System.out.println(dp[n-1][1]);
        return dp[1][n-1];
    }
}
