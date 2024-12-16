//283 移动零 move-zeroes
//2024-12-16 14:28:04

package com.lenyan.leetcode.editor.cn;


public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 去除 nums 中的所有 0，返回不含 0 的数组长度
            int p = removeElement(nums, 0);
            // 将 nums[p..] 的元素赋值为 0
            for (; p < nums.length; p++) {
                nums[p] = 0;
            }
        }

        public int removeElement(int[] nums, int val) {
            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}


////给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2507 👎 0
