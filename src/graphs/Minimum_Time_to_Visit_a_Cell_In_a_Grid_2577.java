package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Minimum_Time_to_Visit_a_Cell_In_a_Grid_2577 {
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    //using dijkstra
    // E log(V)
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        int[][] result = new int[m][n];

        //to avoid the loop
        boolean[][] visited = new boolean[m][n];

        for (var row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[] { 0, 0, 0 });
        result[0][0] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];

            if (visited[x][y]) {
                continue;
            }

            // you can return as well as from the bottom
            if(x == m-1 && y ==n-1) {
                return result[m-1][n-1];
            }

            visited[x][y] = true;
            for (var direction : directions) {
                int new_x = x + direction[0];
                int new_y = y + direction[1];

                if (new_x < 0 || new_y < 0 || new_x >= m || new_y >= n) {
                    continue;
                }

                if (grid[new_x][new_y] <= time + 1) {
                    minHeap.add(new int[] { new_x, new_y, time + 1 });
                    if (result[new_x][new_y] > time + 1) {
                        result[new_x][new_y] = time + 1;
                    }

                }
                // 0,1,3 --> from time 1 to 3 = (3-1) = 2%2 = 0 = 4 ==> (3+1)
                else if ((grid[new_x][new_y] - time) % 2 == 0) { // even
                    minHeap.add(new int[] { new_x, new_y, grid[new_x][new_y] + 1 });
                    if (result[new_x][new_y] > grid[new_x][new_y] + 1) {
                        result[new_x][new_y] = grid[new_x][new_y] + 1;
                    }
                }
                // 0,1,4 --> from time 1 to 4 = (4-1) = 3%2 = 1 = 4
                else {
                    minHeap.add(new int[] { new_x, new_y, grid[new_x][new_y] });

                    if (result[new_x][new_y] > grid[new_x][new_y]) {
                        result[new_x][new_y] = grid[new_x][new_y];
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }

}
