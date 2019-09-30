package leetcode;

import java.util.Arrays;

public class Problem948 {
    // 初始能量P，得分0，每个token只能用1次，或者消耗token能量，得分+1，或者得分-1，获得token能量。求最高得分。
    // greedy
    //Runtime: 2 ms, faster than 99.75% of Java online submissions for Bag of Tokens.
    //Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Bag of Tokens.
    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens == null || tokens.length == 0)
            return 0;
        Arrays.sort(tokens);

        if (P < tokens[0])
            return 0;
        int l = 0, r = tokens.length - 1;
        int score = 0;
        while (l <= r) {
            if (P >= tokens[l]) {
                P -= tokens[l++];
                score++;
            } else if (score > 0 && l < r) {
                P += tokens[r--];
                score--;
            } else {
                return score;
            }
        }
        return score;
    }
}
