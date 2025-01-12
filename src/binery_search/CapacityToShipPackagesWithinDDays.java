package binery_search;


/*
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i].
 Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
  We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the
packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 */
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }


    public static int shipWithinDays(int[] weights, int days) {
        int totalWieght = 0;
        int maxWeight = 0;

        for (var weight : weights) {
            totalWieght += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int low = maxWeight;
        int high = totalWieght;

        int mini = Integer.MAX_VALUE;

        while (low <= high) {
            int capacity = (high + low) / 2;

            if (daysLoading(weights, capacity, days)) {
                mini = Math.min(mini, capacity);
                high = capacity - 1;
            } else {
                low = capacity + 1;
            }
        }

        return mini;
    }

    private static boolean daysLoading(int[] weights, int capacity, int days) {
        int daysCount = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacity) {
                load = weights[i];
                daysCount++;
            } else {
                load += weights[i];
            }
        }

        return daysCount <= days;
    }
}
