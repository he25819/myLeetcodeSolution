package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Problem167 {
    //0(N)
    public int[] twoSum1(int[] numbers, int target) {
        int min = 0, max = numbers.length - 1;
        int sum;
        int[] result = new int[2];
        while (min < max) {
            sum = numbers[min] + numbers[max];
            if (sum < target) {
                min++;
            } else if (sum > target) {
                max--;
            } else {
                result[0] = min + 1;
                result[1] = max + 1;
                return result;
            }
        }
        return null;
    }
    //HashMap O(NlogN)
    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            if (map.containsKey(other) && map.get(other) != i) {
                result[0] = i + 1;
                result[1] = map.get(other) + 1;
                return result;
            }
        }
        return result;
    }
}
