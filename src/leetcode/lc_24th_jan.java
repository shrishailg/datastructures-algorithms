package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc_24th_jan {

    public static void main(String[] args){
       int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};

       System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        boolean[] visited = new boolean[v];
        boolean[] inRecursion = new boolean[v];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, inRecursion);
            }
        }

        for (int i = 0; i < v; i++) {
            if (!inRecursion[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean dfs(int[][] graph, int u, boolean[] visited, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;

        for (var v : graph[u]) {
            if (!visited[v] && dfs(graph, v, visited, inRecursion)) {
                return true;
            } else if (inRecursion[v]) {
                return true;
            }
        }

        inRecursion[u] = false;
        return false;
    }
}
