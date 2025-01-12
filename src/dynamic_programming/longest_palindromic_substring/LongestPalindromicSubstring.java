package dynamic_programming.longest_palindromic_substring;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str1 = "abacd";
        System.out.println(longestPalindromeSubstring(str1));
        System.out.println(longestPalindromeSubstringMemoization(str1));
        System.out.println(longestPalindromeSubstringBottomUp(str1));

    }

    public static int longestPalindromeSubstring(String s) {
        int n = s.length();

        int maxLen = 0;
        int startPos = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startPos = i;
                    }
                }
            }
        }

        System.out.println(s.substring(startPos, maxLen));

        return maxLen;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j))
            return isPalindrome(s, i + 1, j - 1);

        return false;
    }

    public static int longestPalindromeSubstringMemoization(String s) {
        int n = s.length();

        int maxLen = 0;
        int startPos = 0;

        int[][] dp = new int[n+1][n+1];

        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindromeMemoization(s, i, j, dp) == 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        startPos = i;
                    }
                }
            }
        }

        System.out.println(s.substring(startPos, maxLen));

        return maxLen;
    }

    //aaaaaa
    //(0,5) ==> (0,5), (1,4), (2,3), (3,3)
    //(1,4) ==> which is already checked we can memoize this
    //(2,3) ==> which is already checked we can memoize this
    public static int isPalindromeMemoization(String s, int i, int j, int[][] dp) {
        if (i >= j) {
            return dp[i][j]=1;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = isPalindromeMemoization(s, i + 1, j - 1, dp);

        return dp[i][j] = 0;
    }

    public static int longestPalindromeSubstringBottomUp(String s) {
        int n = s.length();

        int maxLen = 0;
        int startPos = 0;

        boolean[][] dp = new boolean[n+1][n+1];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i+l-1 < n; i++) {
                int j = i+l-1;

                if(i==j) { // len is 1
                    dp[i][j] = true;
                } else if(i+1==j) { // when substring len is 2
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else { // len is > 2
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
                }

                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    startPos = i;
                }
            }
        }

        System.out.println(s.substring(startPos, maxLen));

        return maxLen;
    }
}
