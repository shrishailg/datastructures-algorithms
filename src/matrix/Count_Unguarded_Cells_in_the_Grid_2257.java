package matrix;

public class Count_Unguarded_Cells_in_the_Grid_2257 {

    public static void main(String[] args) {
       int[][] guards = {{0,0},{1,1},{2,3}};
       int[][] walls = {{0,1},{2,2},{1,4}};
       int m = 4;
       int n=6;

       System.out.println(countUnguarded(m,n, guards, walls));
    }

    //O(M*N)
    public  static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // gaurd: 1
        // wall: 2
        // gruarded by: 3
        // unguarded: 0

        int[][] result = new int[m][n];

        //O(m)
        for (var row : guards) {
            int i = row[0];
            int j = row[1];

            result[i][j] = 1;
        }

        //O(n)
        for (var row : walls) {
            int i = row[0];
            int j = row[1];

            result[i][j] = 2;
        }

        //O(m)
        for (var gaurd : guards) {
            int i = gaurd[0];
            int j = gaurd[1];
            markGaurded(result, i, j, m, n);
        }

        //O(m * n)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    //O(N)
    static void  markGaurded(int[][] result, int row, int col, int m, int n) {
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return;
        }

        if (result[row][col] == 2) {
            return;
        }

        // fill upward directions
        //O(m)
        for (int i = row - 1; i >= 0; i--) {
            if (result[i][col] == 1 || result[i][col] == 2) {
                break;
            }
            if (result[i][col] == 0) {
                result[i][col] = 3;
            }
        }

        // fill downward directions
        //O(m)
        for (int i = row + 1; i < m; i++) {
            if (result[i][col] == 1 || result[i][col] == 2) {
                break;
            }

            if (result[i][col] == 0) {
                result[i][col] = 3;
            }
        }

        // fill left directions
        //O(n)
        for (int i = col - 1; i >= 0; i--) {
            if (result[row][i] == 1 || result[row][i] == 2) {
                break;
            }

            if (result[row][i] == 0) {
                result[row][i] = 3;
            }
        }

        // fill right directions
        //O(n)
        for (int i = col + 1; i < n; i++) {
            if (result[row][i] == 1  || result[row][i] == 2) {
                break;
            }

            if (result[row][i] == 0) {
                result[row][i] = 3;
            }
        }
    }
}
