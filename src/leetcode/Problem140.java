package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hexw
 * @version 1.0
 * @create 2020-10-20 16:36
 **/
public class Problem140 {

    // 思路：做完139题，解法不变，boolean[]改成Map<Integer, List<Integer>>
    // 从保存是否可分割，改为了null表示不可分割，list（非null表示可分割）存前一个分割点
    // Runtime: 7 ms, faster than 73.92% of Java online submissions for Word Break II.
    //Memory Usage: 39.2 MB, less than 7.85% of Java online submissions for Word Break II.
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> sizedWordDict = new HashMap<>();
        for (String word : wordDict) {
            List<String> words = sizedWordDict.computeIfAbsent(word.length(), k -> new ArrayList<>());
            words.add(word);
        }

        Map<Integer, List<Integer>> indexes = new HashMap<>();
        indexes.put(0, new ArrayList<>());
        for (int i = 1; i <= s.length(); i++) {
            for (int k = 0; k < i; k++) {
                if (indexes.get(k) != null) {
                    List<String> words = sizedWordDict.get(i - k);
                    if (words != null && words.contains(s.substring(k, i))) {
                        List<Integer> idxes = indexes.computeIfAbsent(i, n -> new ArrayList<>());
                        idxes.add(k);
                    }
                }
            }
        }
        List<String> rst = new ArrayList<>();
        if (indexes.get(s.length()) != null)
            dfs(rst, s, indexes, s.length(), new ArrayList<>());
        return rst;
    }

    private void dfs(List<String> rst, String s, Map<Integer, List<Integer>> indexes, int idx, ArrayList<String> strings) {
        if (idx == 0)
            rst.add(buildString(strings));
        for (Integer i : indexes.get(idx)) {
            strings.add(0, s.substring(i, idx));
            dfs(rst,s, indexes, i, strings);
            strings.remove(0);
        }
    }

    private String buildString(ArrayList<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            if (i != 0)
                sb.append(' ');
            sb.append(strings.get(i));
        }
        return sb.toString();
    }
}
