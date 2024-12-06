package strings;


public class ReverseString {

    public static void main(String[] arr){
        String str = "abc";
        char[] strs = str.toCharArray();
        int end = str.length()-1;
        int start = 0;

        while (start < end){
            char temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;

            start++;
            end --;
        }

        System.out.println(String.valueOf(strs) + str);
    }
}
