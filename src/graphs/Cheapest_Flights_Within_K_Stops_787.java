package graphs;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops_787 {

    //using BFS
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // create adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (var flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];

            List<int[]> list = adj.get(u);
            list.add(new int[] { v, wt });
            adj.put(u, list);
        }

        int[] result = new int[n];

        Arrays.fill(result, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { src, 0 });
        result[src] = 0;

        int level = 0;

        while (!queue.isEmpty() && level <=k) {
            int size = queue.size();

//            if (level > k) {
//                break;
//            }

            while (size-- > 0) {
                int[] current = queue.peek();
                queue.poll();
                int u = current[0];
                int dist = current[1];

                for (var node : adj.get(u)) {
                    int v = node[0];
                    int distance = node[1];

                    if (dist + distance < result[v]) {
                        result[v] = dist + distance;
                        queue.add(new int[] { v, dist + distance });
                    }
                }
            }

            level++;
        }

        return result[dst] == Integer.MAX_VALUE ? -1 : result[dst];
    }
}
