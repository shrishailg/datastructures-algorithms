package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingSubstring {


    public int findLenOfNonRepeatingSubstring(String str) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int start = 0;
        int len = Integer.MIN_VALUE;

        for(int end = 0; end<str.length();end++) {
            char value = str.charAt(end);
            if (charFreq.containsKey(value)) {
                start = Math.max(start, charFreq.get(value)+1);
            }

            charFreq.put(value, end);
            len = Math.max(len, end-start+1);
        }

        return len;
    }
}
