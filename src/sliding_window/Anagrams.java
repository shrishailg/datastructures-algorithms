package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {


    // str length is:M
    // pattern length is:N

    // time complexity: O(N+M)
    //space complexity: O(N+M)
    public List<Integer> findAllAnagrams(String str, String pattern) {
        int matched =0;
        int start = 0;
        Map<Character, Integer> patternFreq = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(var pat: pattern.toCharArray()) { // O(N)
            patternFreq.put(pat, patternFreq.getOrDefault(pat, 0)+1);
        }

        for(int end = 0; end<str.length(); end++) {//O(M)
            char rightChar = str.charAt(end);

            if (patternFreq.containsKey(rightChar)) {
                patternFreq.put(rightChar, patternFreq.get(rightChar)-1);

                if (patternFreq.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == patternFreq.size()) {
                result.add(end);
            }

            if (end > pattern.length()) {
                char leftChar = str.charAt(start);

                if (patternFreq.containsKey(leftChar)) {
                    if (patternFreq.get(leftChar) == 0) {
                        matched--;
                    }
                }
                patternFreq.put(leftChar, patternFreq.get(leftChar)+1);

                start++;
            }
        }

        return result;
    }
}
