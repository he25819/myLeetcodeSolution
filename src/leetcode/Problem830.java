package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem830 {
    // 13ms
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();

        char[] chars = S.toCharArray();
        int firstIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[firstIndex]) {
                if (i - firstIndex >= 3) {
                    result.add(Arrays.asList(firstIndex, i - 1));
                }
                firstIndex = i;
            }
        }
        if (firstIndex <= chars.length - 3) {
            result.add(Arrays.asList(firstIndex, chars.length - 1));
        }
        return result;
    }
}
