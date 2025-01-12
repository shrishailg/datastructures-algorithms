package binery_search;

/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any
subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 */

import java.util.Arrays;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
       int[] nums = {7,2,5,10,8};
       int k = 2;

       System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        int sum = 0;

        // if(k>nums.length) {
        //     return -1;
        // }

        for(var num: nums) {
            sum +=num;
        }

        int low = maxNum;
        int high = sum;

        int mini = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low+high)/2;

            if(canArraySplitted(nums, mid, k)) {
                mini = Math.min(mini, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return mini;
    }

    private static boolean canArraySplitted(int[] nums, int size, int k) {
        int arrayCount = 1;
        int currentSize = 0;

        for(var num:nums) {
            if(currentSize+num<=size) {
                currentSize+=num;
            } else {
                currentSize = num;
                arrayCount++;
            }
        }

        return arrayCount<=k;
    }
}
