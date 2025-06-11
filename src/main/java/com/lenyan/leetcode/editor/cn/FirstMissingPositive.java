//41 缺失的第一个正数
//2024-09-28 15:00:08

  package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class FirstMissingPositive{
      public static void main(String[] args) {
           Solution solution = new FirstMissingPositive().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            int count = 1;
            for(int i = 0; i < nums.length;i++)
                if(nums[i] == count)
                    count++;
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

  }