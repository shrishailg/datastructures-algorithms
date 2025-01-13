import java.util.*;

public class SplitWise {

    static List<List<Integer>> settlements = new ArrayList<>();
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    public static void main(String[] args) {
        // graph[i][j] indicates the amount
        // that person i needs to pay person j
        int graph[][] = { {0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0},};

        // Print the solution
        minCacheFlow(graph);

        System.out.println(settlements);
    }


    static void minCacheFlow(int[][] cash) {
        int n = cash.length;

        int[] transactions = new int[n];

        for(int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                transactions[i] = transactions[i] - cash[i][j] + cash[j][i];
            }
        }

        minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> transactions[a]));
        maxHeap = new PriorityQueue<>((a,b)-> transactions[b]-transactions[a]);

        for (int i=0;i<n;i++) {
            if (transactions[i] == 0){
                continue;
            } else if (transactions[i]>0) {
                maxHeap.add(i);
            } else if (transactions[i]<0) {
                minHeap.add(i);
            }
        }

        minCacheFlowOptimised(transactions);
    }

    static void minCacheFlowOptimised(int[] transactions) {

        while (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            int maxCreditIndex = maxHeap.poll();
            int maxDebitIndex = minHeap.poll();

            if (transactions[maxCreditIndex] == 0 && transactions[maxDebitIndex] == 0) {
                return;
            }

            int minTransaction = Math.min(Math.abs(transactions[maxDebitIndex]),transactions[maxCreditIndex]);

            transactions[maxDebitIndex] += minTransaction;
            transactions[maxCreditIndex] -= minTransaction;

            System.out.println("Person "+ maxDebitIndex + " pays " + minTransaction + " to " + maxCreditIndex);

            if (transactions[maxDebitIndex] != 0) {
                minHeap.add(maxDebitIndex);
            } else {
                maxHeap.add(maxCreditIndex);
            }



            //adding into settlements
            List<Integer> list = new ArrayList<>();
            list.add(maxDebitIndex);
            list.add(maxCreditIndex);
            list.add(minTransaction);
            settlements.add(list);
        }
    }

    static void minCacheFlowRecursion(int[] transactions) {

        int maxCreditIndex = getMaxCreditAmount(transactions);
        int maxDebitIndex = getMaxDebitAmount(transactions);

        if (transactions[maxCreditIndex] == 0 && transactions[maxDebitIndex] == 0) {
            return;
        }

        int minTransaction = Math.min(Math.abs(transactions[maxDebitIndex]),transactions[maxCreditIndex]);

        transactions[maxDebitIndex] += minTransaction;
        transactions[maxCreditIndex] -= minTransaction;

        System.out.println("Person "+ maxDebitIndex + " pays " + minTransaction + " to " + maxCreditIndex);
        List<Integer> list = new ArrayList<>();
        list.add(maxDebitIndex);
        list.add(maxCreditIndex);
        settlements.add(list);

        minCacheFlowRecursion(transactions);
    }

    static int getMaxCreditAmount(int[] transactions) {
        int index = 0;
        int maxValue = transactions[0];

        for (int i=1;i<transactions.length;i++) {
            if (maxValue<transactions[i]) {
                index = i;
            }
        }
        return index;
    }

    static int getMaxDebitAmount(int[] transactions) {
        int index = 0;
        int minValue = transactions[0];

        for (int i=1;i<transactions.length;i++) {
            if (minValue>transactions[i]) {
                index = i;
            }
        }
        return index;
    }
}
