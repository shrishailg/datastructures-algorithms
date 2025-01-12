package binery_search;

import java.util.Arrays;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k.
Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Input: piles = [3,6,7,11], h = 8
Output: 4
 */

public class KokoEatingBanana {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while(low < right) {
            int mid = low + (right-low)/2;

            if(canEatAllBananas(piles, mid, h)) {
                right = mid;
            } else {
                low = mid + 1;
            }
        }

        return low; //or return right also
    }

    private static boolean canEatAllBananas(int[] piles, int hour, int h) {
        int totalHours = 0;

        for (int pile : piles) {
            int count = pile / hour;

            if (pile % hour != 0) {
                count++;
            }

            totalHours += count;
        }

        return totalHours<=h;
    }
}
