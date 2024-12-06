package sliding_window;

import java.util.Arrays;

public class ChocalateDistribution {

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        System.out.println(getMinChocalates(arr, 5));
    }

    public static int getMinChocalates(int[] arr, int m) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

//        minDiff = Math.min(minDiff, arr[m -1] - arr[0]);
        for (int i = 0; i < arr.length - m - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + m - 1] - arr[i]);
        }

        return minDiff;
    }
}
