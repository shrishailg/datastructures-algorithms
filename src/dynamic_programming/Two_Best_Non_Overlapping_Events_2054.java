package dynamic_programming;

/*
You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei].
The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei.
You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

Return this maximum sum.

Note that the start time and end time is inclusive:
that is, you cannot attend two events where one of them starts and the other ends at the same time.
 More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
 */

import java.util.Arrays;

public class Two_Best_Non_Overlapping_Events_2054 {

    public static void main(String... args) {
        int[][] events = {{1,3,2},{4,5,2},{2,4,3}};

        System.out.println(maxTwoEventsOptimised(events));
        System.out.println(maxTwoEvents(events));
    }

    public static int maxTwoEventsOptimised(int[][] events) {
        int n = events.length;
        int[][] dp = new int[n + 1][3];
        for (var row : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        return recursion(0, 0, n, events, dp);
    }

    static int recursion(int index, int count, int n, int[][] events, int[][] dp) {
        if (count == 2 || index >= n) {
            return 0;
        }

        if (dp[index][count] != -1) {
            return dp[index][count];
        }

        int nextValidIndex = binerySearch(events, events[index][1]);
        int take = events[index][2] + recursion(nextValidIndex, count + 1, n, events, dp);
        int not_take = recursion(index + 1, count, n, events, dp);

        return dp[index][count] = Math.max(take, not_take);
    }

    //upper bound of endTime
    static int binerySearch(int[][] events, int endTime) {
        int low = 0;
        int high = events.length - 1;
        int result = events.length;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (events[mid][0] > endTime) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static int maxTwoEvents(int[][] events) {
        int result = 0;
        int n = events.length;

        for (int i = 0; i < n; i++) {
            int value = events[i][2];
            result = Math.max(result, value);
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (events[i][1] >= events[j][0]) {
                    continue;
                }

                result = Math.max(result, value + events[j][2]);
            }
        }

        return result;
    }
}
