package sliding_window;

//Take K of Each Character From Left and Right.2516
public class Take_K_of_Each_Character_From_Left_and_Right_2516 {

    private static int result = Integer.MAX_VALUE;

    public static void main(String... args) {
       String s = "aabaaaacaabc"; int k = 2;

       System.out.println(takeCharactersOptimised(s, k));
    }

    public static int takeCharacters(String s, int k) {
        recursion(s, k, 0, s.length() - 1, 0, new int[3]);

        return result == Integer.MAX_VALUE? -1: result;
    }

    public static void recursion(String s, int k, int start, int end, int count, int[] charFreq) {
        if (charFreq[0] >= k && charFreq[1] >= k && charFreq[2] >= k) {
            result = Math.min(result, count);
            return;
        }

        if (end < start) {
            return;
        }

        char ch = s.charAt(start);
        charFreq[ch - 'a'] += 1;

        recursion(s, k, start + 1, end, count + 1, charFreq);
        charFreq[ch - 'a'] -= 1; // for backtracking purpose

        ch = s.charAt(end);
        charFreq[ch - 'a'] += 1;

        recursion(s, k, start, end - 1, count + 1, charFreq);
        charFreq[ch - 'a'] -= 1; // for backtracking purpose
    }

    public static int takeCharactersOptimised(String s, int k) {
        int[] charFreq = new int[3];

        for(char ch : s.toCharArray()) {
            charFreq[ch-'a']++;
        }

        if(k==0) {
            return 0;
        }

        for(var freq:charFreq) {
            if (freq < k) {
                return -1;
            }
        }

        int windowStart = 0;
        int windowLength = Integer.MIN_VALUE; // window that can be removed without any affect to the freq
        for(int windowEnd=0;windowEnd<s.length();windowEnd++) {
            char ch = s.charAt(windowEnd);
            charFreq[ch - 'a']-=1;

            //if becomes invalid
               while(windowEnd >= windowStart && (charFreq[0]<k || charFreq[1]<k || charFreq[2]<k)){
                   ch = s.charAt(windowStart);
                   charFreq[ch-'a']++;
                   windowStart++;
               }

            windowLength = Math.max(windowLength, windowEnd-windowStart+1);
        }

        return s.length() - windowLength;
    }
}
