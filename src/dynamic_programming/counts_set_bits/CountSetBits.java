package dynamic_programming.counts_set_bits;

public class CountSetBits {


    public static void main(String[] args) {
        System.out.println(getSetBitsRecursion(20));
        System.out.println(1 << 3);
    }

    public static int getSetBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i=1;i<=n;i++){
            int x = (int) (Math.log(i) / Math.log(2));
            int y = (int) Math.pow(2, x);
            dp[i] = 1 + dp[i-y];
        }

        return dp[n];
    }

    public static int getSetBitsRecursion(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 1;
        if (n==3) return 2;

        int x = (int) (Math.log(n) / Math.log(2));
        int y = (int) Math.pow(2, x);
        return  1 + getSetBitsRecursion(n-y);
    }
}
