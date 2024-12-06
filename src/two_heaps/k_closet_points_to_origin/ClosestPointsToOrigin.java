package two_heaps.k_closet_points_to_origin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestPointsToOrigin {

    public  List<Point> kClosest(Point[] points, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2){
                Double d1 =  distance(o1);
                Double d2 =  distance(o2);

               return d2.compareTo(d1);
            }
        });

        for(var point: points){
            if(maxHeap.size() < k){
                maxHeap.add(point);
            } else if(maxHeap.size() >= k &&
                    distance(point) < distance(maxHeap.peek())){

                maxHeap.poll();
                maxHeap.add(point);
            }
        }

        List<Point> result = new ArrayList<>();

        while(!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }

        return result;
    }

    public  double distance(Point point){
        int s1 = point.x* point.x;
        int s2 = point.y*point.y;
        return Math.sqrt(s1+s2);
    }

}
