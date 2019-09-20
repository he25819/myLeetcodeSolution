package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem633 {
    private static List<Integer> squares = new ArrayList<>();
    private static int index = -1;

    //Runtime: 16 ms, faster than 25.89% of Java online submissions for Sum of Square Numbers.
    //Memory Usage: 36 MB, less than 7.14% of Java online submissions for Sum of Square Numbers.
    public boolean judgeSquareSum(int c) {
        int needIndex = (int) Math.sqrt(c);
        while (index < needIndex) {
            index++;
            squares.add(index * index);
        }
        for (int r = needIndex; r >= 0; r--) {
            int squaredB = squares.get(r);
            int squaredA = c - squaredB;
            if (squaredA > squaredB)
                return false;
            int i = Collections.binarySearch(squares, squaredA);
            if (i >= 0)
                return true;
        }
        return false;
    }
}
