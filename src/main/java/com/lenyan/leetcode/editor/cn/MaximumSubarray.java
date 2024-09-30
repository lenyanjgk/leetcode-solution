//53 最大子数组和
//2024-09-28 13:02:43

  package com.lenyan.leetcode.editor.cn;
  public class MaximumSubarray{
      public static void main(String[] args) {
           Solution solution = new MaximumSubarray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num : nums) {
            if(sum>0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }