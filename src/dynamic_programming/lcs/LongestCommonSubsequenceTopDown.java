package dynamic_programming.lcs;

public class LongestCommonSubsequenceTopDown {
    public int findLcs(String a, String b, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i<= m; i++){
            for(int j = 0; j<= n; j++){
                dp[i][j] = -1;
            }
        }

        return findLcsRec(a, b, m, n, dp);
    }

    private int findLcsRec(String a, String b, int m, int n, int[][] dp){
        if (m == 0 || n == 0){
            return 0;
        } else if (dp[m][n] != -1){
            return dp[m][n];
        } else if (a.charAt(m-1) == b.charAt(n-1)){
             dp[m][n] = 1 + findLcsRec(a, b, m-1, n-1, dp);
             return dp[m][n];
        }
        return dp[m][n] = Math.max(findLcsRec(a, b, m-1, n, dp), findLcsRec(a, b, m, n-1, dp));
    }
}
