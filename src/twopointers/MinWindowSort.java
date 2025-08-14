package twopointers;

import java.util.Map;

public class MinWindowSort {


    public int findMinWindowSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while (low<arr.length && arr[low] < arr[low+1]) {
            low++;
        }

        if (low == arr.length) {
            return 0;
        }

        while (high>=0 && arr[high]> arr[high-1])
            high--;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int k=low;k<=high;k++) {
            max = Math.max(max, arr[k]);
            min = Math.min(min, arr[k]);
        }

        while (low>=0 && arr[low-1]>min)
            low--;

        while (high<arr.length && arr[high+1] < max) {
            high++;
        }

        return high-low+1;
    }
}
