package dynamic_programming.matrix_multiplication;

/*
Given a boolean expression s with the following symbols and operators filled between symbols.
The task is to count the number of ways we can parenthesize the expression so that the value of the expression evaluates to true.

Input: s = T|T&F^T
Output: 4
Explanation: The expression evaluates to true in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EvaluateBooleanExpression {

    public static void main(String[] args) {
        String s = "T|T&F^T";

       System.out.println(evaluateExpression(s));
       System.out.println(evaluateExpressionMemo(s));

       String s1 = "T^F|F";

       System.out.println(evaluateExpression(s1));
       System.out.println(evaluateExpressionMemo(s1));
    }

    public static int evaluateExpression(String s) {
        int i= 0;
        int j = s.length()-1;

        return recursion(s, i, j, true);
    }

    private static int recursion(String s, int i, int j, boolean flag) {
        if (i>j) {
            return 0;
        }

        if (i==j) {
            if (flag && s.charAt(i) == 'T') {
                return 1;
            } else if(!flag && s.charAt(i) == 'F') {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;

        //always k has to iterate on operator so k+2
        for(int k=i+1;k<=j-1;k=k+2) {
            int lt = recursion(s, i,k-1, true);
            int lf = recursion(s, i,k-1, false);
            int rt = recursion(s, k+1,j, true);
            int rf = recursion(s, k+1,j, false);

            if (s.charAt(k) == '&') {
                if (flag) {
                    ans = ans + lt * rt;
                } else {
                    ans = ans + lt * rf + lf * rt + lf * rf;
                }
            } else if (s.charAt(k) == '|') {
                if (flag) {
                    ans = ans + lt * rt + lt * rf + lf * rt ;
                } else {
                    ans = ans + lf * rf;
                }
            } else {
                if (flag) {
                    ans = ans + lt * rf + lf * rt;
                } else {
                    ans = ans + lt * rt + lf * rf;
                }
            }
        }

        return ans;
    }

    public static int evaluateExpressionMemo(String s) {
        int i= 0;
        int j = s.length()-1;

//        int[][] dp = new int[s.length()+1][s.length()+1];
//
//        for (var row:dp) {
//            Arrays.fill(row, -1);
//        }

        Map<String, Integer> map = new HashMap<>();

        return recursionMemo(s, i, j, true, map);
    }

    private static int recursionMemo(String s, int i, int j, boolean flag, Map<String, Integer> map) {
        if (i>j) {
            return 0;
        }

        String key = i + String.valueOf(j) + flag;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (i==j) {
            if (flag && s.charAt(i) == 'T') {
                 key = i + String.valueOf(j) + flag;
                map.put(key, 1);
                return  1;
            } else if(!flag && s.charAt(i) == 'F') {
                key = i + String.valueOf(j) + flag;
                map.put(key, 1);
                return  1;
            } else {
                key = i + String.valueOf(j) + flag;
                map.put(key, 0);
                return 0;
            }
        }

        int ans = 0;

        //always k has to iterate on operator so k+2
        for(int k=i+1;k<=j-1;k=k+2) {
            int lt = recursion(s, i,k-1, true);
            int lf = recursion(s, i,k-1, false);
            int rt = recursion(s, k+1,j, true);
            int rf = recursion(s, k+1,j, false);

            if (s.charAt(k) == '&') {
                if (flag) {
                    ans = ans + lt * rt;
                } else {
                    ans = ans + lt * rf + lf * rt + lf * rf;
                }
            } else if (s.charAt(k) == '|') {
                if (flag) {
                    ans = ans + lt * rt + lt * rf + lf * rt ;
                } else {
                    ans = ans + lf * rf;
                }
            } else {
                if (flag) {
                    ans = ans + lt * rf + lf * rt;
                } else {
                    ans = ans + lt * rt + lf * rf;
                }
            }
        }

        key = i + String.valueOf(j) + flag;
        map.put(key, ans);

        return ans;
    }
}
