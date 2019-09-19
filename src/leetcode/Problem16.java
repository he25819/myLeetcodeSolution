package leetcode;

import java.util.*;

public class Problem16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums1 = new int[]{1, 4, -1, 8};
        int[] nums2 = new int[]{0, 0, 0};
        System.out.println(new Problem16().threeSumClosest(nums, 1));
        System.out.println(new Problem16().threeSumClosest(nums, -1));
        System.out.println(new Problem16().threeSumClosest(nums1, 6));
        System.out.println(new Problem16().threeSumClosest(nums2, 1));
        System.out.println(new Problem16().threeSumClosest2(nums, 1));
        System.out.println(new Problem16().threeSumClosest2(nums, -1));
        System.out.println(new Problem16().threeSumClosest2(nums1, 6));
        System.out.println(new Problem16().threeSumClosest2(nums2, 1));
    }

    private void initTwoSumMap(Map<Integer,List<Integer>> map, int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];

                if (!map.containsKey(sum)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    map.put(sum, list);
                } else {
                    List<Integer> list = map.get(sum);
                    list.add(i);
                    list.add(j);
                }
            }
        }
    }

    private boolean hasDiffIndexPair(List<Integer> value, int index) {
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i - 1) != index && value.get(i) != index) {
                return true;
            }
        }
        return false;
    }

    // 95ms Accepted
    public int threeSumClosest2(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        initTwoSumMap(map, nums);


        Set<Integer> keys = map.keySet();
        Integer[] twoSums = new Integer[keys.size()];
        keys.toArray(twoSums);
        Arrays.sort(twoSums);

        int delta = Integer.MIN_VALUE + 1;
        for (int x = 0; x < nums.length; x++) {
            int targetSum = target - nums[x];

            int index = Arrays.binarySearch(twoSums, targetSum);
            if (index < 0)
                index = -1 * index - 2;

            for (int i = index + 1; i < twoSums.length; i++) {
                if (hasDiffIndexPair(map.get(twoSums[i]), x)) {
                    if (twoSums[i] - targetSum < Math.abs(delta)) {
                        delta = twoSums[i] - targetSum;
                    }
                    break;
                }
            }
            for (int i = index; i >= 0; i--) {
                if (hasDiffIndexPair(map.get(twoSums[i]), x)) {
                    if (targetSum - twoSums[i] < Math.abs(delta)) {
                        delta = twoSums[i] - targetSum;
                    }
                    break;
                }
            }
        }
        return target + delta;
    }


    // Line 26: error: cannot find symbol: class NavigableMap
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        initTwoSumMap(map, nums);

        int delta = Integer.MIN_VALUE + 1;
        for (int i = 0; i < nums.length; i++) {
            int targetSum = target - nums[i];

            NavigableMap<Integer, List<Integer>> tailMap = map.tailMap(targetSum, false);
            while (!tailMap.isEmpty()) {
                Map.Entry<Integer, List<Integer>> entry = tailMap.pollFirstEntry();
                if (hasDiffIndexPair(entry.getValue(), i)) {
                    if (entry.getKey() - targetSum < Math.abs(delta)) {
                        delta = entry.getKey() - targetSum;
                    }
                    break;
                }
            }
            if (delta == 0) {
                return target;
            }

            NavigableMap<Integer, List<Integer>> headMap = map.headMap(targetSum, true);
            while (!headMap.isEmpty()) {
                Map.Entry<Integer, List<Integer>> entry = headMap.pollLastEntry();
                if (hasDiffIndexPair(entry.getValue(), i)) {
                    if (targetSum - entry.getKey() < Math.abs(delta)) {
                        delta = entry.getKey() - targetSum;
                    }
                    break;
                }
            }
            if (delta == 0) {
                return target;
            }
        }
        return target + delta;
    }

    // https://leetcode.com/problems/3sum-closest/discuss/7872/Java-solution-with-O(n2)-for-reference
    // Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element. If the sum is less than target, it means we have to add a larger element so next element move to the next. If the sum is greater, it means we have to add a smaller element so last element move to the second last element. Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
    //Runtime: 4 ms, faster than 95.83% of Java online submissions for 3Sum Closest.
    //Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for 3Sum Closest.
    public int threeSumClosest3(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;

                if (sum - target > 0)
                    end--;
                else if (sum - target < 0)
                    start++;
                else
                    return target;
            }
        }
        return result;
    }
}

