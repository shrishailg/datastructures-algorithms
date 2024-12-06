package strings;

/*
You are given two 0-indexed strings str1 and str2.

In an operation, you select a set of indices in str1, and for each index i in the set,
increment str1[i] to the next character cyclically. That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.

Return true if it is possible to make str2 a subsequence of str1 by performing the operation at most once, and false otherwise.

Note: A subsequence of a string is a new string that is formed from the original string by deleting
some (possibly none) of the characters without disturbing the relative positions of the remaining characters.
Input: str1 = "abc", str2 = "ad"
Output: true
Explanation: Select index 2 in str1.
Increment str1[2] to become 'd'.
Hence, str1 becomes "abd" and str2 is now a subsequence. Therefore, true is returned.
 */

public class Make_String_a_Subsequence_Using_Cyclic_Increments_2825 {

    public static void main(String... args) {
        String str1 = "abc";
        String str2 = "ad";

        System.out.println(canMakeSubsequence(str1, str2));
    }


    private static boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int index1 = 0;
        int index2 = 0;

        while (index1 < m && index2 < n) {
            if (str1.charAt(index1) == str2.charAt(index2) ||
                    str1.charAt(index1) + 1 == str2.charAt(index2) || str1.charAt(index1) - 25 == str2.charAt(index2)) {
                index2++;
            }

            index1++;
        }

        return index2 == n;
    }
}
