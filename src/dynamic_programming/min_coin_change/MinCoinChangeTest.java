package dynamic_programming.min_coin_change;

public class MinCoinChangeTest {

    public static void main(String... args) {
        MinCoinChange minCoinChange = new MinCoinChange();
        int[] arr = {1,2,3};
        int[] arr1 = {4, 6, 2};

        System.out.println(minCoinChange.getMinChanges(arr, 5));
        System.out.println(minCoinChange.getMinChanges(arr1, 5));
    }
}
