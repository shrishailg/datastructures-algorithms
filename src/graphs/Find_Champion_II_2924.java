package graphs;

public class Find_Champion_II_2924 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2}};

        System.out.println(findChampion(n, edges));
    }


//O(n)
    public static int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (var edge : edges) {
            int u = edge[0];
            int v = edge[1];

            indegree[v]++;
        }

        int champion = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                champion = i;
                count++;

                if (count > 1) {
                    return -1;
                }
            }
        }

        return champion;
    }
}
