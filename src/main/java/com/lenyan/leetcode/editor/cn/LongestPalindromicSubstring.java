//5 最长回文子串 longest-palindromic-substring
//2024-12-16 14:55:38

package com.lenyan.leetcode.editor.cn;


public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isPalindromic(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }

        // 暴力解法
        public String longestPalindrome(String s) {
            String ans = "";
            int max = 0;
            int len = s.length();
            for (int i = 0; i < len; i++)
                for (int j = i + 1; j <= len; j++) {
                    String test = s.substring(i, j);
                    if (isPalindromic(test) && test.length() > max) {
                        ans = s.substring(i, j);
                        max = Math.max(max, ans.length());
                    }
                }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}


////给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7454 👎 0
