package dynamic_programming.longest_palindromic_subsequence;

// lcs of str and reverse(str)
public class LongestPalindromicSubsequence {

    public static void main(String... args){
        String str = "bebeeed";

        System.out.println(getLPS(str));
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(getLPSBottomUp(str, reversed));
    }

    public static int getLPS(String str) {
        String reverse  = new StringBuilder(str).reverse().toString();
        return recursion(str, reverse, str.length(), str.length());
    }

    public static int recursion(String str1, String str2, int m, int n) {
        if (m <= 0 || n<=0) return 0;
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return 1 + recursion(str1,str2, m-1, n- 1);

        return Math.max(recursion(str1,str2, m-1, n), recursion(str1,str2, m, n- 1));
    }

    public static int getLPSBottomUp(String s1, String s2) {
        int m = s1.length();

        int[][] dp = new int[m+1][m+1];

        for(int i=1; i<=m;i++) {
            for(int j=1; j<=m;j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) ;
                }
            }
        }

        return dp[m][m];
    }
}
