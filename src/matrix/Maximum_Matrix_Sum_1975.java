package matrix;

public class Maximum_Matrix_Sum_1975 {

    public static void main(String[] args) {
       int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};

       System.out.println(maxMatrixSum(matrix));

    }

    // if no of -ves are odd: make smallest number as -ve
    // if no of -ves are even: all becoz +ve so no nees to worry
    //O(m*n)
    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0;

        long noOfNegative = 0;
        int smallest = Integer.MAX_VALUE;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = ints[j];
                if (value < 0) {
                    noOfNegative++;
                }

                int absValue = Math.abs(value);
                smallest = Math.min(smallest, absValue);
                sum += absValue;
            }
        }

        // why 2?: since this is includes in the sum 2 times
        // two no give -1 and +1 ==> answer should be 0
        // sum = abs(-1) + abs(1) = 2
        // sum -= 2 * abs(-1) = 0
        if (noOfNegative % 2 == 1) {
            sum -= 2L * smallest;
        }

        return sum;
    }
}
