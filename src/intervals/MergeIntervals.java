package intervals;


import merge_intervals.tasks_min_machines.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    static public class Interval{
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }



    // [a,b] [c,d]
    public List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval) {
        intervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> mergedIntervals = new ArrayList<>();

        int i = 0;

        while (i<intervals.size() && intervals.get(i).end<=newInterval.start) {
            mergedIntervals.add(new Interval(intervals.get(i).start, intervals.get(i).end));
            i++;
        }

        while (newInterval.end <= intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        mergedIntervals.add(new Interval(newInterval.start, newInterval.end));

        while (i<intervals.size()) {
            mergedIntervals.add(new Interval(intervals.get(i).start, intervals.get(i).end));
            i++;
        }

        return mergedIntervals;

    }
}


