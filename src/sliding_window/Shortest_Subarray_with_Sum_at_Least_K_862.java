package sliding_window;

public class Shortest_Subarray_with_Sum_at_Least_K_862 {

    public static void main(String... args) {
        int []nums = {84,-37,32,40,95}; int k=167;
        System.out.println(shortestSubarray(nums, k));
    }

    public static int shortestSubarray(int[] nums, int k) {
        var n = nums.length;

        int windowStart = 0;
        int windowLength = Integer.MAX_VALUE;
        var sum = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            sum += nums[windowEnd];

            if (nums[windowEnd] < 0) {
                while (windowStart == windowEnd) {
                    sum -= nums[windowStart];
                    windowStart++;
                }
            }

            while (sum >= k) {
                windowLength = Math.min(windowLength, windowEnd - windowStart + 1);
                sum -= nums[windowStart];
                windowStart++;
            }
        }

        return windowLength == Integer.MAX_VALUE ? -1 : windowLength;
    }
}
