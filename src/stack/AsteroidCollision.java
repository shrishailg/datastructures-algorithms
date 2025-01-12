package stack;

import java.util.*;

public class AsteroidCollision {
    public static void main(String... args) {
        int[] arr1 = new int[]{-2,-1,1,2};
        int[] arr2 = new int[]{8,-8};
        int[] arr3 = new int[]{10,2,-5};

        System.out.println((Arrays.toString(asteroidCollision(arr1))));
        System.out.println((Arrays.toString(asteroidCollision(arr2))));
        System.out.println((Arrays.toString(asteroidCollision(arr3))));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean isCollision = false;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                if (stack.peek() == Math.abs(asteroid)) {
                    isCollision = true;
                    stack.pop();
                    break;
                } else if (stack.peek() > Math.abs(asteroid)) {
                    isCollision = true;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (!isCollision) {
                stack.push(asteroid);
            }
        }

        List<Integer> result1 = new ArrayList<>();

        while (!stack.isEmpty()) {
            result1.add(stack.pop());
        }

        Collections.reverse(result1);

        int[] result = new int[result1.size()];
        for (int i = 0; i < result1.size(); i++) {
            result[i] = result1.get(i);
        }

        return result;
    }
}
