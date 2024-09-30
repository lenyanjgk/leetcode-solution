//560 和为 K 的子数组
//2024-09-27 10:34:05

  package com.lenyan.leetcode.editor.cn;
  public class SubarraySumEqualsK{
      public static void main(String[] args) {
           Solution solution = new SubarraySumEqualsK().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] presum = new int[len + 1];
        presum[0] = 0;
        for(int i = 1; i <= len; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                if(presum[i] - presum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }