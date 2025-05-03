package leetcode;

/*
The score of an array is defined as the product of its sum and its length.

For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
Given a positive integer array nums and an integer k,
return the number of non-empty subarrays of nums whose score is strictly less than k.

A subarray is a contiguous sequence of elements within an array.
Input: nums = [1,1,1], k = 5
Output: 5
Explanation:
Every subarray except [1,1,1] has a score less than 5.
[1,1,1] has a score (1 + 1 + 1) * 3 = 9, which is greater than 5.
Thus, there are 5 subarrays having scores less than 5.
 */

public class lc_29th_apr_25 {

    public static void main(String[] args) {
       int[] nums = {2,1,4,3,5};
       int k = 10;

       System.out.println(countSubarrays(nums, k));
    }

    public static long countSubarrays(int[] nums, long k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        long len = 0;
        long sum = 0;

        for (j = 0; j < n; j++) {
            sum += nums[j];
            long result = sum * (j - i + 1);
            while (result >= k) {
                sum -= nums[i];
                i++;
                result = sum * (j - i + 1);
            }

            len += j - i + 1;
        }

        return len;
    }
}
