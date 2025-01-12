package binery_search;

import java.util.Arrays;

public class Aggressive_Cows {

    public static void main(String[] args) {
        int[] stalls = {1,2,3,4,7};
        int m = 3;

        System.out.println(aggresiveCows(stalls, m));
    }

    public static int aggresiveCows(int[] stalls, int m) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canWePlace(stalls, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private static boolean canWePlace(int[] stalls, int distance, int cows) {
        int countCows = 1;
        int lastPostion = stalls[0];

        for (int i = 0; i < stalls.length; i++) {
            if (stalls[i] - lastPostion >= distance) {
                countCows++;
                lastPostion = stalls[i];
            }

            if (countCows >= cows) {
                return true;
            }
        }

        return false;
    }
}
