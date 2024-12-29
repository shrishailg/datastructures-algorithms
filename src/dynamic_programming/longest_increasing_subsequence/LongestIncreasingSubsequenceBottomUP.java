package dynamic_programming.longest_increasing_subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequenceBottomUP {

    public int getMaxLIS(int[] arr) {
        int n = arr.length;

        int[] lis = new int[n];

        Arrays.fill(lis, 1);

        int max = -1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = 1 + lis[j];
                    max = Math.max(max, lis[i]);
                }
            }
        }

        return max;
    }
}
