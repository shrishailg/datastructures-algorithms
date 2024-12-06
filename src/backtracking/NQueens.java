package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);

        for (var list : result) {
            System.out.println(list);
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        String[][] tempBoard = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempBoard[i][j] = ".";
            }
        }

        Testing testing =  new Testing(0);

        recursion(0, n, tempBoard, board, testing);

        System.out.println("total length is " + testing.getValue());
        return board;
    }

    private static void recursion(int rowIndex, int n, String[][] tempBoard, List<List<String>> board, Testing testing) {
        if (rowIndex == n) {
            board.add(convertArrayToList(tempBoard, n));
            testing.setValue(testing.getValue() + 1);
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (isSafe(rowIndex, colIndex, n, tempBoard)) {
                tempBoard[rowIndex][colIndex] = "Q";
                recursion(rowIndex + 1, n, tempBoard, board, testing);
                tempBoard[rowIndex][colIndex] = ".";
            }
        }
    }

    private static boolean isSafe(int i, int j, int n, String[][] board) {
        for (int x = 0; x < i; x++) {
            for (int y = 0; y < n; y++) {
                if (Objects.equals(board[x][y], "Q")) {
                    if (j == y || (Math.abs(i - x) == Math.abs(j - y))) return false;
                }
            }
        }

        return true;
    }

    // Helper method to convert array to list
    static List<String> convertArrayToList(String[][] arr, int n) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < n; j++) {
                str.append(arr[i][j]);
            }
            result.add(new String(str));
        }

        return result;
    }


}
