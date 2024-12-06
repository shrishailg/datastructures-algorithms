package dynamic_programming.coin_change;

public class CoinChange {

    public int getMaxWays(int[] arr, int n, int sum){
        if (sum == 0)
            return 1;
        if (n <= 0 || sum < 0)
            return 0;

        int sum1 = 0;
        if (sum >= arr[n-1])
            sum1 = getMaxWays(arr, n, sum - arr[n-1]);

        int sum2 = getMaxWays(arr, n-1, sum);

        return sum1 + sum2;
    }
}
