import java.util.Arrays;

public class InsertDots {

    public static void main(String... args){
        String str = "ab.......cd.......bc......";
        int wordsCount = 0;
        int dotCount = 0;

        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == '.')
                dotCount++;

            if (str.charAt(i) != '.' && str.charAt(i+1) != '.'){
                wordsCount++;
            }
        }
//
//        int j = 0;
//        for (int i=0;i<str.length();i++){
//            if (str.charAt(i) != '.'){
//                str[j] = str.charAt(i);
//            }
//
//        }


        String[] str1 = str.split(".[a-z]+");
        System.out.println(str1[0]);
    }
}
