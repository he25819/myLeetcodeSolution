package leetcode;

public class Problem45 {
    /**
     * 91 / 92 test cases passed.
     * Status: Time Limit Exceeded
     * time complexity: O(n^2)
     *
     * 第一次做出来O(n^2)，超时。。。
     */
    public int jump(int[] nums) {
        int[] needJumps = new int[nums.length];
        for (int i = 1; i < needJumps.length; i++)
            needJumps[i] = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                needJumps[j] = Math.min(needJumps[j], needJumps[i] + 1);
            }
        }
        return needJumps[nums.length - 1];
    }


    /**
     * 92 / 92 test cases passed.
     * Status: Accepted
     * Runtime: 11 ms
     * O(n),除了算出jumps外还能判断是否可达。
     */
    public int jump2(int[] nums) {
        int jumps = 0;
        int curFurthest = 0;
        int oneMoreJumpFurthest = 0;
        for (int i = 0; i < nums.length - 1 && i <= oneMoreJumpFurthest; i++) {
            oneMoreJumpFurthest = Math.max(oneMoreJumpFurthest, i + nums[i]);
            if (i == curFurthest) {
                jumps++;
                curFurthest = oneMoreJumpFurthest;
            }
        }
        if (oneMoreJumpFurthest < nums.length - 1)
            return -1;
        return jumps;
    }

    /**
     * 92 / 92 test cases passed.
     * Status: Accepted
     * Runtime: 5 ms
     * jump2的简化版，根据题意，一定可以达到终点，省去判断是否可达的步骤，加快到5ms.
     * Your runtime beats 100.00 % of java submissions.
     */
    public int jump3(int[] nums) {
        int jumps = 0;
        int curFurthest = 0;
        int oneMoreJumpFurthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            oneMoreJumpFurthest = Math.max(oneMoreJumpFurthest, i + nums[i]);
            if (i == curFurthest) {
                jumps++;
                curFurthest = oneMoreJumpFurthest;
            }
        }
        return jumps;
    }
}
