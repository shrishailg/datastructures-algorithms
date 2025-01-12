package lc_easy;

/*
Given a string s and an integer k,
return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
*/

public class lc_11th_Jan_1400 {

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
    }

    public static boolean canConstruct(String s, int k) {
        int n = s.length();

        if (k > n) {
            return false;
        }

        if (k == n) {
            return true;
        }

        int[] charFreq = new int[26];
        for (int i = 0; i < n; i++) {
            charFreq[s.charAt(i) - 'a']++;
        }

        int oddFreqCount = 0;

        for (int i = 0; i < 26; i++) {
            if (charFreq[i] % 2 == 1) {
                oddFreqCount++;
            }
        }

        return oddFreqCount <= k;

    }
}
