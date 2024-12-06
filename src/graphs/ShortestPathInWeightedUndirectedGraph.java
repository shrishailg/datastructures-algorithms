package graphs;

import java.util.*;


//using dijkstra algorithm
public class ShortestPathInWeightedUndirectedGraph {

    public static void main(String... args) {

    }

    //edge == {{source, destination, weight}, {source1, destination1, weight1}}
    private static List<Integer> shortestPath(int n, int m, int[][] edges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (var u : edges) {
            int source = u[0];
            int dest = u[1];
            int wt = u[2];

            //{node, weight}
            List<int[]> sourceList = adj.getOrDefault(source, new ArrayList<>());
            sourceList.add(new int[]{dest, wt});

            adj.put(source, sourceList);

            List<int[]> destList = adj.getOrDefault(source, new ArrayList<>());
            destList.add(new int[]{source, wt});

            adj.put(dest, destList);
        }

        //numbered 1 to n including
        int[] result = new int[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(result, Integer.MAX_VALUE);


        // {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        //always start with 1 and destination is n
        result[1] = 1;

        //1th parent is 1 itself
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] popped = pq.poll();
            int distance = popped[1];
            int node = popped[0];

            for (var v : adj.get(node)) {
                int adjNode = v[1];
                int weight = v[0];

                if (distance + weight < result[adjNode]) {
                    result[adjNode] = distance + weight;
                    pq.add(new int[]{distance + weight, adjNode});
                    parent[adjNode] = node;
                }
            }
        }

        int destinationNode = n;

        if (result[destinationNode] == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();

        while (parent[destinationNode] != destinationNode) {
            path.add(destinationNode);
            destinationNode = parent[destinationNode];
        }

        path.add(1);

        Collections.reverse(path);

        return path;
    }
}
