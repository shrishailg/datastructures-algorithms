package binery_search;

import java.util.Arrays;

/*
You are given an array with unique elements of stalls[], which denote the position of a stall.
You are also given an integer k which denotes the number of aggressive cows.
Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3

Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.
 */

public class Aggressive_Cows {

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int m = 3;

        System.out.println(aggresiveCows(stalls, m));
    }

    public static int aggresiveCows(int[] stalls, int m) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        int maxi = Integer.MIN_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (canWePlace(stalls, mid, m)) {
                maxi = Math.max(maxi, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxi;
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
