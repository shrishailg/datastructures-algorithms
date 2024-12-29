package dynamic_programming.subsequence_variation.longest_common_subsequence;

public class LongestCommonSubsequenceBottomUp {

    public int findLcs(String a, String b, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i <= m; i++){
            for(int j=0; j <= n; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else if (a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i=m; int j=n;

        while(i>0 && j>0) {
            if (a.charAt(i-1) == b.charAt(j-1)) {
                lcs.append(a.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else {
                j--;
            }
        }

        String finalLcs = new String(lcs.reverse());

        System.out.println("lcs of gives string is : "+ finalLcs);

        return dp[m][n];
    }
}
