package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationWithSpaces {

    public static void main(String... args) {
        String str = "abc";
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        temp.append(str.charAt(0));
        recursion(1, str, temp, result);
        System.out.println(result);
        System.out.println("After sorting");
        result.sort((a,b)-> a.length() - b.length());
        System.out.println(result);
    }

    public static void recursion(int index, String string, StringBuilder temp, List<String> result) {
        if (index == string.length()) {
            result.add(temp.toString());
            return;
        }


        recursion(index + 1, string, temp.append(string.charAt(index)), result);
        temp.deleteCharAt(temp.length() - 1);

        temp.append('_');
        temp.append(string.charAt(index));

        recursion(index + 1, string, temp, result);
        temp.deleteCharAt(temp.length() - 1); // for removing last character
        temp.deleteCharAt(temp.length() - 1); // for removing space character
    }
}
