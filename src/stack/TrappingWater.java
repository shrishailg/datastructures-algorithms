package stack;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

 */

public class TrappingWater {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
        System.out.println(trapOptimised(height));
    }

    //formula
    // ans = min(leftMax, rightMax) - arr[i]
    // instead of travelling to left everytime to find leftMax ==> calculate array prefixMax[]
    // instead of travelling to right everytime to find rightMax ==> calculate array suffixMax[]
    public static int trap(int[] height) {
        int total = 0;
        int n = height.length;
        int[] prefixMax = getPrefixMax(height);
        int[] suffixMax = getSuffixMax(height);

        for (int i = 0; i < n; i++) {
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];

            if (height[i] < leftMax && height[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - height[i];
            }
        }

        return total;
    }

    private static int[] getPrefixMax(int[] arr) {
        int[] prefixMax = new int[arr.length];
        prefixMax[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        return prefixMax;
    }

    private static int[] getSuffixMax(int[] arr) {
        int n = arr.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        return suffixMax;
    }

    /*
    1. use two pointers one at left and other at right
    2. if left smaller than right, and leftMax is greater than height of left, process left
    3. if right smaller than left, and rightMax is greater than height of right, process right side
     */
    private static int trapOptimised(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;

        int l = 0;
        int r = height.length-1;

        while(l<r) {

            if (height[l] <= height[r]) {
                if (leftMax>height[l]) {
                    total += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }

                l = l + 1;
            } else {
                if (rightMax>height[r]) {
                    total += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }

                r = r - 1;
            }
        }

        return total;
    }
}
