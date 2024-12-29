package sliding_window;

import java.util.Arrays;

public class Defuse_the_Bomb_1652 {

    public static void main(String... args) {
        int[] code = {5, 7, 1, 4};
        int k = 3;

        System.out.println(Arrays.toString(decryptOptimised(code, k)));
    }

    private static int[] decryptOptimised(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        int i = -1;
        int j = -1;

        if (k > 0) {
            i = 1;
            j = k;
        } else {
            i = n - Math.abs(k);
            j = n - 1;
        }

        int sum = 0;

        for (int pointer = i; pointer <= j; pointer++) {
            sum += code[pointer];
        }

        for (int m = 0; m < n; m++) {
            result[m] = sum;

            sum -= code[i % n];
            i++;

            sum += code[(j + 1) % n];
            j++;
        }

        return result;

    }

    //Time complexity is O(N*K)
    private static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (k < 0) {
                int absValue = Math.abs(k);
                for (int j = i - absValue; j < i; j++) {
                    result[i] += code[(j + n) % n];
                }
            } else {
                for (int j = i + 1; j <= i + k; j++) {
                    result[i] += code[(j) % n];
                }
            }
        }

        return result;

    }
}
