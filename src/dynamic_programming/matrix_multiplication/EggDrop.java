package dynamic_programming.matrix_multiplication;

import java.util.Arrays;

public class EggDrop {

    public static void main(String[] args) {
        //k = 2, n = 6
        System.out.println(recursion(2, 6));

        //Input: e = 3, f = 14
        //Output: 4
        System.out.println(recursion(3, 14));
    }

    public static int recursion(int e, int f) {
        if(f == 1 || f == 0) { //n == floors; k== eggs
            return f;
        }

        if(e==1) {
            return f;
        }

        int mini = Integer.MAX_VALUE;
        for(int floor=1;floor<=f;floor++) {
            int temp = 1 + Math.max(recursion(e-1,  floor-1), recursion(e, f-floor));

            mini = Math.min(mini, temp);
        }

        return mini;
    }


    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        for(var row:dp) {
            Arrays.fill(row, -1);
        }

        return solve(k, n, dp);
    }

    int recursion(int k, int n, int[][] dp) {
        if (n == 1 || n == 0) { // n == floors; k== eggs
            return dp[k][n] = n;
        }

        if (k == 1) {
            return dp[k][n] = n;
        }

        if (dp[k][n] != -1) {
            return dp[k][n];
        }

        int low = 1, high = n, result = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            int left = recursion(k - 1, mid - 1, dp);// egg breaks
            int right = recursion(k, n - mid, dp); // egg not breaks

            result = Math.min(result, Math.max(left, right) + 1);

            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return dp[k][n] = result;
    }

    int solve(int k, int n, int[][] dp) {
        if(n == 1 || n == 0) { //n == floors; k== eggs
            return dp[k][n] = n;
        }

        if(k==1) {
            return dp[k][n] = n;
        }

        if(dp[k][n] != -1) {
            return dp[k][n];
        }

        int mini = Integer.MAX_VALUE;
        for(int floor=1;floor<=n;floor++) {
            int temp = 1 + Math.max(superEggDrop(k-1,  floor-1), superEggDrop(k, n-floor));

            mini = Math.min(mini, temp);
        }

        return dp[k][n] = mini;
    }
}
