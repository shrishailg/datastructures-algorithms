package two_heaps.klargest_elements;

import intervals.MergeIntervals;

import java.util.PriorityQueue;

public class KthLargestElement {


    // 1,2,3,4 k=2
    public int findKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(var value: arr) {
            if (minHeap.size()<k) {
                minHeap.add(value);
            } else if (value > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(value);
            }
        }

        while (k>1) {
            minHeap.poll();
            k--;
        }

        return minHeap.poll();
    }
}
