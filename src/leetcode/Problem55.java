package leetcode;

public class Problem55 {
    public static void main(String[] args) {
        int[] nums = new int[25003];
        for (int i = 0; i < 25000; i++)
            nums[i] = 25000 - i;
        nums[25000] = 1;
        nums[25001] = 0;
        nums[25002] = 0;
        System.out.println(new Problem55().canJump5(nums));
    }


    enum Index {
        GOOD, BAD, UNKNOWN
    }
    /**
     * 75 / 75 test cases passed.
     * Status: Accepted
     * Runtime: 9 ms
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * greedy(top-down)
     */
    public boolean canJump(int[] nums) {
        int max = 0, i = 0;

        while (i <= max && i < nums.length) {
            if (i + nums[i] > max)
                max = i + nums[i];
            i++;
        }
        return max >= nums.length - 1;
    }

    /**
     * 75 / 75 test cases passed.
     * Status: Accepted
     * Runtime: 6 ms
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * greedy(bottom-up)
     */
    public boolean canJump2(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int i = lastPosition - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }



    /**
     * 74 / 75 test cases passed.
     * Status: Time Limit Exceeded
     *
     * Approach 1: Backtracking
     * Time complexity : O(2^n)
     * ​​Space complexity : O(n)
     */
    public boolean canJump3(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position >= nums.length - 1)
            return true;

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }


    Index[] memo;

    /**
     * 74 / 75 test cases passed.
     * Status: Time Limit Exceeded
     * Approach 2: Dynamic Programming Top-down
     * Time complexity : O(n^2)
     * Space complexity : O(2n) = O(n)
     */
    public boolean canJump4(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition2(0, nums);
    }

    private boolean canJumpFromPosition2(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }
        int furthestPosition = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestPosition; nextPosition++) {
            if (canJumpFromPosition2(nextPosition, nums)) {
                memo[nextPosition] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }


    /**
     * 75 / 75 test cases passed.
     * Status: Accepted
     * Runtime: 405 ms
     * Approach 3: Dynamic Programming Bottom-up
     *
     */
    public boolean canJump5(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }
}
