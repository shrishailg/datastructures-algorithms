package dynamic_programming.knapsack_variation.knsapsack;

public class Knapsack {

    public int getMaxProfit(int[] weights, int[] values, int totalWeight, int n) {
        if (n == 0 || totalWeight == 0) {
            return 0;
        } else if (weights[n - 1] > totalWeight) {
            return getMaxProfit(weights, values, totalWeight, n - 1);
        } else
            return Math.max(values[n - 1] + getMaxProfit(weights, values, totalWeight - weights[n - 1], n - 1),
                    getMaxProfit(weights, values, totalWeight, n - 1));
    }
}
