package stack;

import java.util.*;

public class NextGreaterElement {

    public static void main(String[] srgs) {
        System.out.println(nextGreaterElement(new int[]{1, 3, 2, 4}));
        System.out.println(nextGreaterElement(new int[]{4, 5, 0, 6}));
//        System.out.println(nextGreaterElement(new int[]{1, 3, 2, 4}));
    }

    public static List<Integer> nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }

            stack.push(arr[i]);
        }

        Collections.reverse(result);

        return result;
    }
}
