package leetcode;

import java.util.Arrays;

public class lc_20th_mar {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        int n = 3;
//
//        int[][] edges = new int[][]{{0,1,7},{1,3,7},{1,2,1}};
//        int[][] query = new int[][]{{0,3},{3,4}};

        int[][] edges = new int[][]{{1,0,4},{0,2,5},{0,2,3},{0,2,14},{0,2,12},{2,0,14},{0,2,4}};
        int[][] query = new int[][]{{2,1}};

        System.out.println(Arrays.toString(minimumCost(n, edges, query)));
    }

    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];

            union(u, v, parent, rank);
        }

        int[] cost = new int[n];
        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int parent_u = find(u, parent);

            if (cost[parent_u] == 0) {
                cost[parent_u] = w;
            } else {
                cost[parent_u] &= w;
            }
        }

        int[] result = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            int u = query[i][0];
            int v = query[i][1];

            int u_parent = find(u, parent);
            int v_parent = find(v, parent);

            if (u_parent != v_parent) {
                result[i] = -1;
            } else {
                result[i] = cost[u_parent];
            }
        }

        return result;
    }

    public static void union(int x, int y, int[] parent, int[] rank) {
        int u_parent = find(x, parent);
        int v_parent = find(y, parent);

        if (u_parent == v_parent) {
            return;
        } else {
            if (rank[x] > rank[y]) {
                parent[y] = x;
            } else if (rank[x] < rank[y]) {
                parent[x] = y;
            } else {
                parent[x] = y;
                rank[y]++;
            }
        }
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }
}
