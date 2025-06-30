//594  最长和谐子序列 longest-harmonious-subsequence
//2025-07-01 00:08:39

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int findLHS(int[] nums) {
                Arrays.sort(nums);
                int begin = 0;
                int res = 0;
                for (int end = 0; end < nums.length; end++) {
                    while (nums[end] - nums[begin] > 1) {
                        begin++;
                    }
                    if (nums[end] - nums[begin] == 1) {
                        res = Math.max(res, end - begin + 1);
                    }
                }
                return res;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)


}

//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
//
// 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
//
// 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,3,2,2,5,2,3,7]
//
//
// 输出：5
//
// 解释：
//
// 最长和谐子序列是 [3,2,2,2,3]。
//
// 示例 2：
//
//
// 输入：nums = [1,2,3,4]
//
//
// 输出：2
//
// 解释：
//
// 最长和谐子序列是 [1,2]，[2,3] 和 [3,4]，长度都为 2。
//
// 示例 3：
//
//
// 输入：nums = [1,1,1,1]
//
//
// 输出：0
//
// 解释：
//
// 不存在和谐子序列。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics 数组 哈希表 计数 排序 滑动窗口 👍 439 👎 0
