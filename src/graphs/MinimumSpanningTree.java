package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinimumSpanningTree {


    //adj: {{source, dest, weight}, {source, dest, weight}}
    int findMst(int[][] adj, int V) {
        boolean[] visited = new boolean[V];
//        int[] parent = new int[V];
//
//        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        //storing (node, weight)
        pq.add(new int[]{0, 0});

        int sum = 0;
        while(!pq.isEmpty()) {
           int[] popped = pq.poll();
           int node = popped[0];
           int weight = popped[1];

           if (visited[node]) {
               continue;
           }

           visited[node] = true;
           sum += weight;

           for(int[] adjNode: adj) {
               int source = adjNode[0];
               int neighbor = adjNode[1];
               int neighbor_weight = adjNode[2];

               if (source != node) {
                   continue;
               }

               if (!visited[neighbor]) {
                   pq.add(new int[]{neighbor, neighbor_weight});
               }
           }

        }

        return sum;
    }
}
