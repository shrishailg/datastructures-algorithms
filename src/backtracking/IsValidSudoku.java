package backtracking;

import java.util.*;

public class IsValidSudoku {

    public static void main(String[] args) {
        int[][] mat = {
                {9, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 5, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        System.out.println(isValid(mat) ? "true" : "false");
    }

    // time: (N*M) and space: O(N*M)
    public static boolean isValid(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        Map<Integer, Set<Integer>> rowValues = new HashMap<>();
        Map<Integer, Set<Integer>> colValues = new HashMap<>();
        Map<Integer, Set<Integer>> grid = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int value = matrix[i][j];

                // Skip empty cells
                if (value == 0)
                    continue;

                Set<Integer> rowSet = rowValues.get(i);
                if (rowSet != null && rowSet.contains(value))
                    return false;

                Set<Integer> colSet = colValues.get(j);
                if (colSet != null && colSet.contains(value))
                    return false;

                int box = ((i/3)*3) + (j / 3);
                Set<Integer> gridSet = grid.get(box);

                if (gridSet != null && gridSet.contains(value))
                    return false;

                if (rowSet == null) {
                    rowSet = new HashSet<>();
                    rowSet.add(value);
                    rowValues.put(i, rowSet);
                } else {
                    rowSet.add(value);
                    rowValues.put(i, rowSet);
                }

                if (colSet == null) {
                    colSet = new HashSet<>();
                    colSet.add(value);
                    colValues.put(j, colSet);
                } else {
                    colSet.add(value);
                    colValues.put(j, colSet);
                }

                if (gridSet == null) {
                    gridSet = new HashSet<>();
                    gridSet.add(value);
                    grid.put(box, gridSet);
                } else {
                    gridSet.add(value);
                    grid.put(box, gridSet);
                }
            }
        }

        return true;
    }


    // time: O(N^2), space: O(N^2)
    public static boolean isValidOptimized(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[][] rowValues = new int[10][10];
        int[][] colValues = new int[10][10];
        int[][] grid = new int[10][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int value = matrix[i][j];

                // Skip empty cells
                if (value == 0)
                    continue;

                if (rowValues[i][value] != 0)
                    return false;

                rowValues[i][value] = 1;

                if (colValues[j][value] != 0)
                    return false;

                colValues[j][value] = 1;

                int box = ((i/3)*3) + (j / 3);

                if (grid[box][value] != 0)
                    return false;

                grid[box][value] = 1;
            }
        }

        return true;
    }
}
