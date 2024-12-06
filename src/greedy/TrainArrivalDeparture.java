package greedy;

import java.util.Arrays;

public class TrainArrivalDeparture {

    public static void main(String... args) {
        Integer[] arri = new Integer[]{900, 940, 950, 1100, 1500, 1800};
        Integer[] dep = new Integer[]{910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(getMaxPlatforms(arri, dep, arri.length));

        Integer[] arr1 = { 100, 300, 500 };
        Integer[] dep1 = { 900, 400, 600 };
        int n = arr1.length;
        System.out.println(getMaxPlatforms(arr1, dep1, n));
    }

    public static int getMaxPlatforms(Integer[] arrivals, Integer[] departures, int n){
        int i = 1, j = 1;
        int platforms = 1;
        int ans = 0;

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        while (i < n && j < n){
            if (arrivals[i] <= departures[j-1]){
                platforms++;
            } else {
                platforms --;

            }

            i++;
            j++;

            ans = Math.max(ans, platforms);
        }

        return platforms;
    }
}
