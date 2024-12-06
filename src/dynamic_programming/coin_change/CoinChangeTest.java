package dynamic_programming.coin_change;

public class CoinChangeTest {

    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3};
        CoinChange coinChange = new CoinChange();

        CoinChangeTopDown coinChangeTopDown = new CoinChangeTopDown();

        CoinChangeBottomUp coinChangeBottomUp = new CoinChangeBottomUp();


        System.out.println(coinChange.getMaxWays(arr, arr.length, 5));

        System.out.println(coinChangeTopDown.getMaxChanges(arr, arr.length, 5));

        System.out.println(coinChangeBottomUp.getMaxChanges(arr, arr.length, 5));
    }
}
