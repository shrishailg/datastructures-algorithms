package dynamic_programming.knapsack_variation.min_subset_sum_difference;

public class MinSubsetSumDiff {

    public static void main(String[] args) {
        int[] arr = {1,2,7};

        System.out.println(MinSubsetSumDiffRecursion(arr));
        System.out.println(MinSubsetSumDiff(arr));
    }

    public static int MinSubsetSumDiff(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for(var num:arr) {
            sum+=num;
        }

        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0;i<=n;i++) {
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=sum;j++) {
               if (arr[i-1]>j) {
                   dp[i][j] = dp[i-1][j];
               } else {
                   dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
               }
            }
        }

        int range = sum / 2;

        int[] result = new int[range];
        int k = 0;
        for(int i=0;i<range;i++) {
            if (dp[n-1][i]) {
                result[k++] = i;
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int i=0;i<result.length;i++) {
            mini = Math.min(mini, sum-(2*result[i]));
        }

        return mini;
    }


    static int mini = Integer.MAX_VALUE;

    public static int MinSubsetSumDiffRecursion(int[] arr) {
        int sum = 0;

        for(var num:arr) {
            sum += num;
        }

        int range = sum/2;
        recursion(arr, arr.length, sum, range, sum);

        return mini;
    }

    //this is correct
   static void recursion(int[] arr, int index, int sum, int range, int totalSum) {
       if (sum <= range) {
           mini = Math.min(mini, totalSum - (2 * sum));
           return;
       }

       if (index <= 0) {
           return;
       }

       if (arr[index - 1] > sum) {
           recursion(arr, index - 1, sum, range, totalSum);
       }

       recursion(arr, index - 1, sum, range, totalSum);
       recursion(arr, index - 1, sum - arr[index - 1], range, totalSum);
   }
}
