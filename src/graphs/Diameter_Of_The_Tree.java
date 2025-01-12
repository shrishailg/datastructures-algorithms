package graphs;

import java.util.*;

public class Diameter_Of_The_Tree {

    public int treeDiameter(int[][] edges) {
        // Number of nodes in the tree
        int n = edges.length + 1;

        // Build adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            List<Integer> uList = adj.getOrDefault(u, new ArrayList<>());
            uList.add(v);

            adj.put(u,uList);

            List<Integer> vList = adj.getOrDefault(v, new ArrayList<>());
            vList.add(u);
            adj.put(v,vList);
        }

        // Find the diameter of the tree
        return findDiameter(n, adj);
    }

    // Function to find the diameter of a tree using two BFS calls
    private int findDiameter(int n, Map<Integer, List<Integer>> adj) {
        // First BFS to find the farthest node from any arbitrary node (e.g., 0)
        int[] farthestNodeResult = findFarthestNode(n, adj, 0);

        // Second BFS from the farthest node to determine the diameter
        int[] diameterResult = findFarthestNode(n, adj, farthestNodeResult[0]);
        return diameterResult[1];
    }

    // BFS helper function to find the farthest node and its distance from the source
    private int[] findFarthestNode(int n, Map<Integer, List<Integer>> adj, int sourceNode) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // Push source node into the queue
        que.add(sourceNode);
        visited[sourceNode] = true;

        int maximumDistance = 0;
        int farthestNode = sourceNode;

        // Explore neighbors
        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                int currentNode = que.poll();
                // Update farthest node
                farthestNode = currentNode;

                for (int neighbor : adj.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        que.add(neighbor);
                    }
                }
            }

            maximumDistance++;
        }

        // Return an array with farthest node and its distance
        return new int[]{farthestNode, maximumDistance};
    }
}
