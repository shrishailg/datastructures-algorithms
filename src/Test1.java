import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static  void main(String... args) {
        String str = "abdcxycd0";

        String str2 = swap(str, 0, str.length()-2);
       int n = str2.indexOf('0');
        System.out.println(str2);
        System.out.println(n);
    }

    static String swap(String s, int x, int y) {
        char[] array = s.toCharArray();
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;

        return String.valueOf(array);
    }
}
