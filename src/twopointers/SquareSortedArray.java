package twopointers;

public class SquareSortedArray {

    public int[] squareSortedArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int highest = arr.length-1;
        int[] squaredArray = new int[arr.length];

        while (left <= right) {
            int squareLeft = arr[left] * arr[left];
            int squareRight = arr[right] * arr[right];

            if (squareLeft > squareRight) {
                squaredArray[highest] = squareLeft;
                left++;
            } else {
                squaredArray[highest] = squareRight;
                right--;
            }

            highest--;
        }

        return squaredArray;
    }
}
