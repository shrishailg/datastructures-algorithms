package dynamic_programming.weighted_stairs_climbing;

public class CountMinWeight {

    public static void main(String... args) {
        int[] cost = {2, 5, 3, 1, 7, 3, 4};
        System.out.println(countMinWeight(cost, cost.length - 2));
    }

    public static int countMinWeight(int[] cost, int n) {
        if (n == 0) return cost[0];
        else if (n == 1) return cost[1];
        else return Math.min(countMinWeight(cost, n - 1) + cost[n], cost[n] + countMinWeight(cost, n - 2));
    }
}
