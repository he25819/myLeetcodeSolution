package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-19 16:03
 **/
public class Problem679 {

/*
    [4,1,8,7]
            [5,5,5,1]
            [1,2,1,9]
            [1,2,1,2]
            [1,2,3,4]
            [8,1,6,6]
            [3,4,6,7]
    */

    public static void main(String[] args) {
//        System.out.println(new Problem679().judgePoint24(new int[]{4, 1, 8, 7}));
//        System.out.println(new Problem679().judgePoint24(new int[]{5,1,5,5}));
        System.out.println(new Problem679().judgePoint24(new int[]{1,2,1,2}));
//        System.out.println(new Problem679().judgePoint24(new int[]{8,1,6,6}));
//        System.out.println(new Problem679().judgePoint24(new int[]{3,4,6,7}));
    }

    // Runtime: 2 ms, faster than 87.79% of Java online submissions for 24 Game.
    //Memory Usage: 36.7 MB, less than 5.30% of Java online submissions for 24 Game.
    public boolean judgePoint24(int[] nums) {
        List<Integer> candidates = new ArrayList<>();
        Collections.addAll(candidates, nums[0], nums[1], nums[2], nums[3]);

        int a = candidates.remove(0);
        int b;
        for (int i = 0; i < 3; i++) {
            b = candidates.remove(0);
            if (helper(candidates, a + b, 24)
                    || helper(candidates, (double) a - b, 24)
                    || helper(candidates, (double) b - a, 24)
                    || helper(candidates, (double) a * b, 24)
                    || helper(candidates, (double) b / a, 24)
                    || helper(candidates, (double) a / b, 24)) {
                return true;
            }
            candidates.add(b);
        }
        candidates.add(a);
        for (int i = 0; i < 4; i++) {
            a = candidates.remove(0);
            if (helper(candidates, a, 24))
                return true;
            candidates.add(a);
        }
        return false;
    }

    private boolean helper(List<Integer> candidates, double k, double target) {
        if (candidates.size() == 0) {
            return Math.abs(target - k) < 0.0001;
        }
        for (int i = 0; i < candidates.size(); i++) {
            int a = candidates.remove(0);
            if (helper(candidates, a, target + k)
                    || helper(candidates, a, target - k)
                    || helper(candidates, a, k - target)
                    || (k != 0 && helper(candidates, a, target * k))
                    || (k != 0 && helper(candidates, a, target / k))
                    || (k != 0 && helper(candidates, a, k / target))) {
                return true;
            }
            candidates.add(a);
        }
        return false;
    }


    // 第一个方法写得不美，重新写一个
    // 把newList改成double[]可以优化速度
    // Runtime: 4 ms, faster than 73.14% of Java online submissions for 24 Game.
    //Memory Usage: 38.9 MB, less than 5.23% of Java online submissions for 24 Game.
    public boolean judgePoint24_2(int[] nums) {
        List<Double> list = new ArrayList<>();
        Collections.addAll(list, nums[0] + 0.0, nums[1] + 0.0, nums[2] + 0.0, nums[3] + 0.0);
        return helper2(list);
    }

    private boolean helper2(List<Double> candidates) {
        if (candidates.size() == 1)
            return Math.abs(candidates.get(0) - 24) < 1e-5;
        for (int i = 0; i < candidates.size() - 1; i++) {
            for (int j = i + 1; j < candidates.size(); j++) {
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < candidates.size(); k++) {
                    if (k != i && k != j)
                        newList.add(candidates.get(k));
                }

                for (double c : compute(candidates.get(i), candidates.get(j))) {
                    newList.add(c);
                    if (helper2(newList))
                        return true;
                    newList.remove(c);
                }
            }
        }
        return false;
    }

    private double[] compute(double a, double b) {
        return new double[]{a + b, a * b, a - b, b - a, a / b, b / a};
    }
}
