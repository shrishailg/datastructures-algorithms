package dynamic_programming.edit_distance;

import java.util.Arrays;

public class EditDistance {

    public static void main(String... args) {
        String s1 = "horse";
        String s2 = "ros";

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursion(s1, s2, m, n));
        System.out.println(recursionMemoization(s1, s2, m, n, dp));
        System.out.println(editDistanceBottomUp(s1, s2));

        String s11 = "intention";
        String s12 = "execution";

         m = s11.length();
         n = s12.length();
        int[][] dp1 = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            Arrays.fill(dp1[i], -1);
        }
        System.out.println(recursion(s11, s12, m, n));
        System.out.println(recursionMemoization(s11, s12, m, n, dp1));
        System.out.println(editDistanceBottomUp(s11, s12));
    }

    private static int recursion(String s1, String s2, int m, int n) {
        if (m<=0) {
            return n;
        }

        if (n<=0) {
            return m;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return recursion(s1, s2, m-1, n-1);
        }

        int insert = 1 + recursion(s1, s2, m, n-1);
        int deletions = 1 + recursion(s1, s2, m-1, n);
        int replace = 1 + recursion(s1, s2, m-1, n-1);

        return Math.min(insert, Math.min(deletions, replace));
    }

    private static int recursionMemoization(String s1, String s2, int m, int n, int[][] dp) {
        if (m<=0) {
            return n;
        }

        if (n<=0) {
            return m;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)) {
            return dp[m][n] = recursion(s1, s2, m-1, n-1);
        }

        int insert = 1 + recursion(s1, s2, m, n-1);
        int deletions = 1 + recursion(s1, s2, m-1, n);
        int replace = 1 + recursion(s1, s2, m-1, n-1);

        return dp[m][n] = Math.min(insert, Math.min(deletions, replace));
    }

    private static int editDistanceBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }


        return dp[m][n];
    }
}
