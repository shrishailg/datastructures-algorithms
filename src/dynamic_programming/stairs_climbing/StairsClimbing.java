package dynamic_programming.stairs_climbing;

public class StairsClimbing {

    public static void main(String[] args) {
        System.out.println(countWays(3));
    }

    //allowed 1 or 2 or 3
    public static int countWays(int n) {
        if (n == 0) return 1;
        else if (n < 0) return 0;
        else return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }
}
