package greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumRefuelStops {

    public static void main(String[] args) {
        int target = 15;
        int startFuel = 3;
        int[][] arr = new int[][]{{2, 5}, {3, 1}, {6, 4}, {12, 6}};
        System.out.println(minRefuelStops(target, startFuel, arr));
    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target) {
            return 0;
        }

        if (startFuel < stations[0][0]) {
            return -1;
        }

        int stops = 0;
        int maxDistance = startFuel;
        int i = 0;
        int n = stations.length;

        //to store stations having max fuel capacity
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (maxDistance < target) {
            if (i < n && maxDistance >= stations[i][0]) {
                maxHeap.add(stations[i][1]);
                i++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            } else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }

        return stops;

    }
}
