package dynamic_programming.longest_increasing_subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequenceTopDown {

    public int getMaxLIS(int[] arr) {
        int n = arr.length;

        int[] memo = new int[n];

        Arrays.fill(memo, -1);

        int res = 1;

        for (int i = 1; i < n; i++) {
            int temp = lis(arr, i, memo);
            res = Math.max(res, temp);
        }

        return res;
    }

    public int lis(int[] arr, int index, int[] memo) {
        if (index == 0) {
            return memo[index] = 1;
        } else if (memo[index] != -1) {
            return memo[index];
        }

        int max = 1;
        for (int i = 0; i < index; i++) {
            if (arr[index] > arr[i]) {
                max = Math.max(max, 1 + lis(arr, i, memo));
            }
        }

        memo[index] = max;

        return max;
    }
}
