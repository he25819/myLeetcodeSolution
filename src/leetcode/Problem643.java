package leetcode;

public class Problem643 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        new Problem643().findMaxAverage(nums, 4);
    }
    public double findMaxAverage(int[] nums, int k) {
        int delta = 0;
        int maxDelta = 0;
        int index = 0;
        for (int i = 0; i < nums.length - k; i++) {
            delta -= nums[i];
            delta += nums[i + k];
            if (maxDelta < delta) {
                maxDelta = delta;
                index = i + 1;
            }
        }

        int sum = 0;
        for (int i = index; i < index + k; i++) {
            sum += nums[i];
        }
        return (double) sum / k;
    }
}
