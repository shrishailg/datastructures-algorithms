package merge_intervals.interval_intersection;

import java.util.*;

public class MergeIntervals {

    public List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();

        intervals.sort(Comparator.comparingInt(a -> a.start));

        Iterator<Interval> iterator = intervals.iterator();
        Interval interval1 = iterator.next();
        int start = interval1.start;
        int end = interval1.end;

        while (iterator.hasNext()){
            Interval interval2 = iterator.next();
            if (interval2.start <= end ){
                end = Math.max(end, interval2.end);
            } else {
                result.add(new Interval(start, end));
                start = interval2.start;
                end = interval2.end;
            }
        }

        result.add(new Interval(start, end));

        return result;
    }
}
