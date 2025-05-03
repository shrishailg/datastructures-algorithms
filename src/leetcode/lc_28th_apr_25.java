package leetcode;

/*
Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers
 equals exactly half of the second number.
 */

public class lc_28th_apr_25 {

    public static void main(String[] args) {
       int[] nums = {1,2,1,4,1};
        System.out.println(countSubarrays(nums));
    }

    public static int countSubarrays(int[] nums) {
        int i = 0;
        int count = 0;

        for (int j = 2; j < nums.length; j++) {
            Integer sum = nums[i] + nums[j];
            Integer secondElement = nums[j - 1] / 2;
            if ((nums[j - 1] % 2 == 0) && sum.equals(nums[j - 1] / 2)) {
                count++;
            }
            i++;
        }

        return count;
    }
}
