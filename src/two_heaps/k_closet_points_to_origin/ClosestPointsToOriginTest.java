package two_heaps.k_closet_points_to_origin;

import java.nio.channels.Pipe;

public class ClosestPointsToOriginTest {

    public static void main(String... args){
        Point p1 = new Point(-1,-3);
        Point p2 = new Point(-4,-5);
        Point p3 = new Point(-2,-2);
        Point p4 = new Point(-2,-3);

        Point[] points = new Point[]{p1, p2, p3, p4};

        ClosestPointsToOrigin closestPointsToOrigin = new ClosestPointsToOrigin();

        System.out.println(closestPointsToOrigin.kClosest(points, 3));

    }
}
