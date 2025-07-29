//2411 按位或最大的最小子数组长度 smallest-subarrays-with-maximum-bitwise-or
//2025-07-29 22:56:53
package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class SmallestSubarraysWithMaximumBitwiseOr {
    public static void main(String[] args) {
        Solution solution = new SmallestSubarraysWithMaximumBitwiseOr().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] pos = new int[31];
            Arrays.fill(pos, -1);
            int[] ans = new int[n];
            for (int i = n - 1; i >= 0; --i) {
                int j = i;
                for (int bit = 0; bit < 31; ++bit) {
                    if ((nums[i] & (1 << bit)) == 0) {
                        if (pos[bit] != -1) {
                            j = Math.max(j, pos[bit]);
                        }
                    } else {
                        pos[bit] = i;
                    }
                }
                ans[i] = j - i + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}