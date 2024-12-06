package dynamic_programming.min_coin_change;


public class MinCoinChange {

    public int getMinChanges(int[] arr, int sum) {
        int result = recursion(arr, arr.length, sum);
//        int result = recursionV2(arr, sum);
        return result == Integer.MAX_VALUE ? -1: result;
    }

    private int recursion(int[] arr, int n, int sum) {
        // this means sum is present in the array
        if (sum == 0) return 0;

        // this means that sum is not present in the array
        if (n <= 0) return Integer.MAX_VALUE;

        int count1 = Integer.MAX_VALUE;
        if (arr[n-1] <= sum) {
            int res = recursion(arr, n-1, sum-arr[n-1]);

            // to check if the sum is present or not
            if (res != Integer.MAX_VALUE)
                count1 = res + 1;
        }

        int count2 = recursion(arr, n-1, sum);

        return Math.min(count1, count2);
    }

    private int recursionV2(int[]  arr, int sum) {
        if (sum < 0)
            return Integer.MAX_VALUE;
        if (sum == 0)
            return 1;

        int ans = Integer.MAX_VALUE;

        for (var j : arr) {
            ans = Math.min(ans, recursionV2(arr, sum - j));
        }

        return ans+1;
    }
}
