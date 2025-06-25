//2966  划分数组并满足最大差限制 divide-array-into-arrays-with-max-difference
//2025-06-18 09:24:05

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        Solution solution = new DivideArrayIntoArraysWithMaxDifference().new Solution();
    }
//贪心法，排序连续三个~
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][];
        for(int i = 2; i < n; i += 3) {
            if(nums[i] - nums[i-2] > k) {
                return new int[][]{};
            }
            ans[i/3] = new int[]{nums[i-2],nums[i-1],nums[i]};
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}

//给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
//
// 将这个数组划分为 n / 3 个长度为 3 的子数组，并满足以下条件：
//
//
// 子数组中 任意 两个元素的差必须 小于或等于 k 。
//
//
// 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,3,4,8,7,9,3,5,1], k = 2
//
//
// 输出：[[1,1,3],[3,4,5],[7,8,9]]
//
// 解释：
//
// 每个数组中任何两个元素之间的差小于或等于 2。
//
// 示例 2：
//
//
// 输入：nums = [2,4,2,2,5,2], k = 2
//
//
// 输出：[]
//
// 解释：
//
// 将 nums 划分为 2 个长度为 3 的数组的不同方式有：
//
//
// [[2,2,2],[2,4,5]] （及其排列）
// [[2,2,4],[2,2,5]] （及其排列）
//
//
// 因为有四个 2，所以无论我们如何划分，都会有一个包含元素 2 和 5 的数组。因为 5 - 2 = 3 > k，条件无法被满足，所以没有合法的划分。
//
// 示例 3：
//
//
// 输入：nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14
//
//
// 输出：[[2,2,12],[4,8,5],[5,9,7],[7,8,5],[5,9,10],[11,12,2]]
//
// 解释：
//
// 每个数组中任何两个元素之间的差小于或等于 14。
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 10⁵
// n 是 3 的倍数
// 1 <= nums[i] <= 10⁵
// 1 <= k <= 10⁵
//
//
// Related Topics 贪心 数组 排序 👍 13 👎 0
