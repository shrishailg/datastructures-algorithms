package greedy;

import java.util.HashSet;
import java.util.Set;

/*
You are given an integer array banned and two integers n and maxSum.
You are choosing some number of integers following the below rules:

The chosen integers have to be in the range [1, n].
Each integer can be chosen at most once.
The chosen integers should not be in the array banned.
The sum of the chosen integers should not exceed maxSum.
Return the maximum number of integers you can choose following the mentioned rules.

Input: banned = [1,6,5], n = 5, maxSum = 6
Output: 2
Explanation: You can choose the integers 2 and 4.
2 and 4 are from the range [1, 5], both did not appear in banned, and their sum is 6, which did not exceed maxSum.

 */

public class Maximum_Number_of_Integers_to_Choose_From_a_Range_I_2554 {

    public static void main(String... args) {
       int[] banned = {1,6,5};
       int n = 5;
       int maxSum = 6;

       System.out.println(maxCountOptimised(banned, n, maxSum));
        System.out.println(maxCount(banned, n, maxSum));
    }

    //O(NlogM) time complexity
    //O(1) space complexity
    public static int maxCountOptimised(int[] banned, int n, int maxSum) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (search(banned, i)) {
                continue;
            }

            if (sum + i > maxSum) {
                break;
            }

            sum += i;
            count++;
        }

        return count;
    }

    static boolean search(int[] arr, int target) {
        int low=0;
        int high = arr.length-1;

        while(low<=high) {
            int mid = low + ((high-low)/2);

            if(arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return false;
    }

    //O(n) time complexity
    //O(n) space complexity
    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();

        for (var bannedValue : banned) {
            set.add(bannedValue);
        }

        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }

            if (sum + i > maxSum) {
                break;
            }

            sum += i;
            count++;
        }

        return count;
    }
}
