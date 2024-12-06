package graphs;

import java.util.*;

public class CourseScheduleII {

    public static void main(String... args) {
        int n=4;
        int[][] a = new int[][] {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(findOrder(n, a)));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(var c : prerequisites[0]){

        }

        for (int u = 0; u < numCourses; u++) {
            int a = prerequisites[u][0];
            int b = prerequisites[u][1];

            indegree[a]++;
            List<Integer> list = adj.getOrDefault(b, new ArrayList<>());
            list.add(a);
            adj.put(b, list);
        }

        return topologicalSort(adj, numCourses, indegree);

    }

    static int[] topologicalSort(Map<Integer, List<Integer>> adj, int n, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int size = 0;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
                result[size++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (Objects.nonNull(adj.get(u))) {
                for (var v : adj.get(u)) {
                    indegree[v]--;

                    if (indegree[v] == 0) {
                        queue.add(v);
                        count++;
                        result[size++] = v;
                    }
                }
            }
        }

        if (count == n) {
            return result;
        } else {
            return new int[] {};
        }
    }
}
