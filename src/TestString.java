public class TestString {

    public static void main(String... args) {

        String str = "abc";

       str.concat("dfg");

       String s1 = "abb";
       String s2 = "bba";

        int k = 1;

        boolean swap = s1.substring(0, k).equals(s2.substring(s1.length()-k, s1.length()))
        && s1.substring(k, s1.length()).equals(s2.substring(0, k));

        System.out.println(swap);


        System.out.println(s1.substring(0, k));
        System.out.println(s2.substring(s1.length()-k, s1.length()));
//        System.out.println(swap);
        System.out.println(s1.substring(k, s1.length()));
        System.out.println(s2.substring(0, s1.length()- k));



//        System.out.println(str);
//
//        System.out.println(str.substring(0, 3));

    }
}
