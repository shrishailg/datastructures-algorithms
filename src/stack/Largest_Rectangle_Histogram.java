package stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/


import java.util.Arrays;
import java.util.Stack;

public class Largest_Rectangle_Histogram {

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleAreaBruteForce(heights));
//        System.out.println(largestRectangleAreaIntermediate(heights));
        System.out.println(largestRectangleAreaOptimised(heights));


        int[] heights1 = {1,1};
        System.out.println(largestRectangleAreaIntermediate(heights1));

        System.out.println(largestRectangleAreaOptimised(heights1));
    }


    public static int largestRectangleAreaBruteForce(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];
            int leftCount = 0;
            int rightCount = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] >= currentHeight) {
                    leftCount++;
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (heights[j] >= currentHeight) {
                    rightCount++;
                } else {
                    break;
                }
            }

            int totalWidth = 1 + rightCount + leftCount;
            maxArea = Math.max(maxArea, totalWidth * currentHeight);
        }

        return maxArea;
    }

    public static int largestRectangleAreaOptimised(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < stack.peek().value) {
                Node poppedValue = stack.pop();

                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek().index;

                int area = poppedValue.value * (nse - pse - 1);
                maxArea = Math.max(maxArea, area);
            }

            stack.push(new Node(heights[i], i));
        }

        while (!stack.isEmpty()) {
            Node poppedValue = stack.pop();

            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek().index;

            int area = poppedValue.value * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // rectangular area = arr[i] * (nse-pse-1)
    public static int largestRectangleAreaIntermediate(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] prevSmallestIndex = getPreviousSmallestElement(heights);
        int[] nextSmallestIndex = getNextSmallestElement(heights);

        for (int i = 0; i < n; i++) {
            int area = heights[i] * (nextSmallestIndex[i] - prevSmallestIndex[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int[] getNextSmallestElement(int[] arr) {
        int n = arr.length;
        Stack<Node> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= stack.peek().value) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = n;
            } else {
                result[i] = stack.peek().index;
            }

            stack.push(new Node(arr[i], i));
        }

        return result;
    }

    private static int[] getPreviousSmallestElement(int[] arr) {
        int n = arr.length;
        Stack<Node> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= stack.peek().value) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek().index;
            }

            stack.push(new Node(arr[i], i));
        }

        return result;
    }

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }
}
