package strings;

/*
You are given two strings start and target, both of length n.
 Each string consists only of the characters 'L', 'R', and '_' where:

The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only
if there is a blank space directly to its left, and a piece 'R' can move to the right only if
there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times.
 Otherwise, return false.

 Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Move_Pieces_to_Obtain_a_String_2337 {

    public static void main(String... args) {
        String start = "_L__R__R_";
        String target = "L______RR";
        System.out.println(canChange(start, target));
        System.out.println(canChangeOptimised(start, target));
    }

    public static boolean canChangeOptimised(String start, String target) {
        // Map<String, Boolean> map = new HashMap<>();
        // return recursion(start, target, map);

        int i = 0;
        int j = 0;
        int n = start.length();

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            if (i == n || j == n) {
                return i == n && j == n;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }

            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }

    public static boolean canChange(String start, String target) {
         Map<String, Boolean> map = new HashMap<>();
         return recursion(start, target, map);
    }


    static boolean recursion(String start, String target, Map<String, Boolean> map) {
        if (start.equals(target)) {
            return true;
        }

        if (!map.isEmpty() && Objects.nonNull(map.get(start))) {
            return map.get(start);
        }

        for (int index = 0; index < start.length(); index++) {
            if (index > 0 && start.charAt(index) == 'L' && start.charAt(index - 1) == '_') {
                start = swap(start, index, index - 1);
                if (recursion(start, target, map)) {
                    return true;
                }

                start = swap(start, index, index - 1);

            } else if (index < start.length() - 1 && start.charAt(index) == 'R' && start.charAt(index + 1) == '_') {
                start = swap(start, index, index + 1);
                if (recursion(start, target, map)) {
                    return true;
                }
                start = swap(start, index, index + 1);
            }
        }

        map.put(start, false);
        return false;
    }

    static String swap(String s, int x, int y) {
        char[] str = s.toCharArray();
        char temp = str[x];
        str[x] = str[y];
        str[y] = temp;

        return new String(str);
    }
}
