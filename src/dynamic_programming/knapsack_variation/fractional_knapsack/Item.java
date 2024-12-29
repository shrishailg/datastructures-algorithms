package dynamic_programming.knapsack_variation.fractional_knapsack;

public class Item {
    private final int weight;
    private final int profit;
    private final Double cost;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
        this.cost = (double) (weight/profit);
    }

    public int getWeight() {
        return weight;
    }

    public int getProfit(){
        return profit;
    }

    public double getCost(){
        return cost;
    }
}
