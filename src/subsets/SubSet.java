package subsets;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String[] args){
        int[] arr = new int[]{2,5,7};

        System.out.println(List.of(findAllSubsets(arr)));
    }

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
