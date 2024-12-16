package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc_16th_dec24 {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] i1, int[] i2) {
                    if(i1[1] == i2[1]) {
                        return i1[1]-i2[1];
                    }

                    return i1[0]-i2[0];
                }
            });
            for(int i=0;i<nums.length;i++) {
                minHeap.add(new int[]{nums[i],i});
            }

            while(k-->0) {
                int[] numIndex = minHeap.poll();
                int num = numIndex[0] * multiplier;
                int index = numIndex[1];
                minHeap.add(new int[]{num, index});
            }

            while(!minHeap.isEmpty()) {
                int[] numIndex = minHeap.poll();
                int num = numIndex[0];
                int index = numIndex[1];
                nums[index] = num;
            }

            return nums;
        }
}
