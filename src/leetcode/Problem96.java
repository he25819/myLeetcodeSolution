package leetcode;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-16 18:09
 **/
public class Problem96 {
    // 无脑递归，速度比较慢
    // Runtime: 988 ms, faster than 9.55% of Java online submissions for Unique Binary Search Trees.
    //Memory Usage: 35.9 MB, less than 17.36% of Java online submissions for Unique Binary Search Trees.
    public int numTrees(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }

    // 用了数组存结果
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
    //Memory Usage: 35.4 MB, less than 17.36% of Java online submissions for Unique Binary Search Trees.
    public int numTrees2(int n) {
        int[] counts = new int[20];
        counts[0] = 1;
        counts[1] = 1;
        counts[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += counts[j - 1] * counts[i - j];
            }
            counts[i] = sum;
        }
        return counts[n];
    }
}
