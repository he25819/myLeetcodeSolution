package leetcode;

import utils.Stopwatch;

import java.util.*;

public class Problem84_toBeReview {
    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int[] heights2 = new int[20000];
        int[] heights3 = new int[]{2,1,2};
        for (int i = 0; i < heights2.length; i++)
            heights2[i] = i;
//        System.out.println(new Problem84().largestRectangleArea(heights2));

        Stopwatch.start();
        System.out.println(new Problem84_toBeReview().largestRectangleArea7(heights2));
        Stopwatch.stop();
    }

    // 答案正确但是超时
    // 94 / 96 test cases passed.
    //Status: Time Limit Exceeded
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Map<Integer, Integer> rectangles = new HashMap<>();
        List<Integer> needDelete = new ArrayList<>();
        int result = 0;
        int i = 0;
        while (i < heights.length) {
            needDelete.clear();
            rectangles.put(heights[i], rectangles.containsKey(heights[i]) ? rectangles.get(heights[i]) + 1 : 1);
            for (Map.Entry<Integer, Integer> entry : rectangles.entrySet()) {
                if (entry.getValue() < 0)
                    continue;
                if (entry.getKey() == heights[i]) {
                    result = Math.max(result, heights[i] * entry.getValue());
                    continue;
                }
                if (entry.getKey() < heights[i]) {
                    result = Math.max(result, entry.getKey() * (entry.getValue() + 1));
                    rectangles.put(entry.getKey(), entry.getValue() + 1);
                } else {
                    int width = Math.max(entry.getValue() + 1, rectangles.get(heights[i]));
                    result = Math.max(result, heights[i] * width);
                    rectangles.put(heights[i], width);
                    needDelete.add(entry.getKey());
                }
            }
            for (int width : needDelete) {
                rectangles.remove(width);
            }
            i++;
        }
        return result;
    }

    // O(N)
    // https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/O(n)-stack-based-JAVA-solution
    // https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
    // 96 / 96 test cases passed.
    //Status: Accepted
    //Runtime: 18 ms
    // Your runtime beats 71.29 % of java submissions.
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if(s.isEmpty() || h >= heights[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    // learn from https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28902/5ms-O(n)-Java-solution-explained-(beats-96)
    // 96 / 96 test cases passed.
    //Status: Accepted
    //Runtime: 4 ms
    // Your runtime beats 91.46 % of java submissions.
    /*
    For any bar i the maximum rectangle is of width r - l - 1 where r - is the last coordinate of the bar to the right with height h[r] >= h[i] and l - is the last coordinate of the bar to the left which height h[l] >= h[i]

    The meaning of r and l is somewhat confusing, to put them more accurately:
l: the first coordinate of the bar to the left with height h[l] < h[i].
r: the first coordinate of the bar to the right with height h[r] < h[i].
     */
    //Runtime: 2 ms, faster than 99.23% of Java online submissions for Largest Rectangle in Histogram.
    //Memory Usage: 40.4 MB, less than 90.91% of Java online submissions for Largest Rectangle in Histogram.
    public int largestRectangleArea3(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int n = heights.length;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight = new int[n];
        lessFromLeft[0] = -1;
        lessFromRight[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }

        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }

    // 学方法2写的。
    // 96 / 96 test cases passed.
    //Status: Accepted
    //Runtime: 25 ms
    // Your runtime beats 35.87 % of java submissions.
    public int largestRectangleArea4(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];
            if (stack.empty() || height > heights[stack.peek()]) {
                stack.push(i);
            } else if (height == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                int area = heights[stack.pop()] * (i - (stack.empty() ? -1 : stack.peek()) - 1);
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }


    // the same as fun2()
    public int largestRectangleArea5(int[] heights) {
        Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (s.empty() || heights[s.peek()] <= h) {
                s.push(i);
            } else {
                int top = s.pop();
                maxArea = Math.max(maxArea, heights[top] * (s.empty() ? i : (i - s.peek() - 1)));
                i--;
            }
        }
        return maxArea;
    }

    // the same as fun3()
    // 对每个i，maxArea = heights[i] * (r - l - 1)
    // 其中l = 从i往左，第一个heights[l] < heights[i]
    //     r = 从i往右，第一个heights[r] < heights[i]
    //Runtime: 2 ms, faster than 99.23% of Java online submissions for Largest Rectangle in Histogram.
    //Memory Usage: 40 MB, less than 93.18% of Java online submissions for Largest Rectangle in Histogram.
    public int largestRectangleArea6(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int maxArea = 0;

        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];

        lessFromLeft[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i])
                p = lessFromLeft[p];
            lessFromLeft[i] = p;
        }

        lessFromRight[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < heights.length && heights[p] >= heights[i])
                p = lessFromRight[p];
            lessFromRight[i] = p;
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return maxArea;
    }


    // dp  O(N^2)
    // 答案应该正确，但是Memory Limit Exceeded
    public int largestRectangleArea7(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int maxArea = 0;
        int[][] minHeight = new int[heights.length][heights.length];

        for (int l = 0; l < heights.length; l++) {
            minHeight[l][l] = heights[l];
            maxArea = Math.max(maxArea, heights[l]);
            for (int r = l + 1; r < heights.length; r++) {
                minHeight[l][r] = Math.min(minHeight[l][r - 1], heights[r]);
                maxArea = Math.max(maxArea, minHeight[l][r] * (r - l + 1));
            }
        }

        return maxArea;
    }
}
