package arrays;

import java.util.HashSet;
import java.util.Set;

public class SumPair {

    public boolean isSubsetSumNaive(int[] subset, int n, int sum){
       for (int i = 0; i <n; i++){
           for (int j = i+1; j <n; j++){
               if (subset[i]+subset[j] == sum){
                   return true;
               }
           }
       }

       return false;
    }

    public boolean isSubsetSumOptimized(int[] subset, int n, int sum){
        Set<Integer> secondarySubset = new HashSet<>();

        for (int i = 0; i <n; i++){
            int target = sum - subset[i];

            if (secondarySubset.contains(target)){
                return true;
            }

            secondarySubset.add(target);
        }

        return false;
    }
}
