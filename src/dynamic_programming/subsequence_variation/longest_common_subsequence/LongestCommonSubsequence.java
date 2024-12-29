package dynamic_programming.subsequence_variation.longest_common_subsequence;

public class LongestCommonSubsequence {

    public int findLcs(String a, String b, int m, int n){
        if (m == 0 || n == 0)
            return  0;
        if (a.charAt(m-1) == b.charAt(n-1))
            return 1 + findLcs(a, b, m-1, n-1);
        else
            return Math.max(findLcs(a,b, m-1, n), findLcs(a,b,m,n-1));
    }
}
