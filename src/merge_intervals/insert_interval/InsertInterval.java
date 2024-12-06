package merge_intervals.insert_interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval){
        List<Interval> result = new ArrayList<>();

        int i=0;
        int n = intervals.size();

        while (i < n && intervals.get(i).end <= newInterval.start){
            result.add(intervals.get(i));
            i++;
        }

        while (i < n && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        result.add(newInterval);

        while(i < n){
            result.add(intervals.get(i++));
        }

        return result;
    }
}
