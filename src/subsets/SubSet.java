package subsets;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String[] args){
        int[] arr = new int[]{2,5,7};

        System.out.println(List.of(findAllSubsets(arr)));

        List<List<Integer>> result = new ArrayList<>();

        recursion(arr, 0, new ArrayList<>(),result);
        System.out.println(result);
    }

    //recursive solution
    public static void recursion(int[] arr, int index, List<Integer> temp, List<List<Integer>> result) {
        if (index == arr.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        //not include
        recursion(arr, index+1, temp, result);

        //include
        temp.add(arr[index]);
        recursion(arr, index+1, temp, result);
        temp.remove(temp.size()-1); //for backtracking
    }

    //Iterative solution
    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();

        setsList.add(new ArrayList<>());

        for(int num:nums){
            int n = setsList.size();
            for(int i=0;i<n;i++){
                List<Integer> set = new ArrayList<>(setsList.get(i));
                set.add(num);
                setsList.add(set);
            }
        }

        return setsList;
    }
}
