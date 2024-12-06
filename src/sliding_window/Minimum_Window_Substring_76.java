package sliding_window;

import java.util.HashMap;
import java.util.Map;


/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window.
 If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Ex1: Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */

public class Minimum_Window_Substring_76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));


    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n) {
            return "";
        }

        Map<Character, Integer> charFreq = new HashMap<>();
        for (var ch : t.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        int windowStart = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char ch = s.charAt(windowEnd);

            if (charFreq.containsKey(ch)) {
                charFreq.put(ch, charFreq.get(ch) - 1);
            }

            while (allCharactersPresent(charFreq) && windowStart <= windowEnd) {
                if (minWindowSize > windowEnd - windowStart + 1) {
                    minWindowSize = windowEnd - windowStart + 1;
                    start = windowStart;
                    end = windowEnd;
                }

                char leftChar = s.charAt(windowStart);
                if (charFreq.containsKey(leftChar)) {
                    charFreq.put(leftChar, charFreq.get(leftChar) + 1);
                }

                windowStart++;
            }
        }

        if (start == -1 || minWindowSize == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, end+1);
    }

    private static boolean allCharactersPresent(Map<Character, Integer> map) {
        for (var value : map.values()) {
            if (value > 0) {
                return false;
            }
        }

        return true;
    }
}
