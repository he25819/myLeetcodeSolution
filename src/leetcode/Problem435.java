package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435 {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Non-overlapping Intervals.
    //Memory Usage: 35.9 MB, less than 62.50% of Java online submissions for Non-overlapping Intervals.
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        if (intervals == null || intervals.length <= 1)
            return 0;
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                count++;
                end = Math.min(end, intervals[i][1]);
            }
        }
        return count;
    }
}
