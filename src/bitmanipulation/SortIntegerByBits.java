package bitmanipulation;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegerByBits {

    public static void main(String... args) {
        Integer[] arr = {5,2,3,8};

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer c1 = Integer.bitCount(o1);
                Integer c2 = Integer.bitCount(o2);

                if (c1.equals(c2)) {
                   return o1.compareTo(o2);
                }

                return c1.compareTo(c2);
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    public static int getSetBits(int num) {
        int count = 0;

        while(num>0) {
            if ((num & 1) == 1) {
                count++;
            }

            num >>=1;
        }

        return count;
    }
}
