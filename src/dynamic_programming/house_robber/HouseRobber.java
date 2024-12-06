package dynamic_programming.house_robber;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String... args){
        int[] hVal = {6, 7, 1, 3, 8, 2, 4};
        int[] hVal1 = {5, 3, 4, 11, 2};
        System.out.println("RECURSION APPROACH");
        System.out.println(getMaxStolenValue(hVal));
        System.out.println(getMaxStolenValue(hVal1));

        System.out.println("TOP-DOWN APPROACH");
        System.out.println(getMaxStolenValueTopDown(hVal));
        System.out.println(getMaxStolenValueTopDown(hVal1));

        System.out.println("BOTTOM-UP APPROACH");
        System.out.println(getMaxStolenValueBottomUp(hVal));
        System.out.println(getMaxStolenValueBottomUp(hVal1));

    }


    public static int getMaxStolenValue(int[] hVal) {
        int n = hVal.length;

        return recursion(hVal, n);
    }

    public static int recursion(int[] haVal, int n) {
        if (n<=0)
            return 0;

        int sum1 = haVal[n-1] + recursion(haVal, n-2);
        int sum2 = recursion(haVal, n-1);

        return Math.max(sum1, sum2);
    }

    public static int getMaxStolenValueTopDown(int[] hVal) {
        int n = hVal.length;

        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        return recursionTopDown(hVal, n, dp);
    }

    public static int recursionTopDown(int[] haVal, int n, int[] dp) {
        if (n<=0)
            return dp[n] = 0;

        if (dp[n] != -1)
            return dp[n];

        int sum1 = haVal[n-1] + recursion(haVal, n-2);
        int sum2 = recursion(haVal, n-1);

        return dp[n] = Math.max(sum1, sum2);
    }

    public static int getMaxStolenValueBottomUp(int[] hVal) {
        int n = hVal.length;

        int[] dp= new int[n+1];
        dp[0] = 0;
        dp[1] = hVal[0];

        for (int i=2;i<=n;i++){
            dp[i] = Math.max(dp[i-1], hVal[i-1] + dp[i-2]);
        }

        return dp[n];
    }
}
