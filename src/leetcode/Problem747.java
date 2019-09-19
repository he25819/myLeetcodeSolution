package leetcode;

import java.util.Arrays;

public class Problem747 {
    public static void main(String[] args) {
        new Problem747().dominantIndex(new int[]{1, 2, 3});
    }

    // 12ms
    // O(NlogN)
    public int dominantIndex(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] copy = nums.clone();
        Arrays.sort(copy);
        if (copy[copy.length - 1] < copy[copy.length - 2] * 2) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == copy[copy.length - 1]) {
                return i;
            }
        }
        return -1;
    }

    // 13ms
    // O(N)
    public int dominantIndex2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max, secondMax;
        if (nums[0] >= nums[1]) {
            max = 0;
            secondMax = 1;
        } else {
            max = 1;
            secondMax = 0;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[secondMax]) {
                if (nums[i] > nums[max]) {
                    secondMax = max;
                    max = i;
                } else {
                    secondMax = i;
                }
            }
        }
        if (nums[max] >= nums[secondMax] * 2) {
            return max;
        } else {
            return -1;
        }
    }

    // 15ms
    // O(N)
    public int dominantIndex3(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = -1, secondMax = -1;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max >= secondMax * 2) {
            return index;
        } else {
            return -1;
        }
    }
}
