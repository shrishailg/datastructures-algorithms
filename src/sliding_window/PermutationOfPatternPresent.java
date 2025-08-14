package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfPatternPresent {


    public boolean isPermutationOfPatternPresent(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();
        int start = 0;
        int matched = 0;

        Map<Character, Integer> patternMap = new HashMap<>();

        for (var pat:pattern.toCharArray()) {
            patternMap.put(pat, patternMap.getOrDefault(pat, 0));
        }

        for(int end = 0;end<str.length();end++) {
            char rightChar = str.charAt(end);

            if (patternMap.containsKey(rightChar)) {
                patternMap.put(rightChar, patternMap.get(rightChar)-1);

                if (patternMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == patternMap.size()) {
                return true;
            }

            if (end > pattern.length()) {
                char leftChar = str.charAt(start);

                if (patternMap.containsKey(leftChar)) {

                    if (patternMap.get(leftChar) == 0) {
                        matched--;
                    }

                    patternMap.put(leftChar, patternMap.get(leftChar)+1);
                }

                start++;
            }
        }

        return false;
    }
}
