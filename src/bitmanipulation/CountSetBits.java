package bitmanipulation;

public class CountSetBits {

    public static void main(String... args){
        int n1 = 4;

        System.out.println(getSetBitsCount(n1));
    }

    public static int getSetBitsCount(int num) {
        int count =0;

        while(num>0) {
            if ((num&1) == 1) {
                count++;
            }

            num >>=1;
        }

        return count;
    }

    //O(k) k: no of set bits
    public static int getSetBitsCount1(int num) {
        int count =0;

        while(num>0) {
            num = num & num-1;
            count++;
        }

        return count;
    }

    //O(32) constant time complexity
    public static int getSetBitsCount2(int num) {
        int count =0;

        for(int i=31;i>=0;i--) {
            if( ((num >> i) & 1) == 1) {
                count++;
            }
        }

        return count;
    }

    //O(log(n)) (base 2) constant time complexity
    public static int getSetBitsCount3(int num) {
        int count =0;

        while(num != 0) {
            count += num%2;
            num = num/2;
        }

        return count;
    }
}
