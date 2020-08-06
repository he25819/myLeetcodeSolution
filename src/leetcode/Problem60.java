package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem60 {
    public static void main(String[] args) {
        System.out.println(new Problem60().getPermutation(3, 3));
    }

    /**
     * Runtime: 1 ms, faster than 98.52% of Java online submissions for Permutation Sequence.
     * Memory Usage: 36.9 MB, less than 59.46% of Java online submissions for Permutation Sequence.
     */
    private static final int[] fact = new int[10];
    static {
        fact[0] = fact[1] = 1;
        for (int i = 2; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuffer sb = new StringBuffer();
        while (list.size() > 0) {
            int i = (k - 1) / fact[--n];
            k -= i * fact[n];
            sb.append(list.remove(i));
        }
        return sb.toString();
    }
}
