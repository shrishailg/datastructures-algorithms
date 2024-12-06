package matrix;

import java.util.*;

public class Sliding_Puzzle_773 {

    public static void main(String[] args) {
        int[][] board = {{4,1,2},{5,0,3}};

        System.out.println(slidingPuzzle(board));
    }

    public static int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }

        String target = "123450";

        if (start.toString().equals(target)) {
            return 0;
        }

        List<String> visited = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        map.put(0, Arrays.asList(1, 3));

        map.put(1, Arrays.asList(0, 2, 4));

        map.put(2, Arrays.asList(1, 5));

        map.put(3, Arrays.asList(0, 4));

        map.put(4, Arrays.asList(1, 3, 5));

        map.put(5, Arrays.asList(2, 4));

        Queue<String> queue = new LinkedList<>();

        int level = 0;
        queue.add(start.toString());
        visited.add(start.toString());

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return level;
                }

                int zeroIndex = current.indexOf('0');
                for (var index : map.get(zeroIndex)) {
                    String str = swap(current, zeroIndex, index);

                    if (!visited.contains(str)) {
                        queue.add(str);
                        visited.add(str);
                    }
                }

                size--;
            }

            level++;
        }

        return -1;
    }

    private static String swap(String str, int x, int y) {
        char[] array = str.toCharArray();
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;

        return String.valueOf(array);
    }
}
