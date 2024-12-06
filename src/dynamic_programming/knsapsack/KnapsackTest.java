package dynamic_programming.knsapsack;

public class KnapsackTest {

    public static void main(String... args){
        Knapsack knapsack = new Knapsack();
        KnapsackTopDown knapsackTopDown = new KnapsackTopDown();
        KnapsackBottomUp knapsackBottomUp = new KnapsackBottomUp();

        int[] wts = new int[]{1, 2, 3};
        int[] profits = new int[]{10, 20, 30};
        int totalWeight = 2;

        System.out.println(knapsack.getMaxProfit(wts, profits, totalWeight, 3));

        System.out.print("Answer form TOP-DOWN Approach is : ");
        System.out.println(knapsackTopDown.getMaxProfit(wts, profits, totalWeight, 3));

        System.out.print("Answer form BOTTOM-UP Approach is : ");
        System.out.println(knapsackBottomUp.getMaxProfit(wts, profits, totalWeight, 3));
    }
}
