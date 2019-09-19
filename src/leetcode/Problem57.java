package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem57 {
    // Definition for an interval.
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    // 154 / 154 test cases passed.
    //Status: Accepted
    //Runtime: 10 ms
    // Your runtime beats 53.54 % of java submissions.
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        int start = newInterval.start, end = newInterval.end;
        boolean isMerging = false, isInserted = false;
        for (Interval interval : intervals) {
            if (isInserted) {
                result.add(interval);
            } else if (!isMerging) {
                if (interval.end < newInterval.start) {
                    result.add(interval);
                } else {
                    if (newInterval.end < interval.start) {
                        result.add(newInterval);
                        result.add(interval);
                        isInserted = true;
                    } else {
                        start = Math.min(interval.start, newInterval.start);
                        end = Math.max(interval.end, newInterval.end);
                        isMerging = true;
                    }
                }
            } else {
                if (end < interval.start) {
                    result.add(new Interval(start, end));
                    result.add(interval);
                    isInserted = true;
                } else {
                    end = Math.max(end, interval.end);
                }
            }
        }
        if (!isInserted)
            result.add(new Interval(start, end));
        return result;
    }

    // https://leetcode.com/problems/insert-interval/discuss/21600/Short-java-code
    // 154 / 154 test cases passed.
    //Status: Accepted
    //Runtime: 8 ms
    // Your runtime beats 96.57 % of java submissions.
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }

    // https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
    // 154 / 154 test cases passed.
    //Status: Accepted
    //Runtime: 9 ms
    public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }
}
