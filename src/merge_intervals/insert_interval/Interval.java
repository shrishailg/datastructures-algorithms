package merge_intervals.insert_interval;

public class Interval {
     int start;
     int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString(){
        return "[" + start+" ,"+end+"]";
    }
}
