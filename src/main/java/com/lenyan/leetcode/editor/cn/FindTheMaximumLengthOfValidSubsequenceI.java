//3201 找出有效子序列的最大长度 I find-the-maximum-length-of-valid-subsequence-i
//2025-07-16 09:24:01

package com.lenyan.leetcode.editor.cn;

public class FindTheMaximumLengthOfValidSubsequenceI {
    public static void main(String[] args) {
        Solution solution = new FindTheMaximumLengthOfValidSubsequenceI().new Solution();
        System.out.println(solution.maximumLength(new int[]{1,2,3,4}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums) {
            //偶数个偶数 奇数个奇数
            int n = nums.length;
            int ou = 0, ji = 0,res=0;
            for(int i = 0; i < nums.length - 1;i++) {
                if(nums[i] %2 ==0) ou++;
                else ji ++;
                if(nums[i] %2 != nums[i+1] %2) res ++;
            }
            //特判一下
            if (nums[n - 1] % 2 == 0) ou ++;
            else ji++;
            //返回
            return Math.max(Math.max(ji,ou),res+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}