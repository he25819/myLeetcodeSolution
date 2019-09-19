package leetcode;

public class Problem605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (n > flowerbed.length / 2 + 1) {
            return false;
        }
        int zeroCount = 0;
        boolean isAllZero = true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zeroCount++;
            } else if (flowerbed[i] == 1) {
                isAllZero = false;
                if (i == zeroCount) {
                    n -= zeroCount / 2;
                } else {
                    n -= (zeroCount - 1) / 2;
                }
                zeroCount = 0;
            }
        }
        if (isAllZero) {
            n -= (zeroCount + 1) / 2;
        } else {
            n -= zeroCount / 2;
        }
        return n <= 0;
    }
}
