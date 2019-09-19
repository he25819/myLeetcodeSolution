package leetcode;

public class Problem717 {
    // 最后一个0之前有连续几个1，偶数个就是true，奇数个就是false
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1)
            return true;

        int oneCount = 0;
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                oneCount++;
            } else {
                break;
            }
        }
        return oneCount % 2 != 1;
    }
}
