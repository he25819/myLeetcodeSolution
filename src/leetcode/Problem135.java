package leetcode;

import java.util.*;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-22 13:32
 **/
public class Problem135 {

    public static void main(String[] args) {
//        System.out.println(new Problem135().candy(new int[]{3, 2, 1, 1, 2, 4, 3, 2, 1, 0, 0}));
//        System.out.println(new Problem135().candy2(new int[]{3, 2, 1, 1, 2, 4, 3, 2, 1, 0, 0}));
        System.out.println(new Problem135().candy3(new int[]{3, 2, 1, 1, 2, 4, 3, 2, 1, 0, 0}));
    }

    // 只遍历一遍
    // Runtime: 2 ms, faster than 95.29% of Java online submissions for Candy.
    //Memory Usage: 39.7 MB, less than 16.42% of Java online submissions for Candy.
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int prev = ratings[0];
        int sum = 1;
        int level = 1;
        int high = 1;
        int maxHigh = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > prev) {
                if (level++ == 1)
                    high = 2;
                else
                    high++;
                maxHigh = high;
                sum += level;
            } else if (ratings[i] < prev) {
                if (level == 1) {
                    high++;
                } else {
                    level = 1;
                    high = 1;
                }
                sum += high < maxHigh ? high : maxHigh + 1;
                if (high == maxHigh)
                    high++;
                maxHigh = Math.max(high, maxHigh);
            } else {
                level = 1;
                high = 1;
                maxHigh = 1;
                sum += 1;
            }
            prev = ratings[i];
        }
        return sum;
    }

    // 贪心
    // Runtime: 20 ms, faster than 11.77% of Java online submissions for Candy.
    //Memory Usage: 45.7 MB, less than 16.42% of Java online submissions for Candy.
    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            indexes.putIfAbsent(ratings[i], new ArrayList<>());
            indexes.get(ratings[i]).add(i);
        }
        int[] sorted = Arrays.copyOf(ratings, ratings.length);
        Arrays.sort(sorted);
        int sum = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1])
                continue;
            for (Integer j : indexes.get(sorted[i])) {
                if (j > 0 && ratings[j] > ratings[j - 1])
                    candies[j] = candies[j - 1] + 1;
                if (j < ratings.length - 1 && ratings[j] > ratings[j + 1])
                    candies[j] = Math.max(candies[j], candies[j + 1] + 1);
                if (candies[j] == 0)
                    candies[j] = 1;
                sum += candies[j];
            }
        }
        return sum;
    }


    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Candy.
    //Memory Usage: 39.7 MB, less than 16.42% of Java online submissions for Candy.
    public int candy3(int[] ratings) {
        int[] extraCandies = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                extraCandies[i] = extraCandies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i])
                extraCandies[i] = Math.max(extraCandies[i], extraCandies[i + 1] + 1);
        }
        int sum = 0;
        for (int extraCandy : extraCandies) {
            sum += extraCandy;
        }
        return sum + ratings.length;
    }
}
