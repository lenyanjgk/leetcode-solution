//189 轮转数组
//2024-09-28 14:26:31

  package com.lenyan.leetcode.editor.cn;
  public class RotateArray{
      public static void main(String[] args) {
           Solution solution = new RotateArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            ans[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(ans,0,nums,0,nums.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


      class Solution1 {
          public void rotate(int[] nums, int k) {
              int n = nums.length;
              k %= n; // 轮转 k 次等于轮转 k%n 次
              reverse(nums, 0, n - 1);
              reverse(nums, 0, k - 1);
              reverse(nums, k, n - 1);
          }

          private void reverse(int[] nums, int i, int j) {
              while (i < j) {
                  int temp = nums[i];
                  nums[i] = nums[j];
                  nums[j] = temp;
                  i++;
                  j--;
              }
          }
      }

  }