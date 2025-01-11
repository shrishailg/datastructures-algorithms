package binery_search;

/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length],
where % is the modulo operation.

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].


Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.

 */


public class Check_if_Array_Is_Sorted_and_Rotated {

    public static void main(String... args) {
       int[] nums = {3,4,5,1,2};
        int[] nums1 = {2,1,3,4};

       System.out.println(check(nums));
        System.out.println(check(nums1));

    }

    public static boolean check(int[] nums) {
        int count = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i]>nums[(i+1)%nums.length]) {
                count++;
            }

            if(count>1) {
                return false;
            }
        }

        return true;
    }
}
