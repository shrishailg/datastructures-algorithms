package merge_intervals.interval_intersection;

import java.util.Arrays;
import java.util.List;

public class MergeIntervalsTest {

    public static void main(String... args){
//        Interval[] intervals = new Interval[]{new Interval(1,4), new Interval(2,5), new Interval(7,9)};

        Interval[] intervals = new Interval[]{new Interval(6,7), new Interval(2,4), new Interval(5,9)};

        MergeIntervals mergeIntervals = new MergeIntervals();

        List<Interval> result = mergeIntervals.mergeIntervals(Arrays.asList(intervals));
        result.forEach(System.out::print);
    }
}
