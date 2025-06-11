//238 除自身以外数组的乘积
//2024-09-28 14:59:10

package com.lenyan.leetcode.editor.cn;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //左右乘积前缀和
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] zuo = new int[n];
            int[] you = new int[n];
            zuo[0] = 1;
            you[n - 1] = 1;
            int[] ans = new int[n];
            for (int i = 1; i < n; i++) {
                zuo[i] = zuo[i - 1] * nums[i - 1];
            }

            for (int i = n - 2; i >= 0; i--) {
                you[i] = you[i + 1] * nums[i + 1];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = zuo[i] * you[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}