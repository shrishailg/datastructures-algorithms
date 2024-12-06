package dynamic_programming.subset_sum;

public class SubsetSumTest {

    public static void main(String[] args){
        SubsetSum subsetSum = new SubsetSum();
        SubsetSumBottomUp subsetSumBottomUp = new SubsetSumBottomUp();
        SubsetSumTopUp subsetSumTopUp = new SubsetSumTopUp();

        int[] sets = new int[]{3, 34, 4, 12, 5, 2};

        System.out.println(subsetSum.isSubSetSum(sets, 10, sets.length));

        System.out.println(subsetSumBottomUp.isSubsetSum(sets, sets.length,  10));

        System.out.println(subsetSumTopUp.isSubsetSum(sets, sets.length,  10));
    }
}
