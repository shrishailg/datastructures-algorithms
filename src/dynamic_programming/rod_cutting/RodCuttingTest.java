package dynamic_programming.rod_cutting;

public class RodCuttingTest {

    public static void main(String... args) {
        RodCutting rodCutting = new RodCutting();
        RodCuttingTopDown rodCuttingTopDown = new RodCuttingTopDown();
        RodCuttingBottomUp rodCuttingBottomUp = new RodCuttingBottomUp();

        int[] lengths = {1, 2, 3, 4, 5};
        int[] profits = {2, 6, 7, 10, 13};
        int totalLength = 7;

        System.out.println(rodCutting.geMaxProfit(lengths, profits, totalLength));
        System.out.println(rodCuttingTopDown.geMaxProfit(lengths, profits, totalLength));
        System.out.println(rodCuttingBottomUp.geMaxProfit(lengths, profits, totalLength));
    }
}
