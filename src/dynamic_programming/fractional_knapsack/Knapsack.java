package dynamic_programming.fractional_knapsack;

import java.util.Arrays;

public class Knapsack {

    public double getMaxProfit(int[] weights, int[] profits, int capacity){
        int len = weights.length;
        Item[] items = new Item[len];

        for (int i = 0; i < len; i++){
            items[i] = new Item(weights[i], profits[i]);
        }

        Arrays.sort(items, (o1, o2) -> {
            Double d1 = o1.getCost();
            Double d2 = o2.getCost();
            return d2.compareTo(d1);
        });

        return getMaxValue(items, capacity);
    }

    private double getMaxValue(Item[] items, int capacity){
        double totalValue = 0d;
        for(Item item : items){
            int curr_weight = item.getWeight();
            int curr_profit = item.getProfit();

            if (capacity - curr_weight >= 0){
                totalValue = totalValue + curr_profit;
                capacity = capacity - curr_weight;
            } else {
                double fraction = (double) capacity/curr_weight;
                totalValue = totalValue + (curr_profit * fraction);
//                capacity = (int) (capacity - (fraction * curr_weight));
                break;
            }
        }

        return totalValue;
    }
}
