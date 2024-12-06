package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDigitCombination {

    // Driver code
    public static void main(String[] args)
    {
        int[] number = { 2};

        List<String> result = possibleWords(number , number.length);

        System.out.println(result);
    }

    public static List<String> possibleWords(int[] arr, int n) {
        List<String> result = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        StringBuilder stringBuilder = new StringBuilder();
        recursion(arr, 0, n, stringBuilder, map, result);

        return result;
    }

    public static void recursion(int[] arr, int index, int n, StringBuilder path, Map<Integer,String> map, List<String> result){
        if (index == n) {
            result.add(path.toString());
            return;
        }

        String str = map.get(arr[index]);
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            recursion(arr, index +1, n, path, map, result);
            path.deleteCharAt(path.length()-1); // very important
        }
    }
}
