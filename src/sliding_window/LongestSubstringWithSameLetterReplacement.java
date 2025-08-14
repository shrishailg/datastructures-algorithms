package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLetterReplacement {


    public int findLongestSubstring(String str, int k) {
        int start = 0;
        int n = str.length();
        int len = Integer.MIN_VALUE;
        Map<Character, Integer> charFreq = new HashMap<>();

        for(int end=0;end<n;end++) {
            char value = str.charAt(end);
            charFreq.put(value, charFreq.getOrDefault(value, 0)+1);

            int repeatedCount = charFreq.get(value);

            while (end-start+1-repeatedCount>k) {
                char startChar = str.charAt(start);
                charFreq.put(startChar, charFreq.get(startChar)-1);
                start++;
            }

            len = Math.max(len, end-start+1);
        }

        return len;
    }
}
