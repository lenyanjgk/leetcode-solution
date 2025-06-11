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
        int n = nums.length;
        int []presum = new int[n+1];
        presum[0] = 0;
        for(int i = 0; i < n; i++) {
            presum[i+1] = presum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (presum[j] - presum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }