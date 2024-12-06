package arrays;

import java.util.ArrayList;
import java.util.List;

public class Duplicate_Numbers {

    public static void main(String[] args) {
        int n = 7;
        int[] array = {1, 2, 3, 1, 3, 6, 6};

        System.out.println(findDuplicates(array, n));
    }


    private static List<Integer> findDuplicates(int[] arr, int n) {
        int[] freq = new int[n];

        for(int i=0;i<n;i++) {
            freq[arr[i]]++;
        }

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if (freq[i]>1){
                result.add(i);
            }
        }

        return result;
    }
}
