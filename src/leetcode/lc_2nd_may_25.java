package leetcode;

import java.util.Arrays;

public class lc_2nd_may_25 {

    public static void main(String[] args) {
        String dominoes = "RR.L";

        System.out.println(pushDominoes(dominoes));
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();

        int[] leftClosestR = new int[n];
        int[] rightClosestL = new int[n];
        StringBuilder result = new StringBuilder();

        //Move from left to right to find leftClosestR
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                leftClosestR[i] = i;
            } else if (dominoes.charAt(i) == '.') {
                leftClosestR[i] = i > 0 ? leftClosestR[i - 1] : -1;
            } else {
                leftClosestR[i] = -1;
            }
        }

        System.out.println(Arrays.toString(leftClosestR));

        //Move from right to left to find rightClosestL
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                rightClosestL[i] = i;
            } else if (dominoes.charAt(i) == '.') {
                rightClosestL[i] = i < n - 1 ? rightClosestL[i + 1] : -1;
            } else {
                rightClosestL[i] = -1;
            }
        }

        System.out.println(Arrays.toString(rightClosestL));

        for (int i = 0; i < n; i++) {
            if (leftClosestR[i] == rightClosestL[i]) {
                result.append('.');
            } else if (leftClosestR[i] == -1) {
                result.append('L');
            } else if (rightClosestL[i] == -1) {
                result.append('R');
            } else {
                int distR = Math.abs(i - leftClosestR[i]);
                int distL = Math.abs(i - rightClosestL[i]);

                if (distR == distL) {
                    result.append('.');
                } else {
                    if (distR < distL) {
                        result.append('R');
                    } else {
                        result.append('L');
                    }
                }
            }
        }

        return result.toString();

    }
}
