package merge_intervals.insert_interval;

import java.util.Arrays;
import java.util.List;

public class InsertIntervalTest {

    public static void main(String[] args){
        Interval[] intervals = new Interval[]{new Interval(1,3), new Interval(5,7), new Interval(8,12)};
        Interval newInterval = new Interval(4, 6);

        InsertInterval insertInterval = new InsertInterval();

        List<Interval> result =  insertInterval.insertInterval(Arrays.asList(intervals), newInterval);

        System.out.println(result.toString());

    }
}
