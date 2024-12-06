package merge_intervals.tasks_min_machines;

import java.util.*;

public class MinMachines {

    public  int getMinMachines(List<List<Integer>> tasksList) {
        tasksList.sort(Comparator.comparingInt(a -> a.get(0)));
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(tasksList.size(), Comparator.comparingInt(a -> a.get(1)));
        int count = 0;

        for (List<Integer> task: tasksList){
            // removes machines for completed tasks
            while (!minHeap.isEmpty() && task.get(0) >= minHeap.peek().get(1)){
                minHeap.poll();
            }
            minHeap.add(task);
            count = Math.max(count, minHeap.size());
        }

        return count;
    }
}
