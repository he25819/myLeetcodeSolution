package leetcode;

import java.util.*;

public class Problem49 {

    // Runtime: 8 ms, faster than 63.22% of Java online submissions for Group Anagrams.
    //Memory Usage: 43.2 MB, less than 73.68% of Java online submissions for Group Anagrams.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            addToMap(map, Arrays.toString(chars), str);
        }
        return new ArrayList<>(map.values());
    }

    private void addToMap(Map<String, List<String>> map, String key, String str) {
        List<String> values = map.get(key);
        if (values == null) {
            List<String> tmp = new ArrayList<>();
            tmp.add(str);
            map.put(key, tmp);
        } else {
            values.add(str);
        }
    }
}
