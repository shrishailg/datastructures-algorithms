package dynamic_programming.longest_palindromic_subsequence;

public class LongestPalindromicSubsequence {

    public static void main(String... args){
        String str = "bebeeed";

        System.out.println(getLPS(str));
    }

    public static int getLPS(String str) {
        String reverse  = new StringBuilder(str).reverse().toString();
        return recursion(str, reverse, str.length(), str.length());
    }

    public static int recursion(String str1, String str2, int m, int n) {
        if (m <= 0 || n<=0) return 0;
        if (str1.charAt(m-1) == str2.charAt(n-1)) return 1 + recursion(str1,str2, m-1, n- 1);

        return Math.max(recursion(str1,str2, m-1, n), recursion(str1,str2, m, n- 1));
    }
}
