package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AsteroidCollision {
    public static void main(String... args) {
        int[] arr1 = new int[]{-2,-1,1,2};
        int[] arr2 = new int[]{8,-8};
        int[] arr3 = new int[]{10,2,-5};

        System.out.println((asteroidCollision(arr1)));
        System.out.println((asteroidCollision(arr2)));
        System.out.println((asteroidCollision(arr3)));
    }

    public static List<Integer> asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> result = new ArrayList<>();

        for(int i=n-2;i>=0;i--) {
            if(asteroids[i] < 0 && asteroids[i+1] < 0) {
                result.add(asteroids[i]);;
            } else if(asteroids[i] > 0 && asteroids[i+1] > 0) {
                result.add(asteroids[i]);
            } else {
                if(Math.abs(asteroids[i]) > Math.abs(asteroids[i+1])) {
                    result.add(asteroids[i]);
                }
            }
        }

        Collections.reverse(result);
        return result;

    }
}
