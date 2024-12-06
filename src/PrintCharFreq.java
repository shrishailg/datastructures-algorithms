public class PrintCharFreq {

    public static void main(String... args) {
        String str = "abcabbbccaabd";
        StringBuilder str1 = new StringBuilder();
        System.out.println(str.substring(1,3));
        str1.append(str.charAt(0));
        int freq = 1;
        for (int i = 1; i < str.length();i++){
            if (str.charAt(i) == str.charAt(i-1)){
                freq++;
                continue;
            }

            if (str.charAt(i) != str.charAt(i-1)){
                str1.append(freq);
                freq = 1;
            }

            str1.append(str.charAt(i));
        }

        str1.append(freq);

        System.out.println(str1);
    }
}
