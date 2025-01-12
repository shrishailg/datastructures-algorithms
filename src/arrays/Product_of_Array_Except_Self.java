package arrays;

/*
Given an integer array nums, return an array answer such that answer[i]
is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

*/


import java.util.Arrays;

public class Product_of_Array_Except_Self {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelfV1(nums)));
        System.out.println(Arrays.toString(productExceptSelfV2(nums)));
    }

    //using devision
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int product_without_zero = 1;
        int count_zero = 0;

        for (var num : nums) {
            if (num == 0) {
                count_zero++;
                product *= num;
                continue;
            }

            product *= num;
            product_without_zero *= num;
        }

        int[] result = new int[nums.length];

        if (count_zero > 1) {
            return result;
        }

        int i = 0;
        for (var num : nums) {
            if (num == 0) {
                result[i] = product_without_zero;
            } else {
                result[i] = product / num;
            }

            i++;
        }

        return result;
    }

    //using space
    public static int[] productExceptSelfV1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        int leftProduct = 1;
        int rightProduct = 1;

        for(int i=0;i<n;i++) {
            left[i] = leftProduct;
            leftProduct *= nums[i];

            right[n-i-1] = rightProduct;
            rightProduct *= nums[n-i-1];
        }

        for(int i=0;i<n;i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    //without using space
    public static int[] productExceptSelfV2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int leftProduct = 1;
        int rightProduct = 1;

        for(int i=0;i<n;i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for(int i=0;i<n;i++) {
            result[n-i-1] = result[n-i-1] * rightProduct;
            rightProduct *= nums[n-i-1];
        }

        return result;
    }
}
