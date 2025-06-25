//2616  最小化数对的最大差值 minimize-the-maximum-difference-of-pairs
//2025-06-13 09:37:17

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class MinimizeTheMaximumDifferenceOfPairs {
    public static void main(String[] args) {
        Solution solution = new MinimizeTheMaximumDifferenceOfPairs().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int minimizeMax(int[] nums, int p) {
                Arrays.sort(nums);
                int left = -1;
                int right = nums[nums.length - 1] - nums[0];
                while (left + 1 < right) {
                    int mid = (left + right) >>> 1;
                    if (check(mid, nums, p)) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                return right;
            }

            private boolean check(int mx, int[] nums, int p) {
                int cnt = 0;
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i + 1] - nums[i] <= mx) { // 选 nums[i] 和 nums[i+1]
                        cnt++;
                        i++;
                    }
                }
                return cnt >= p;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个下标从 0 开始的整数数组 nums 和一个整数 p 。请你从 nums 中找到 p 个下标对，每个下标对对应数值取差值，你需要使得这 p 个差值的
// 最大值 最小。同时，你需要确保每个下标在这 p 个下标对中最多出现一次。
//
// 对于一个下标对 i 和 j ，这一对的差值为 |nums[i] - nums[j]| ，其中 |x| 表示 x 的 绝对值 。
//
// 请你返回 p 个下标对对应数值 最大差值 的 最小值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,1,2,7,1,3], p = 2
//输出：1
//解释：第一个下标对选择 1 和 4 ，第二个下标对选择 2 和 5 。
//最大差值为 max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1 。所以我们返回 1
//。
//
//
// 示例 2：
//
//
//输入：nums = [4,2,1,2], p = 1
//输出：0
//解释：选择下标 1 和 3 构成下标对。差值为 |2 - 2| = 0 ，这是最大差值的最小值。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁹
// 0 <= p <= (nums.length)/2
//
//
// Related Topics 贪心 数组 二分查找 👍 58 👎 0
