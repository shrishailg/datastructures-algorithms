package bitmanipulation;

public class MinFlips {


    public int getMinFlips(int a, int b, int c) {
        int flips = 0;

        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    flips++;
                }
            } else {
                if ((a & 1) == 1) {
                    flips++;
                }

                if ((b & 1) == 1) {
                    flips++;
                }
            }
        }

        return flips;
    }

    public int getMinFlipsOptimised(int a, int b, int c) {
        int d = (a|b)^c;
        int f = (a&b)^c;

        return Integer.bitCount(d) + Integer.bitCount(f);
    }
}
