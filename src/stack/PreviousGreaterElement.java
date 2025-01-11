package stack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String... args){
        System.out.println(Arrays.toString(getPreviousGreaterOptimised(new int[]{1, 3, 2, 4})));
        System.out.println(Arrays.toString(getPreviousGreaterOptimised(new int[]{4, 5, 0, 3})));
    }

    //O(n2) this brute force
    private static int[] getPreviousGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i=0;i<n;i++) {
            int j = i-1;
            for (j=i-1;j>=0;j--) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }

            if (j<0) {
                result[i] = -1;
            }
        }

        return result;
    }

    //O(n) this optimised
    private static int[] getPreviousGreaterOptimised(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<n;i++) {

            while (!stack.isEmpty() && stack.peek()<= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        return result;
    }
}
