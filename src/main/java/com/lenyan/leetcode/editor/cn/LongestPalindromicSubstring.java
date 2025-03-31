//5 最长回文子串 longest-palindromic-substring
//2024-12-16 14:55:38

package com.lenyan.leetcode.editor.cn;


public class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int maxLen = 0;
            int start = 0;

            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (j == i + 1) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    }

                    if (dp[i][j] && (j - i + 1 > maxLen)) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }

            return maxLen == 0 ? "" : s.substring(start, start + maxLen);
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
