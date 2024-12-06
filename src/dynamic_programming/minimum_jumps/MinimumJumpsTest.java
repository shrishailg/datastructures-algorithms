package dynamic_programming.minimum_jumps;

public class MinimumJumpsTest {

    public static void main(String[] args){
        MinimumJumps minimumJumps = new MinimumJumps();
        int[] arr = new int[]{2, 1, 1, 1, 4};
        int[] arr1 = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        System.out.println(minimumJumps.findMinJumps(arr));

        System.out.println(minimumJumps.findMinJumps(arr1));

        System.out.println(minimumJumps.findMinJumpsRecursion(arr, 0 ,0 ));

        System.out.println(minimumJumps.findMinJumpsRecursion(arr1, 0, 0));
    }
}
