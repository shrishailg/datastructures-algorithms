package leetcode;

import java.util.Arrays;

public class lc_23rd_jan {

    public static void main(String... args) {
        int[][] grid = {{1,0},{1,1}};
        System.out.println(countServers(grid));
    }

    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowIndex = new int[m];
        int[] colIndex = new int[n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    colIndex[j]++;
                    rowIndex[i]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if(colIndex[j]>1) {
                        count++;
                    } else if (rowIndex[i]>1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
