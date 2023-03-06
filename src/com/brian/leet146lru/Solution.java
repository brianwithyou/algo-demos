package com.brian.leet146lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private Integer capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;

        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            return size() > capacity;
        }
    }
}
