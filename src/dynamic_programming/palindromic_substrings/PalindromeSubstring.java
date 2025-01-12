package dynamic_programming.palindromic_substrings;

import java.util.Arrays;

public class PalindromeSubstring {

    public static void main(String[] args) {
        String str1 = "abacd";
        System.out.println(countSubstring(str1));
        System.out.println(countSubstringMemoization(str1));
        System.out.println(countSubstringBottomUp(str1));

    }

    public static int countSubstring(String s) {
        int n = s.length();

        int count = 0;

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if (checkPalindrome(s, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean  checkPalindrome(String s, int i, int j) {
        if (i>j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)){
            return checkPalindrome(s, i+1, j-1);
        }

        return false;
    }

    public static int countSubstringMemoization(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i], -1);
        }

        int count = 0;

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {

                if (checkPalindromeMemoization(s, i, j, dp) == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static int  checkPalindromeMemoization(String s, int i, int j, int[][] dp) {
        if (i>=j) {
            return dp[i][j] = 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)){
            return dp[i][j] = checkPalindromeMemoization(s, i+1, j-1, dp);
        }

        return dp[i][j]= 0;
    }


    public static int countSubstringBottomUp(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n+1][n+1];

        int count = 0;

        for(int l=1;l<=n;l++) {
            for(int i=0;i+l-1<n;i++) {
                int j = i+l-1;

                //if substring len is 1
                if (i==j) {
                    dp[i][j] = true;
                } else if (i+1 == j) { // if substring len is 2
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
