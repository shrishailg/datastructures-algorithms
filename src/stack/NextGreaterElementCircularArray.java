package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementCircularArray {

    public static void main(String[] srgs) {
        System.out.println(nextGreaterElement(new int[]{1, 3, 2, 4}));
        System.out.println(nextGreaterElement(new int[]{4, 5, 0, 3}));
//        System.out.println(nextGreaterElement(new int[]{1, 3, 2, 4}));
    }


    public static List<Integer> nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        int n = arr.length;

        for (int i = 2 * n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                int temp = stack.isEmpty() ? -1 : stack.peek();
                result.add(temp);
            }

            stack.push(arr[i % n]);
        }

        Collections.reverse(result);

        return result;
    }
}
