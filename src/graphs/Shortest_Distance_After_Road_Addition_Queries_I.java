package graphs;

import java.util.*;

public class Shortest_Distance_After_Road_Addition_Queries_I {

    //O(N * (V+E)): V+E for bfs is called for every queries
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // create adjcency matrix
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            List<Integer> list = adj.get(i);
            list.add(i + 1);
            adj.put(i, list);
        }

        int[] result = new int[queries.length];
        int k=0;
        for (var query : queries) {
            int u = query[0];
            int v = query[1];

            List<Integer> list = adj.get(u);
            list.add(v);
            adj.put(u, list);

            int level = bfs(adj, n);

            result[k++] = level;
        }

        return result;
    }

    //Using dijkstra
    private int dijkstra(Map<Integer, List<Integer>> adj, int n) {
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
        minHeap.add(new int[]{0,0});
        result[0] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int u = current[0];
            int wt = current[1];

            for (var v : adj.get(u)) {
                int distance = 1;

                if(wt+distance<result[v]) {
                    result[v] = wt+distance;
                    minHeap.add(new int[]{v, wt+distance});
                }
            }
        }

        return result[n-1];
    }


    //Using BFS algorithm
    private int bfs(Map<Integer, List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                int u = queue.poll();

                //destination reached
                if (u == n - 1) {
                    return level;
                }

                for (var v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }

                size--;
            }

            level++;
        }

        //destination not reached
        return -1;
    }
}
