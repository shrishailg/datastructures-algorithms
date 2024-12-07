package binery_search;

/*
You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.

You can perform the following operation at most maxOperations times:

Take any bag of balls and divide it into two new bags with a positive number of balls.
For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.

Return the minimum possible penalty after performing the operations.

Input: nums = [9], maxOperations = 2
Output: 3
Explanation:
- Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
- Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] -> [3,3,3].
The bag with the most number of balls has 3 balls, so your penalty is 3 and you should return 3.

Input: nums = [2,4,8,2], maxOperations = 4
Output: 2
Explanation:
- Divide the bag with 8 balls into two bags of sizes 4 and 4. [2,4,8,2] -> [2,4,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,4,4,4,2] -> [2,2,2,4,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,4,4,2] -> [2,2,2,2,2,4,2].
- Divide the bag with 4 balls into two bags of sizes 2 and 2. [2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2].
The bag with the most number of balls has 2 balls, so your penalty is 2, and you should return 2.
 */
public class Minimum_Limit_of_Balls_in_a_Bag_1760 {

    public static void main(String... args) {
        int[] nums = {2,4,8,2};
        int maxOperations = 4;

        int[] nums1 = {9};
        int maxOperations1 = 2;

        System.out.println(minimumSize(nums, maxOperations));
        System.out.println(minimumSize(nums1, maxOperations1));
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = nums[0];
        for (int num : nums) {
            high = Math.max(high, num);
        }

        int result = high;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // check if we can divide max number by mid within maxOperations
            if (isPossible(nums, mid, maxOperations)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    static boolean isPossible(int[] nums, int mid, int maxOperations) {
        int totalOperations = 0;

        for (var num : nums) {
            int operations = num / mid;
            if (num % mid == 0) {
                operations -= 1;
            }

            totalOperations += operations;
        }

        if (totalOperations <= maxOperations) {
            return true;
        }
        return false;
    }
}
