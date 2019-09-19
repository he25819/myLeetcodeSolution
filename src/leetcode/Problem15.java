package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 0, 2, -1, -4};
        int[] nums2 = new int[]{-1,-1,-1,-2,-2,0,0,1,1,1,2,2};
        System.out.println(new Problem15().threeSum(nums));
        System.out.println(new Problem15().threeSum(nums2));
        System.out.println(new Problem15().threeSum(new int[]{0, 0, 0, 0}));
//        System.out.println(new leetcode.Problem15().threeSum2(nums));
        System.out.println(new Problem15().threeSum2(nums2));
        System.out.println(new Problem15().threeSum2(new int[]{0, 0, 0, 0}));
    }

    // 85ms Accepted
    // 三个指针
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int left = 0; left < nums.length - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1])
                continue;

            int mid = left + 1, right = nums.length - 1;
            int twoSum = 0 - nums[left];
            while (mid < right) {
                int cur = nums[mid] + nums[right];
                if (cur == twoSum) {
                    res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while (nums[mid] == nums[++mid] && mid < right) ;
                    while (nums[right] == nums[--right] && mid < right) ;
                } else if (cur < twoSum)
                    while (nums[mid] == nums[++mid] && mid < right) ;
                else
                    while (nums[right] == nums[--right] && mid < right) ;
            }
        }
        return res;
    }

    // Accepted 86 ms
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int zeroIndex = Arrays.binarySearch(nums, 0);
        int l = zeroIndex, r = zeroIndex;   // first zero index, last zero index
        int zeroNum = 0;

        // contains zero
        if (zeroIndex >= 0) {
            zeroNum++;
            for (int i = zeroIndex - 1; i >= 0; i--) {
                if (nums[i] == 0) {
                    zeroNum++;
                    l = i;
                }
            }
            for (int i = zeroIndex + 1; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroNum++;
                    r = i;
                }
            }
            if (zeroNum >= 3) {
                addThree(result, 0, 0, 0);
            }

            // -n 0 n
            int i = l - 1;
            int j = r + 1;
            int lastN = 0;
            while (i >= 0 && j < nums.length) {
                if (nums[i] == lastN) {
                    i--;
                    continue;
                }
                if (nums[j] == lastN) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] < 0) {
                    j++;
                } else if (nums[i] + nums[j] > 0) {
                    i--;
                } else {
                    lastN = nums[i];
                    addThree(result, nums[i--], 0, nums[j++]);
                }
            }
        } else {    // not contains zero
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = (low + high) >> 1;
                int midVal = nums[mid];

                if (midVal < 0) {
                    low = mid + 1;
                } else if (midVal > 0) {
                    high = mid - 1;
                }
            }
            l = low;
            r = high;
        }

        // -a -b c
        int lastA = 0;
        for (int i = l - 1; i > 0; i--) {
            if (nums[i] == lastA) {
                continue;
            }
            lastA = nums[i];
            int lastB = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] == lastB) {
                    continue;
                }
                lastB = nums[j];
                int c = -lastA - lastB;
                if (Arrays.binarySearch(nums, c) > 0) {
                    addThree(result, lastA, lastB, c);
                }
            }
        }

        // -a b c
        int lastB = 0;
        for (int i = r + 1; i < nums.length - 1; i++) {
            if (nums[i] == lastB) {
                continue;
            }
            lastB = nums[i];
            int lastC = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == lastC) {
                    continue;
                }
                lastC = nums[j];
                int a = -lastB - lastC;
                if (Arrays.binarySearch(nums, a) >= 0) {
                    addThree(result, a, lastB, lastC);
                }
            }
        }
        return result;
    }

    private static void addThree(List<List<Integer>> result, int a, int b, int c) {
        result.add(Arrays.asList(a, b, c));
    }
}
