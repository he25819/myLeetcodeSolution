package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem888 {
    // 34ms
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> setB = new HashSet<>();
        int sumA = 0, sumB = 0;

        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
            setB.add(b);
        }

        int halfDelta = (sumA - sumB) / 2;
        for (Integer a : A) {
            if (setB.contains(a - halfDelta)) {
                return new int[]{a, a - halfDelta};
            }
        }
        return null;
    }
}
