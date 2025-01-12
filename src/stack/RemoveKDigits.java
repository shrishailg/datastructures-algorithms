package stack;

import java.util.Stack;

/*
Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num.

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 */

public class RemoveKDigits {

    public static void main(String[] args) {
       String num = "1432219";
       int k = 3;
       System.out.println(removeKDigits(num, k));
    }

    public static String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (var val : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > val && k > 0) {
                stack.pop();
                k = k - 1;
            }

            stack.push(val);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k = k - 1;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        int i = sb.length() - 1;

        while (i >= 0) {
            if (sb.charAt(i) != '0') {
                break;
            }

            i--;
        }

        String result = "";

        while (i >= 0) {
            result += sb.charAt(i);
            i--;
        }

        return result.isEmpty() ? "0" : result;
    }
}
