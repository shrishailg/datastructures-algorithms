package subsets;

import java.util.*;

public class PermutationsNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(permutations(arr));
    }

    public static List<List<Integer>> permutations(int[] arr) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutationsRec(arr, 0, permutations);
        return permutations;
    }

    public static void permutationsRec(int[] arr, int currentIndex, List<List<Integer>> permutations){
        if (currentIndex == arr.length){
           permutations.add(convertArrayToList(arr));
           return;
        }

        for (int index = currentIndex; index < arr.length; index++){
             //Swapping

             swap(arr, currentIndex, index);

            // Recursive call to create permutations
            // for the next element
             permutationsRec(arr, currentIndex + 1, permutations);

            swap(arr, currentIndex, index);
        }
    }

    // Helper method to convert array to list
    static List<Integer> convertArrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
