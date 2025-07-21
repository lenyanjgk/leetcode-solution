//1695 删除子数组的最大得分 maximum-erasure-value
//2025-07-22 00:29:30
package com.lenyan.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        Solution solution = new MaximumErasureValue().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int ans = 0, s = 0, left = 0;
            for(int x : nums) {
                while(set.contains(x)) {
                    set.remove(nums[left]);
                    s -= nums[left];
                    left++;
                }
                set.add(x);
                s+=x;
                ans = Math.max(ans,s);
            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
}