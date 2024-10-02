//146 LRU 缓存
//2024-10-02 23:07:44

  package com.lenyan.leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache{
      public static void main(String[] args) {}
      //leetcode submit region begin(Prohibit modification and deletion)
      class LRUCache extends LinkedHashMap<Integer, Integer> {
          private int capacity;

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
          protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
              return size() > capacity;
          }
      }



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }