package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem146 {


    //Runtime: 60 ms, faster than 70.66% of Java online submissions for LRU Cache.
    //Memory Usage: 56.5 MB, less than 65.03% of Java online submissions for LRU Cache.
    class LRUCache {
        private Map<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            Integer v = map.get(key);
            if (v != null) {
                map.remove(key);
                map.put(key, v);
                return v;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            map.remove(key);
            map.put(key, value);
            if (map.size() > capacity) {
                map.remove(map.keySet().iterator().next());
            }
        }
    }
}
