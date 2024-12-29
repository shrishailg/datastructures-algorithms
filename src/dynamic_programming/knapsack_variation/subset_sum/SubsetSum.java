package dynamic_programming.knapsack_variation.subset_sum;


public class SubsetSum {

    public boolean isSubSetSum(int[] arr, int sum, int n){
        if (sum == 0) {
            return true;
        }

        if( n == 0) {
            return false;
        }

        if (arr[n-1] > sum)
            return isSubSetSum(arr, sum, n-1);

        return isSubSetSum(arr, sum, n-1) || isSubSetSum(arr, sum - arr[n-1], n-1);
    }
}
