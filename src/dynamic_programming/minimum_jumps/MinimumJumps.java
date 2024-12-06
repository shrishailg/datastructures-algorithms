package dynamic_programming.minimum_jumps;

public class MinimumJumps {

    public int findMinJumps(int[] arr){
        int start = 0;
        int total = 0;

        while (start < arr.length - 1){
            if (arr[start] == 0)
                return 0;
            start = start + arr[start];
            total += 1;
        }

        return total;
    }

    public int findMinJumpsRecursion(int[] arr, int n, int jumps){
        if (n >= arr.length-1)
            return jumps;
        else if (arr[n] == 0)
            return 0;
        else
            return findMinJumpsRecursion(arr, n + arr[n], jumps + 1);
    }
}
