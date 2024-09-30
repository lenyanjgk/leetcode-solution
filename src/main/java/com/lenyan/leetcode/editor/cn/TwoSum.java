//1 两数之和
//2024-09-25 15:01:36

  package com.lenyan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum{
      public static void main(String[] args) {
           Solution solution = new TwoSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[] twoSum(int[] nums, int target) {
              Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
              for(int i = 0; i < nums.length; i++) {
                  if(map1.containsKey(target-nums[i])) {
                      return new int[] {map1.get(target-nums[i]),i};
                  } else {
                      map1.put(nums[i],i);
                  }
              }
              return new int[0];
          }
      }
//leetcode submit region end(Prohibit modification and deletion)
  }