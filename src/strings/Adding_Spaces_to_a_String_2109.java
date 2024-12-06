package strings;

/*
You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices
in the original string where spaces will be added. Each space should be inserted before the character at the given index.

For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C',
which are at indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
Return the modified string after the spaces have been added.
 */

public class Adding_Spaces_to_a_String_2109 {

    public static void main(String... args) {
       String s = "LeetcodeHelpsMeLearn";
       int[] spaces = {8,13,15};

       System.out.println(addSpaces(s, spaces));
    }

    private static String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilderS = new StringBuilder();
        int m = spaces.length;

        int j=0;
        for (int i = 0; i < s.length(); i++) {
            if (j<m && i == spaces[j]) {
                stringBuilderS.append(" ");
                j++;
            }

            stringBuilderS.append(s.charAt(i));
        }

        return stringBuilderS.toString();
    }
}
