package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKDistinctChars {


    public int findLongestSubstring(String str, int k) {
        int start = 0;
        int len = Integer.MIN_VALUE;
        Map<Character,Integer> charFreq = new HashMap<>();

        for(int end = 0;end<str.length();end++) {
            char value = str.charAt(end);
            charFreq.put(value, charFreq.getOrDefault(value, 0));

            while (charFreq.size() > k) {
                char startChar = str.charAt(start);
                charFreq.put(startChar, charFreq.get(startChar) -1);
                if (charFreq.get(startChar) <=0) {
                    charFreq.remove(startChar);
                }
                start--;
            }

            len = Math.max(len, end-start+1);
        }

        return len;
    }
}
