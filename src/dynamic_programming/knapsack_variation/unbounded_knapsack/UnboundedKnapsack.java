package dynamic_programming.knapsack_variation.unbounded_knapsack;

public class UnboundedKnapsack {

    public static void main(String[] args) {
       int[] val = {10, 40, 50, 70};
       int[] wt = {1, 3, 4, 5};
        int capacity = 8;

        System.out.println(knapsack(wt, val, capacity));
        System.out.println(knapsackTabulation(wt, val, capacity));
    }

    private static int knapsack(int[] values, int[] profits, int W) {
        int n = values.length;

        return recursion(values, profits, W, n);
    }

    private static int recursion(int[] values, int[] profits, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (values[n-1]> W) {
            return recursion(values, profits, W, n-1);
        }

        int choice1 = recursion(values, profits, W, n-1);
        int choice2 = profits[n-1] + recursion(values, profits, W-values[n-1], n-1);

        return Math.max(choice1, choice2);
    }

    private static int knapsackTabulation(int[] values, int[] profits, int W) {
        int n = values.length;

        int[][] dp = new int[n+1][W+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=W;j++) {
                if (i==0 || j==0){
                    dp[i][j] = 0;
                } else if (values[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], profits[i-1] + dp[i-1][j-values[i-1]]);
                }
            }
        }

        return dp[n][W];
    }
}
