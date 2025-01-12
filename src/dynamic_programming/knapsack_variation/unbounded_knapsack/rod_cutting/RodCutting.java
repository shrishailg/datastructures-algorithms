package dynamic_programming.knapsack_variation.unbounded_knapsack.rod_cutting;

public class RodCutting {

    public int geMaxProfit(int[] lengths, int[] profits, int totalLength) {
        int n = lengths.length;

        if (n == 0 || totalLength == 0 || profits.length == 0)
            return 0;

        return recursion(lengths, profits, totalLength, n);
    }

   private int recursion(int[] lengths, int[] profits, int totalLength, int n) {
        if (totalLength == 0 || n <= 0)
            return 0;

        if (totalLength < lengths[n-1])
            return recursion(lengths, profits, totalLength, n-1);

        return Math.max(recursion(lengths, profits, totalLength, n-1),
                profits[n-1] + recursion(lengths, profits, totalLength-lengths[n-1], n-1));
    }
}
