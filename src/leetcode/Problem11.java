package leetcode;

public class Problem11 {
    // 247ms O(n^2)
    public int maxArea(int[] height) {
        int ans = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return ans;
    }

    // 9ms O(n)
    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, height[l] * (r - l));
                l++;
            } else {
                ans = Math.max(ans, height[r] * (r - l));
                r--;
            }
        }
        return ans;
    }
}
