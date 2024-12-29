package binery_search;

public class SquareRoot {

    public static void main(String... args) {
        System.out.println(findSquareRoot(10) + "  " + Math.sqrt(10));
    }


    private static int findSquareRoot(int x) {
        int low = 1;
        int high = x;

        while(low<high) {
            int mid = low + (high-low)/2;
            int mid_squared = mid * mid;

            if(mid_squared == x) {
                return mid;
            } else  if(mid_squared< x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return high;
    }
}
