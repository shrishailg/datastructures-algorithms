package dynamic_programming.lcs;

import java.util.Locale;

public class LongestCommonSubsequenceTest {

    public static void main(String[] args){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();

        String a = "ShrishailA";
        String b = "SomanalAD";

        System.out.println(longestCommonSubsequence.findLcs(a.toLowerCase(Locale.ROOT), b.toLowerCase(Locale.ROOT), a.length(), b.length()));

        LongestCommonSubsequenceTopDown longestCommonSubsequenceTopDown = new LongestCommonSubsequenceTopDown();
        System.out.print("lcs in TOP-DOWN approach is : ");
        System.out.println(longestCommonSubsequenceTopDown.findLcs(a.toLowerCase(Locale.ROOT), b.toLowerCase(Locale.ROOT), a.length(), b.length()));

        LongestCommonSubsequenceBottomUp longestCommonSubsequenceBottomUp = new LongestCommonSubsequenceBottomUp();
        System.out.print("lcs in BOTTOM-UP approach is : ");
        System.out.println(longestCommonSubsequenceBottomUp.findLcs(a.toLowerCase(Locale.ROOT), b.toLowerCase(Locale.ROOT), a.length(), b.length()));

    }
}
