package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K_2461 {

    public static void main(String... args) {
       int[] nums = {1,5,4,2,9,9,9}; int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int windowStart = 0;

        long maxSum = 0;
        long sum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            while (set.contains(nums[windowEnd])) {
                sum -= nums[windowStart];
                set.remove(nums[windowStart]);
                windowStart++;
            }

            sum += nums[windowEnd];
            set.add(nums[windowEnd]);

            if (windowEnd - windowStart + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[windowStart];
                set.remove(nums[windowStart]);
                windowStart++;
            }
        }

        return maxSum;
    }
}
