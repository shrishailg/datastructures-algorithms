package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int maxSize = m * n;
        int[] arr = new int[maxSize];
        int k=0;
        for (int[] ints : board) {
            for (int j = 0; j < n; j++) {
                arr[k++] = ints[j];
            }
        }

        boolean[] visited = new boolean[maxSize];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-->0) {
                int poppedValue= queue.poll();

                if(poppedValue == maxSize-1) {
                    return level;
                }

                for(int dice=1;dice<=6;dice++) {
                    int nextValue = dice + poppedValue;

                    if(nextValue >= maxSize) {
                        continue;
                    }

                    if(visited[nextValue]) {
                        continue;
                    }

                    if(arr[nextValue] == -1) {
                        visited[nextValue] = true;
                        queue.add(nextValue);
                    } else {
                        visited[nextValue] = true;
                        queue.add(arr[nextValue]);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
