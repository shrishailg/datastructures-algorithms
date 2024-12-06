package two_heaps.top_k_frequent_element;

import java.util.*;

public class TopFrequentElement {

    public List<Integer> topKFrequent(int[] arr, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();

        for (var value : arr) {
            freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return freqMap.get(o1).compareTo(freqMap.get(o2));
            }
        });

        ArrayList<Integer> result= new ArrayList<>();

        for (var entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry.getKey());
            }
            else if (minHeap.size() >= k && entry.getValue() > freqMap.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.add(entry.getKey());
            }
        }

        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }

        return result;
    }
}
