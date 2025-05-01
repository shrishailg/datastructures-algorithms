package leetcode;

/*
You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks,
with the ith task requiring tasks[i] strength to complete. The strength of each worker is stored in a 0-indexed integer
array workers, with the jth worker having workers[j] strength. Each worker can only be assigned to a single task and must
have a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).

Additionally, you have pills magical pills that will increase a worker's strength by strength.
You can decide which workers receive the magical pills, however, you may only give each worker at most one magical pill.

Given the 0-indexed integer arrays tasks and workers and the integers pills and strength,
return the maximum number of tasks that can be completed.
Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
Output: 3
Explanation:
We can assign the magical pill and tasks as follows:
- Give the magical pill to worker 0.
- Assign worker 0 to task 2 (0 + 1 >= 1)
- Assign worker 1 to task 1 (3 >= 2)
- Assign worker 2 to task 0 (3 >= 3)
 */

import java.util.Arrays;
import java.util.TreeMap;

public class lc_1st_may_25 {

    public static void main(String... args) {
        int[] tasks = {3,2,1};
        int[] workers = {0,3,3};
        int pills = 1; int strength = 1;

        System.out.println(maxTaskAssign(tasks, workers, pills, strength));
    }

    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int l = 0;
        int r = Math.min(tasks.length, workers.length);
        int result = 0;

        Arrays.sort(tasks); // ascending order --> weakest task first
        Arrays.sort(workers);// descending order --> strongest worker first

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canComplete(tasks, workers, pills, strength, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    public static boolean canComplete(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;

        TreeMap<Integer, Integer> weakest = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; ++i) {
            weakest.put(workers[i], weakest.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; --i) {
            Integer key = weakest.lastKey();

            if (key >= tasks[i]) {
                weakest.put(key, weakest.get(key) - 1);
                if (weakest.get(key) == 0) {
                    weakest.remove(key);
                }
            } else {
                // we have to use pills
                if (p == 0) {
                    return false;
                }

                key = weakest.ceilingKey(tasks[i] - strength);

                if (key == null) {
                    return false;
                }

                weakest.put(key, weakest.get(key) - 1);

                if (weakest.get(key) == 0) {
                    weakest.remove(key);
                }

                p--;
            }
        }

        return true;
    }
}
