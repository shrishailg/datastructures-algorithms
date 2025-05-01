package binery_search;

/*
Given an array arr[] and k, where the array represents the boards and each element of the given array represents the length of each board.
k numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.
The task is to find the minimum time to get this job done by painting all the boards under the constraint that any painter
will only paint the continuous sections of boards. say board [2, 3, 4] or only board [1] or nothing but not board [2, 4, 5].

Input: arr[] = [5, 10, 30, 20, 15], k = 3
Output: 35
Explanation: The most optimal way will be: Painter 1 allocation : [5,10], Painter 2 allocation : [30],
Painter 3 allocation : [20, 15], Job will be done when all painters finish i.e. at time = max(5 + 10, 30, 20 + 15) = 35
*/

import java.util.Arrays;

public class PaintersPartition {

    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15} ;
        int k = 3;

        System.out.println(minimizeTime(arr, k));
    }


    private static int minimizeTime(int[] arr, int k) {
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();

        int low = max;
        int high = sum;

        int mini = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = (low+high)/2;

            if(canPaintAllWalls(arr, mid, k)) {
                mini = Math.min(mini, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return mini;
    }

    public static boolean canPaintAllWalls(int[] arr, int boardLen, int k) {
        int painters = 1;
        int board = 0;

        for(int i=0;i<arr.length;i++) {
            if (board + arr[i] <= boardLen) {
                board += arr[i];
            } else {
                board = arr[i];
                painters++;
            }
        }

        return painters <= k;
    }
}
