package leetcode;

import java.util.Stack;

public class Problem42 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Problem42().trap4(height));
    }
    /**
     * 315 / 315 test cases passed.
     * Status: Accepted
     * Runtime: 18 ms
     * Time complexity: O(n)
     * space complexity: O(n)
     */
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int ans = 0;
        int[] rightMaxHeight = new int[height.length];

        for (int i = height.length - 1, maxHit = 0; i >= 0; i--) {
            if (height[i] > maxHit)
                maxHit = height[i];
            rightMaxHeight[i] = maxHit;
        }
        for (int i = 0, maxHit = 0; i < height.length; i++) {
            if (height[i] > maxHit)
                maxHit = height[i];
            ans += Math.min(maxHit, rightMaxHeight[i]) - height[i];
        }
        return ans;
    }


    /**
     * 315 / 315 test cases passed.
     * Status: Accepted
     * Runtime: 23 ms
     * copy from Solution: https://leetcode.com/problems/trapping-rain-water/solution/
     * Approach 3: Using stacks
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int trap2(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }


    /**
     * 315 / 315 test cases passed.
     * Status: Accepted
     * Runtime: 12 ms
     * Approach 4: Using 2 pointers
     */
    public int trap3(int[] height) {
        int leftMax = 0, rightMax = 0;
        int lo = 0, hi = height.length - 1;

        int ans = 0;
        while (lo < hi) {
            if (height[lo] < height[hi]) {
                if ((height[lo] >= leftMax)) {
                    leftMax = height[lo];
                } else {
                    ans += leftMax - height[lo];
                }
                lo++;
            } else {
                if (height[hi] >= rightMax) {
                    rightMax = height[hi];
                } else {
                    ans += rightMax - height[hi];
                }
                hi--;
            }
        }
        return ans;
    }

    /**
     * copy from sample 18 ms submission
     * 用stack解，和trap2一样。
     * 315 / 315 test cases passed.
     * Status: Accepted
     * Runtime: 19 ms
     */
    public int trap4(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0, i = 0;
        while (i < height.length){
            int curt = height[i];
            if (stack.isEmpty() || curt < height[stack.peek()]){
                stack.push(i++);
            }else{
                int bot = height[stack.pop()];
                if (stack.isEmpty()){
                    continue;
                }
                int prev = height[stack.peek()];
                int dist = i - stack.peek() - 1;
                ans += (Math.min(prev, curt) - bot) * dist;
            }
        }

        return ans;
    }
}
