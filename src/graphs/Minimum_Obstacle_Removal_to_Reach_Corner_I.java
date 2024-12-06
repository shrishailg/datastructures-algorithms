package graphs;

import java.util.*;

public class Minimum_Obstacle_Removal_to_Reach_Corner_I {

    static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String... args) {
        int[][] arr = {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};

        System.out.println(minimumObstaclesBFS(arr));
    }

    // using dijsktra Time complexity: O(E log(V))
    //E: No of edges
    //V : no of vertices
    public static int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for (var row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        result[0][0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[] { 0, 0, 0 });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];
            int wt = current[2];

            for (var dir : direction) {
                int new_x = x + dir[0];
                int new_y = y + dir[1];

                if (new_x < 0 || new_y < 0 || new_x >= m || new_y >= n) {
                    continue;
                }

                int distance = (grid[new_x][new_y] == 1) ? 1 : 0;

                if (result[new_x][new_y] > wt + distance) {
                    result[new_x][new_y] = wt + distance;
                    queue.add(new int[] { new_x, new_y, wt + distance });
                }
            }
        }

        return result[m - 1][n - 1];
    }

    //using BFS algorithm
    public static int minimumObstaclesBFS(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];

        for(var row:result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        result[0][0] = grid[0][0];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {
            int[] current = queue.pollFirst();

            int x = current[0];
            int y = current[1];

            for(var dir: direction) {
                int new_x = x + dir[0];
                int new_y = y + dir[1];

                if(new_x < 0 || new_y < 0 || new_x >= m || new_y >= n || grid[new_x][new_y] == 2) {
                    continue;
                }

                int newCost = result[x][y] + grid[new_x][new_y];

                if(result[new_x][new_y] > newCost) {
                    result[new_x][new_y] = newCost;
                }

                if (grid[new_x][new_y] == 0) {
                    queue.addFirst(new int[]{new_x, new_y});
                } else  {
                    queue.addLast(new int[]{new_x, new_y});
                }
            }

            grid[x][y] = 2;
        }

        return result[m-1][n-1];
    }
}
