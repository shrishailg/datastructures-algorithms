package dynamic_programming.subsequence_variation.shortest_common_supersequence;

public class ShortestCommonSuperSequence {

    public static void main(String... args) {
        String s1 = "abcd";
        String s2 = "xycd";

        System.out.println(findShortestSuperSequence(s1, s2));
        System.out.println(recursion(s1, s2, s1.length(), s2.length()));
    }

    public static int recursion(String s1, String s2, int m, int n) {
        if (m <= 0) {
            return n;
        }

        if (n <= 0) {
            return m;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + recursion(s1, s2, m - 1, n - 1);
        }

        return 1 + Math.min(recursion(s1, s2, m - 1, n), recursion(s1, s2, m, n - 1));
    }

    public static String findShortestSuperSequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        StringBuilder scs = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                scs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    scs.append(s1.charAt(i - 1));
                    i--;
                } else {
                    scs.append(s2.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            scs.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(s2.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }
}
