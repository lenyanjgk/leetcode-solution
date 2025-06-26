//2311  小于等于 K 的最长二进制子序列 longest-binary-subsequence-less-than-or-equal-to-k
//2025-06-26 08:58:45

package com.lenyan.leetcode.editor.cn;

public class LongestBinarySubsequenceLessThanOrEqualToK {
    public static void main(String[] args) {
        Solution solution = new LongestBinarySubsequenceLessThanOrEqualToK().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 计算最长子序列长度，使其二进制值≤k
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int m = 32 - Integer.numberOfLeadingZeros(k); // 获取k的二进制位数

        if(n < m) return n; // 长度不足直接返回全选

        int sufval = Integer.parseInt(s.substring(n-m), 2); // 计算末尾m位数值
        int ans = sufval <= k ? m : m - 1; // 初始结果取m或m-1

        // 累加前面所有'0'的数量（前导0不影响数值）
        for(int i = 0; i < n - m; i++) {
            ans += '1' - s.charAt(i); // '1'-char得到0/1的差值
        }

        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)


}

//给你一个二进制字符串 s 和一个正整数 k 。
//
// 请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。
//
// 注意：
//
//
// 子序列可以有 前导 0 。
// 空字符串视为 0 。
// 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
//
//
//
//
// 示例 1：
//
//
//输入：s = "1001010", k = 5
//输出：5
//解释：s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
//注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
//最长子序列的长度为 5 ，所以返回 5 。
//
//
// 示例 2：
//
//
//输入：s = "00101001", k = 1
//输出：6
//解释："000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
//最长子序列的长度为 6 ，所以返回 6 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 要么是 '0' ，要么是 '1' 。
// 1 <= k <= 10⁹
//
//
// Related Topics 贪心 记忆化搜索 字符串 动态规划 👍 47 👎 0
