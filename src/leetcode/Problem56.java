package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem56 {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0;end = 0; }
        Interval(int s, int e) { start = s;end = e; }
    }

    // 169 / 169 test cases passed.
    //Status: Accepted
    //Runtime: 11 ms
    // Your runtime beats 96.13 % of java submissions.
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return result;
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int i = 0, j = 0;
        int left = starts[i++];
        int state = 1;
        while (i < starts.length) {
            if (starts[i] <= ends[j]) {
                i++;
                state++;
            } else if (state == 1) {
                result.add(new Interval(left, ends[j++]));
                left = starts[i++];
            } else {
                j++;
                state--;
            }
        }
        if (state > 0)
            result.add(new Interval(left, ends[i - 1]));
        return result;
    }
}
