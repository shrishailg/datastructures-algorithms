package dynamic_programming.subset_sum;


public class SubsetSum {

    public boolean isSubSetSum(int[] set, int sum, int n){
        if (sum == 0) {
            return true;
        }

        if( n == 0) {
            return false;
        }

        if (set[n-1] > sum)
            return isSubSetSum(set, sum, n-1);

        return isSubSetSum(set, sum, n-1) || isSubSetSum(set, sum - set[n-1], n-1);
    }
}
