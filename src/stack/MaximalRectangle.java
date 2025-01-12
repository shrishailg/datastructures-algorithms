package stack;

/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
*/

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String... args) {
       char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

       System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] prefixSum = new int[m][n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += matrix[j][i] == '1' ? 1 : 0;

                if (matrix[j][i] == '0') {
                    sum = 0;
                }

                prefixSum[j][i] = sum;
            }
        }

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, calculateMaxArea(prefixSum[i]));
        }

        return maxArea;
    }

    private static int calculateMaxArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int poppedIndex = stack.pop();
                int nse = i;

                int pse = stack.isEmpty() ? -1 : stack.peek();

                maxArea = Math.max(maxArea, heights[poppedIndex] * (nse - pse - 1));
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            int nse = n;

            int pse = stack.isEmpty() ? -1 : stack.peek();

            maxArea = Math.max(maxArea, heights[poppedIndex] * (nse - pse - 1));
        }

        return maxArea;

    }
}
