package subsets;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args){
        System.out.println(getParenthesis(4));
    }

  public static List<String> getParenthesis(int n){
      List<String> list = new ArrayList<>();
     int x = recursion(0, 0, 0, n, n *2, new StringBuilder(), list);

     System.out.println("no of parenthesis generated are "+ x);

     return list;
    }

    public static int recursion(int index, int opens, int closes, int n, int strLen, StringBuilder temp, List<String> list) {
        if (index == strLen){
            list.add(temp.toString());
            return 1;
        }

        int ans = 0;

        if (opens == n){
            while (closes < n){
                ans += recursion(index+1, opens, closes+1, n, strLen, temp.append(')'), list);
                temp.deleteCharAt(temp.length()-1);
            }
        }

        if (opens < n && closes < n){
            if (opens == closes) {
                ans += recursion(index+1, opens+1, closes,n, strLen, temp.append('('), list);
                temp.deleteCharAt(temp.length()-1);
            }

            if (opens > closes) {
                ans += recursion(index+1, opens, closes+1, n, strLen, temp.append(')'), list);
                temp.deleteCharAt(temp.length()-1);
                ans += recursion(index+1, opens+1, closes,n, strLen, temp.append('('), list);
                temp.deleteCharAt(temp.length()-1);
            }
        }

        return ans;
    }
}
