package two_heaps.max_capital;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {

    public int maximizeCapital(int[] capitals, int[] profits, int maxProjects, int initialCapital) {
        int n = capitals.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n, (a, b) -> capitals[a] - capitals[b]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < n; i++) {
            minHeap.add(i);
        }

        int availableCapital = initialCapital;
        for (int i = 0; i < maxProjects; i++) {

            while (!minHeap.isEmpty() && capitals[minHeap.peek()] <= availableCapital){
                maxHeap.add(minHeap.poll());
            }

            if (!maxHeap.isEmpty()) {
                availableCapital = availableCapital + profits[maxHeap.poll()];
            }

        }

        return availableCapital;
    }
}
