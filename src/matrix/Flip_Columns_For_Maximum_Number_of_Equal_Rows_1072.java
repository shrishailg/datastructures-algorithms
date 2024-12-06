package matrix;

import java.util.Arrays;

public class Flip_Columns_For_Maximum_Number_of_Equal_Rows_1072 {

    public static void main(String... args) {
       int[][] matrix = {{0,1},{1,0}};
       System.out.println(maxEqualRowsAfterFlips(matrix));
    }

    //O(n*m)
    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxRowsMatched = 0;
        for (var curRow : matrix) { //O(n)
            int[] invertedRow = new int[curRow.length];

            for (int col = 0; col < n; col++) { //(n*m)
                invertedRow[col] = curRow[col] == 1 ? 0 : 1;
            }

            int count = 0;
            for (var row : matrix) { //O(n)
                if (Arrays.equals(row, curRow) || Arrays.equals(row, invertedRow)) { //O(n*m)
                    count++;
                }
            }

            System.out.println(count);

            maxRowsMatched = Math.max(maxRowsMatched, count);
        }

        return maxRowsMatched;
    }
}
