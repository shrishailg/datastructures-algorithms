package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {

    public static void main(String... args){
        System.out.println(partitionString("aab"));
    }

    public static List<List<String>> partitionString(String string) {
        List<List<String>> result = new ArrayList<>();
        recursion(string, new ArrayList<>(), result);
        return result;
    }

    private static void recursion(String string, List<String> temp, List<List<String>> result) {
        if (string.isEmpty()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            String check = string.substring(0, i+1);

            if (isPalindrome(check)){
                temp.add(check);
                recursion(string.substring(i+1), temp, result);
                temp.remove(check);
            }
        }
    }

    private static String convertArrayToString(List<Character>  arr){
        StringBuilder stringBuilder = new StringBuilder();
        arr.forEach(stringBuilder::append);

        return String.valueOf(stringBuilder);
    }

    private static boolean isPalindrome(String string) {
        int low = 0, high = string.length() - 1;

        while(low<=high){
            if (string.charAt(low) != string.charAt(high))
                return false;
            low++;
            high --;
        }

        return true;
    }
}
