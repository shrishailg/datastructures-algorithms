package dynamic_programming.matrix_multiplication;

import java.util.Arrays;

public class ScrambleString {

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";

        System.out.println(isScrambleMemo(a, b));
    }

    public static boolean isScramble(String s1, String s2)  {
        if(s1.length() != s2.length()) {
            return false;
        }

        if(s1.equals(s2)) {
            return true;
        }

        if(s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        int n = s1.length();
        boolean flag = false;

        for(int k=1;k<=n-1;k++) {
                boolean swap = isScramble(s1.substring(0, k), s2.substring(k, n))
                    && isScramble(s1.substring(k, n), s2.substring(0, k));

            boolean not_swapped = isScramble(s1.substring(0, k), s2.substring(0, k))
                    && isScramble(s1.substring(k, n), s2.substring(k, n));

            if(swap || not_swapped) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public static boolean isScrambleMemo(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        if(s1.equals(s2)) {
            return true;
        }

        if(s1.isEmpty()) {
            return false;
        }

        int n = s1.length();

        int[][] dp = new int[n+1][n+1];

        for (var row:dp) {
            Arrays.fill(row, -1);
        }

       return recursion(s1, s2, dp);
    }

    static boolean recursion(String s1, String s2, int[][] dp) {
        if(s1.length() != s2.length()) {
            return false;
        }

        if(s1.equals(s2)) {
            return true;
        }

        if(s1.isEmpty()) {
            return false;
        }

        int n = s1.length();

        if (dp[n][n] != -1) {
            return dp[n][n] == 1;
        }

        boolean flag = false;

        for(int k=1;k<=n-1;k++) {
            boolean swap = isScramble(s1.substring(0, k), s2.substring(s2.length()-k, n))
                    && isScramble(s1.substring(k, n), s2.substring(0, s1.length()- k));

            boolean not_swapped = isScramble(s1.substring(0, k), s2.substring(0, k))
                    && isScramble(s1.substring(k, n), s2.substring(k, n));

            if(swap || not_swapped) {
                dp[n][n] = 1;
                flag = true;
                break;
            }
        }

        if (flag) {
            dp[n][n] = 1;
        } else {
            dp[n][n] = 0;
        }

        return flag;
    }
}
