package leetcode;

public class lc_3rd_may_25 {

    public static void main(String... args) {
       int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        System.out.println(minDominoRotations(tops, bottoms));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int steps = find(tops, bottoms, i);
            if (steps != -1) {
                result = Math.min(steps, result);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static int find(int[] tops, int[] bottoms, int value) {
        int topSwap = 0;
        int bottomSwap = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != value && bottoms[i] != value) {
                return -1;
            } else if (tops[i] != value) {
                topSwap++;
            } else if (bottoms[i] != value) {
                bottomSwap++;
            }
        }

        return Math.min(topSwap, bottomSwap);
    }
}
