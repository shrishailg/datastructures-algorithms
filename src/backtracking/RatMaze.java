package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    static String direction = "DLRU";

    static int[][] dr = { {1, 0, }, {0, -1 }, {-1,0}, {0,1}};

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        int n = maze.length;

        // List to store all the valid paths
        List<String> result = new ArrayList<>();

        // Store current path
        StringBuilder path = new StringBuilder();

        if (maze[0][0] != 0 && maze[n - 1][n - 1] != 0) {
            // Function call to get all valid paths
            recursion(maze, 0, 0,path, result);
        }

        for (String value : result)
            System.out.println(value);
    }


    public static void recursion(int[][] matrix, int rowIndex, int colIndex, StringBuilder path, List<String> result){
        if (rowIndex < 0 || colIndex < 0 || rowIndex > matrix.length-1 || colIndex>matrix[0].length-1 || matrix[rowIndex][colIndex] != 1){
            return;
        }

        if (rowIndex == matrix.length -1 && colIndex == matrix[0].length-1){
            result.add(path.toString());
        }

        matrix[rowIndex][colIndex] = 0;
        recursion(matrix, rowIndex + 1, colIndex, path.append('D'), result);
        path.deleteCharAt(path.length() - 1);
        recursion(matrix, rowIndex, colIndex -1, path.append('L'), result);
        path.deleteCharAt(path.length() - 1);
        recursion(matrix, rowIndex, colIndex + 1, path.append('R'), result);
        path.deleteCharAt(path.length() - 1);
        recursion(matrix, rowIndex -1, colIndex, path.append('U'), result);
        path.deleteCharAt(path.length() - 1);

//        for (int i = 0; i < 4; i++) {
//            // Find the next row based on the current row
//            // (row) and the dr[] array
//            int nextrow = rowIndex + dr[i];
//            // Find the next column based on the current
//            // column (col) and the dc[] array
//            int nextcol = colIndex + dc[i];
//
//            // Check if the next cell is valid or not
//                path.append(direction.charAt(i));
//                // Recursively call the FindPath function
//                // for the next cell
//            recursion(matrix, nextrow, nextcol , path, result);
//                // Remove the last direction when
//                // backtracking
//                path.deleteCharAt(
//                        path.length() - 1);
//        }


        matrix[rowIndex][colIndex] = 1;
    }
}
