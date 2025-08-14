package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TrippletSumToZero {

    public List<List<Integer>> searchTripplets(int[] arr) {
        if (Objects.isNull(arr) || arr.length <= 0)
            throw new IllegalArgumentException("Invalid input");

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<arr.length-2;i++) {
            if (i> 0 && arr[i] == arr[i-1])
                continue;

            searchPairs(arr, -arr[i], i+1, arr.length-1, result);
        }

        return result;
    }

    private void searchPairs(int[] arr, int targetSum, int left, int right,  List<List<Integer>> result) {
        while (left<right) {
            int sum = arr[left] + arr[right];

            if (sum == targetSum) {
                result.add(Arrays.asList(arr[left], arr[right], -targetSum));

                while (left<right && arr[left] == arr[left-1]){
                    left++;
                }

                while (left<right && arr[right] == arr[right-1]) {
                    right--;
                }
            } else if(sum > targetSum) {
                left++;
            } else {
                right--;
            }
        }
    }
}
