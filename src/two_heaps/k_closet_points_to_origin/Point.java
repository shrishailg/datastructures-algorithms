package two_heaps.k_closet_points_to_origin;

public class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "["+x+", "+y+"]";
    }
}
