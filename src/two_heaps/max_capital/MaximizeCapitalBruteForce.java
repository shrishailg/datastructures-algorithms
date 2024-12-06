package two_heaps.max_capital;

public class MaximizeCapitalBruteForce {

    // O(N*K)
    public int maximizeCapital(int[] capitals, int[] profits, int maxProjects, int initialCapital) {
        int maxCapital = 0;
        int start = 0;
        for (int end = 0; end < capitals.length; end++) {
            if (end - start + 1 >= maxProjects) {
                int currentCapital = initialCapital;
                while (start < end) {
                    if (currentCapital >= capitals[start]) {
                        currentCapital += profits[start];
                    }
                    start++;
                }

                if (currentCapital >= capitals[end]) {
                    currentCapital += profits[end];
                }
                maxCapital = Math.max(maxCapital, currentCapital);
            }
        }

        return maxCapital;
    }
}
