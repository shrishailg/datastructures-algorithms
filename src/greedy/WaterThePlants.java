package greedy;

import java.util.ArrayList;
import java.util.List;

public class WaterThePlants {

    public static void main(String... args) {
        int[] gallery1 = new int[]{-1, 2,2,-1, 0,0};
        int[] gallery2 = new int[]{2,3,4,-1,2,0,0,-1,0};

        System.out.println("min sprinklers for gallery 1 is "+ minSprinklers(gallery1, gallery1.length));
        System.out.println("min sprinklers for gallery 2 is "+ minSprinklers(gallery2, gallery2.length));
    }

    public static int minSprinklers(int[] gallery, int n) {
        List<Range> ranges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (gallery[i] < 0){
                ranges.add(new Range(-1, -1));
                continue;
            }
            ranges.add(new Range(Math.max(0, i-gallery[i]), Math.min(n-1, i+gallery[i])));
        }

        int start = 0; int index = 0; int count = 0;

        while(start < n) {

            int maxa = -100;

            while (index < n) {

                if (gallery[index] < 0){
                    index++;
                    continue;
                }

                if (ranges.get(index).start > start)
                    break;

                maxa = Math.max(maxa, ranges.get(index).end);
                index ++;
            }

            if (maxa == -100)
                return -1;

            count++;

            start = maxa + 1;
        }

        return count > 0 ? count : -1;
    }
}

