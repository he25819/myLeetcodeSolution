package leetcode;

import java.util.*;

public class Problem30 {

    public static void main(String[] args) {
        System.out.println(new Problem30().findSubstring3("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }


    // 第二次写的
    // Runtime: 507 ms, faster than 12.76% of Java online submissions for Substring with Concatenation of All Words.
    //Memory Usage: 41.7 MB, less than 35.71% of Java online submissions for Substring with Concatenation of All Words.
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> word2timesMap = new HashMap<>();
        for (String word : words) {
            if (word2timesMap.containsKey(word))
                word2timesMap.put(word, word2timesMap.get(word) + 1);
            else
                word2timesMap.put(word, 1);
        }

        Map<Integer, String> index2wordMap = new HashMap<>();
        for (String word : word2timesMap.keySet()) {
            int start = 0, idx;
            while ((idx = s.indexOf(word, start)) >= 0) {
                index2wordMap.put(idx, word);
                start = idx + 1;
            }
        }

        outer: for (Map.Entry<Integer, String> entry : index2wordMap.entrySet()) {
            HashMap<String, Integer> timesMap = new HashMap<>(word2timesMap);
            for (int i = 0; i < words.length; i++) {
                int idx = entry.getKey() + i * words[0].length();
                String str = index2wordMap.get(idx);
                // not word
                if (str == null)
                    continue outer;
                int remain = timesMap.get(str) - 1;
                // is used
                if (remain < 0)
                    continue outer;
                timesMap.put(str, remain);
            }
            result.add(entry.getKey());
        }

        return result;
    }


    // 第一次写的，结果应该是对的，但超时了
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> index2wordIdsMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int start = 0;
            int idx;
            while ((idx = s.indexOf(words[i], start)) >= 0) {
                List<Integer> wordIds = index2wordIdsMap.get(idx);
                if (wordIds == null) {
                    wordIds = new ArrayList<>();
                }
                wordIds.add(i);
                index2wordIdsMap.put(idx, wordIds);
                start = idx + 1;
            }
        }

        outer: for (Map.Entry<Integer, List<Integer>> entry : index2wordIdsMap.entrySet()) {
            boolean[] isUsed = new boolean[words.length];
            inner: for (int i = 0; i < words.length; i++) {
                int idx = entry.getKey() + i * words[0].length();
                List<Integer> wordIds = index2wordIdsMap.get(idx);
                if (wordIds == null)
                    continue outer;
                for (Integer wordId : wordIds) {
                    if (isUsed[wordId])
                        continue;
                    isUsed[wordId] = true;
                    continue inner;
                }
                continue outer;
            }
            result.add(entry.getKey());
        }

        return result;
    }

    // sample 3 ms submission
    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        if (n == 0) {
            return list;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int size = words[0].length(), window = size * n;
        for (int i = 0; i < size; ++i) {
            int start = i;
            while (start + window <= s.length()) {
                String sub = s.substring(start, start + window);
                Map<String, Integer> temp = new HashMap<>();
                int j = n;
                while (j > 0) {
                    String word = sub.substring(size * (j - 1), size * j);
                    int count = temp.getOrDefault(word, 0) + 1;
                    if (count > map.getOrDefault(word, 0)) {
                        break;
                    }
                    temp.put(word, count);
                    --j;
                }
                if (j == 0) {
                    list.add(start);
                }
                start += size * Math.max(j, 1);
            }
        }
        return list;
    }
}
