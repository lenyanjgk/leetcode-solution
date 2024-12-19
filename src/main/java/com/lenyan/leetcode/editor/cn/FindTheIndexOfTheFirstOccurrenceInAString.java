//28 找出字符串中第一个匹配项的下标 find-the-index-of-the-first-occurrence-in-a-string
//2024-12-19 18:55:59

package com.lenyan.leetcode.editor.cn;


public class FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String ss, String pp) {
            int n = ss.length(), m = pp.length();
            char[] s = ss.toCharArray(), p = pp.toCharArray();
            // 枚举原串的「发起点」
            for (int i = 0; i <= n - m; i++) {
                // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
                int a = i, b = 0;
                while (b < m && s[a] == p[b]) {
                    a++;
                    b++;
                }
                // 如果能够完全匹配，返回原串的「发起点」下标
                if (b == m) return i;
            }
            return -1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
}


////给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2332 👎 0
