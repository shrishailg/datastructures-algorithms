package dynamic_programming.subsequence_variation.repeating_subsequence;

public class RepeatingSubsequence {

    public static void main(String... args) {
        int len = geMaxRepeatingSubsequence("kararak");
        if (len >= 2) System.out.println("repeating subsequence is present");
        else System.out.println("subsequence not present");
    }

    public static int geMaxRepeatingSubsequence(String str) {
        return recursion(str, str, 0, 0);
    }

    public static int recursion(String str1, String str2, int m, int n) {
        if (m == str1.length() || n == str2.length()) return 0;

        if (m != n && str1.charAt(m) == str2.charAt(n)) {
            return 1 + recursion(str1, str2, m + 1, n + 1);
        }

        return Math.max(recursion(str1, str2, m + 1, n), recursion(str1, str2, m, n + 1));
    }
}
