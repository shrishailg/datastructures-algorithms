package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> res = new ArrayList<>();
        recursion(arr, 0, res);

        System.out.println("count is "+ res.size());

        System.out.println(res);
    }


    public static void recursion(int[] arr, int currentIndex, List<List<Integer>> result){
        if (currentIndex == arr.length){
            result.add(convertArrayToList(arr));
            return;
        }

        for (int i = currentIndex; i < arr.length; i++){
             swap(arr, currentIndex, i);
             recursion(arr, currentIndex + 1, result);
//             swap(arr, currentIndex, i);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to convert array to list
    static List<Integer> convertArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
}
