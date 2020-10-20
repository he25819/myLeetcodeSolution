package leetcode;

import java.util.*;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-20 15:59
 **/
public class Problem139 {

    // 两个解法算法思路一样，第一个的存储结构果然速度更快
    // Runtime: 3 ms, faster than 84.19% of Java online submissions for Word Break.
    //Memory Usage: 37.2 MB, less than 10.64% of Java online submissions for Word Break.
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> sizedWordDict = new HashMap<>();
        for (String word : wordDict) {
            List<String> words = sizedWordDict.computeIfAbsent(word.length(), k -> new ArrayList<>());
            words.add(word);
        }

        boolean[] rst = new boolean[s.length() + 1];
        rst[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                if (rst[k]) {
                    List<String> words = sizedWordDict.get(i - k);
                    if (words != null && words.contains(s.substring(k, i))) {
                        rst[i] = true;
                        break;
                    }
                }
            }
        }
        return rst[s.length()];
    }



    // Runtime: 6 ms, faster than 64.73% of Java online submissions for Word Break.
    //Memory Usage: 39.7 MB, less than 10.64% of Java online submissions for Word Break.
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);

        boolean[] rst = new boolean[s.length() + 1];
        rst[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                if (rst[k] && dict.contains(s.substring(k, i))) {
                    rst[i] = true;
                    break;
                }
            }
        }
        return rst[s.length()];
    }
}
