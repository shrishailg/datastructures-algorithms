package binery_search;

import java.util.Arrays;

/*
In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
 Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the
  baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6].
The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.
 */
public class MagneticForceBetweenBalls {

    public static void main(String[] args) {
       int[] position = {1,2,3,4,7};
        int m = 3;

        System.out.println(maxDistance(position, m));
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 0;
        int high = position[position.length - 1] - position[0];

        int maxMagneticForce = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canBallsPlaced(position, mid, m)) {
                maxMagneticForce = Math.max(maxMagneticForce, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxMagneticForce;
    }

    private static boolean canBallsPlaced(int[] position, int distance, int m) {
        int balls = 1;
        int lastPostion = position[0];

        for (int i = 0; i < position.length; i++) {
            if (position[i] - lastPostion >= distance) {
                balls++;
                lastPostion = position[i];
            }

            if (balls >= m) {
                return true;
            }
        }

        return balls >= m;
    }
}
