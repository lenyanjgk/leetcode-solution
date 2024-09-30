//42 接雨水
//2024-09-26 01:10:04

  package com.lenyan.leetcode.editor.cn;
  public class TrappingRainWater{
      public static void main(String[] args) {
           Solution solution = new TrappingRainWater().new Solution();
           System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int l = 0,r = height.length-1;
        int lm = 0,rm = 0;
        while(l < r) {
            lm = Math.max(lm,height[l]);
            rm = Math.max(rm,height[r]);
            if(lm < rm) {
                ans += lm - height[l];
                l++;
            } else {
                ans += rm - height[r];
                r--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }