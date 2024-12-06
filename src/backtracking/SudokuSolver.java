package backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public static void main(String... args) {
        int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        if (solveSudoku(grid))
            System.out.print(Arrays.deepToString(grid));
        else
            System.out.println("No solution exists");
    }

    public static boolean solveSudoku(int[][] matrix ) {
       return recursion(0, 0, matrix);
    }

    private static boolean recursion( int i, int j, int[][] matrix ) {
        if ( i == 8 && j == 9 ) {
            return true;
        }

        if ( j == 9 ) {
            i = i + 1;
            j = 0;
        }

        if (matrix[i][j] != 0) {
            return recursion(i, j + 1, matrix);
        }

        for ( int x = 1; x <= 9; x++ ) {

            if (isValid(matrix, i,j, x)){
                matrix[i][j] = x;
                boolean f = recursion(i, j+1, matrix);
                if (f){
                    return true;
                }
            }

            matrix[i][j] = 0;
        }

        return false;
    }

    private static boolean isValid(int[][] matrix, int i, int j, int k) {
        for(int y = 0 ; y  < 9; y++) {
            if (matrix[i][y] ==  k ) {
                return false;
            }

            if (matrix[y][j] == k ) {
                return false;
            }
        }

//        int box = (i/3) * 3 + (j/3);
//        for (int x = 0; x < 9; x++) {
//            for(int y = 0; y < 9; y++) {
//                int key = (x/3) * 3 + (y/3);
//                if (box == key) {
//                    if (matrix[x][y] ==  k )
//                        return false;
//                }
//            }
//        }

        int row = i - i % 3;
        int col = j - j % 3;

        for (int a = row; a < row + 3; a++) {
            for (int b = col; b < col + 3; b++) {
                if (matrix[a][b] == k)
                    return false;
            }
        }

        return true;
    }
}
