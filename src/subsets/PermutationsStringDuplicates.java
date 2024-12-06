package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsStringDuplicates {
    public static void main(String[] args) {
        String str = "abca";

        //sort string
        char[] strChars = str.toCharArray();
        Arrays.sort(strChars);

        System.out.println(permutations(new String(strChars)));
    }

    public static List<String> permutations(String str){
        List<String> result = new ArrayList<>();
        permutationsRec(str, 0 , result);
        return result;
    }

    public static void permutationsRec(String str, int currentIndex, List<String> result){
        if (currentIndex == str.length()-1){
            result.add(str);
            return;
        }

        for (int index = currentIndex; index < str.length(); index++){
            if (index > currentIndex && str.charAt(index) == str.charAt(currentIndex))
                continue;
            String swappedStr = swap(str, currentIndex, index);
            permutationsRec(swappedStr, currentIndex + 1, result);
        }
    }

    public static String swap(String str, int i, int j){
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return new String(chars);
    }
}
