package leetcode;

public class Problem697 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        int[] nums2 = new int[]{1, 2, 2, 3};
        new Problem697().findShortestSubArray(nums2);
    }

    public int findShortestSubArray(int[] nums) {
        int[] times = new int[50000];
        int[][] indexs = new int[50000][2];

        for (int i = 0; i < nums.length; i++) {
            if (++times[nums[i]] == 1) {
                indexs[nums[i]][0] = i;
                indexs[nums[i]][1] = i;
            } else {
                indexs[nums[i]][1] = i;
            }
        }

        int degree = 1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (degree < times[nums[i]]) {
                degree = times[nums[i]];
                result = indexs[nums[i]][1] - indexs[nums[i]][0] + 1;
            } else if (degree == times[nums[i]]) {
                result = Math.min(result, indexs[nums[i]][1] - indexs[nums[i]][0] + 1);
            }
        }
        return result;
    }
}