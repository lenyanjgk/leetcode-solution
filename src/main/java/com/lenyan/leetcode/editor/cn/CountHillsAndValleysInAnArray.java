//2210 统计数组中峰和谷的数量 count-hills-and-valleys-in-an-array
//2025-07-27 13:14:05
package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountHillsAndValleysInAnArray {
    public static void main(String[] args) {
        Solution solution = new CountHillsAndValleysInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countHillValley(int[] nums) {
            List<Integer> newNums = new ArrayList<>();
            for (int num : nums) {
                if (newNums.isEmpty() || newNums.get(newNums.size() - 1) != num) {
                    newNums.add(num);
                }
            }

            int count = 0;
            // 遍历去重后的数组，判断峰和谷
            for (int i = 1; i < newNums.size() - 1; i++) {
                int left = newNums.get(i - 1);
                int mid = newNums.get(i);
                int right = newNums.get(i + 1);

                // 判断是否为峰或谷
                if ((mid > left && mid > right) || (mid < left && mid < right)) {
                    count++;
                }
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}