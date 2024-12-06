public class ConvertCharToInt {

    public static void main(String... args) {
        char a = 'a';
        int b = a - 'a';

        char c = (char) (b+'0');
//        System.out.println(c);
//        System.out.println(b);

        String s1 = "abc";
        String s2 = "abcd";

        int xor = 0;
        for (var ch:s1.toCharArray()){
            xor ^=ch;
        }

        for (var ch:s2.toCharArray()){
            xor ^=ch;
        }

        Character f = (char) xor;

        int xy = (int) f;

        System.out.println(f);
        System.out.println(xy);
    }
}
