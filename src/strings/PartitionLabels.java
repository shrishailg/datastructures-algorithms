package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
 */

public class PartitionLabels {

    public static void main(String[] args){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int end = 0;
        int size=0;
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            char value = s.charAt(i);
            size++;
            end = Math.max(end, lastIndex.get(value));

            if(i == end) {
                result.add(size);
                size=0;

            }
        }

        return result;
    }
}
