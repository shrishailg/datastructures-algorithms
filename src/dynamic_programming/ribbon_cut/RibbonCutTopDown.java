package dynamic_programming.ribbon_cut;

public class RibbonCutTopDown {

    public int countRibbons(int[] arr, int n, int totalLength){
        int[][] dp = new int[n+1][totalLength+1];

        for (int i = 0; i<=n;i++){
            for (int j = 0; j <= totalLength; j++){
                dp[i][j] = -1;
            }
        }

        return countRibbonsRec(arr, n, totalLength, dp);
    }

    private int countRibbonsRec(int[] arr, int n, int totalLength, int[][] dp){
        if (n == 0 || totalLength == 0)
            return 0;
        if (dp[n][totalLength] != -1)
            return dp[n][totalLength];
        if (arr[n-1] > totalLength)
            return dp[n][totalLength] = countRibbonsRec(arr, n-1, totalLength, dp);
        return dp[n][totalLength] = Math.max(countRibbonsRec(arr, n-1, totalLength, dp), 1+ countRibbonsRec(arr, n, totalLength - arr[n-1], dp));
    }
}
