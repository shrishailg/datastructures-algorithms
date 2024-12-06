package dynamic_programming.longest_increasing_subsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int getLongestSubsequence(int[] arr) {
        int n = arr.length;
        int res = 1;

        for (int i = 1; i < n; i++) {
            int temp = lis(arr, i);
            res = Math.max(res, temp);
        }

        return res;
    }

    public int lis(int[] arr, int index) {
        if (index == 0) return 1;

        int count = 1;

        for (int i = 0; i <= index; i++) {
            if (arr[i] < arr[index]) {
                count = Math.max(count, lis(arr, i) + 1);
            }
        }

        return count;
    }

    int getMaxLisIterative(int[] arr) {
        int[] lis = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 1; int prev = i;
            for (int j=i+1;j< arr.length;j++){
                if (arr[j] > arr[prev]){
                    count++;
                    prev = j;
                }
            }

            lis[i] = count;
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {
            max=Math.max(max, lis[i]);
        }

        return max;
    }
}
