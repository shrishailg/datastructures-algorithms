package dynamic_programming.knapsack_variation.fractional_knapsack;

public class KnapsackTest {

    public static void main(String[] args){
        Knapsack knapsack = new Knapsack();
        int[] wts = new int[]{10, 20, 30};
        int[] profits = new int[]{60, 100, 120};

        System.out.println(knapsack.getMaxProfit(wts, profits, 50));
    }
}
