package strings;


/*
Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty
substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.
 */
public class Maximum_Score_After_Splitting_a_String {

    public int maxScore(String s) {
        int n = s.length();

        int score = 0;
        for(int i=1;i<=n-1;i++) {
            String left = s.substring(0,i);
            String right = s.substring(i,n);

            int zeros = countZero(left);
            int ones = countOne(right);

            score = Math.max(score, zeros + ones);
        }

        return score;
    }

    int countZero(String s) {
        int count = 0;
        for(var val:s.toCharArray()) {
            if (val == '0') {
                count++;
            }
        }

        return count;
    }

    int countOne(String s) {
        int count = 0;
        for(var val:s.toCharArray()) {
            if (val == '1') {
                count++;
            }
        }

        return count;
    }
}
