//541 反转字符串 II reverse-string-ii
//2024-12-18 14:00:18

package com.lenyan.leetcode.editor.cn;


public class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            for(int i = 0; i < ch.length; i += 2 * k) {
                int start = i;
                int end = Math.min(i + k, ch.length);
                while(start < end - 1) {
                    char temp = ch[start];
                    ch[start] = ch[end - 1];
                    ch[end - 1] = temp;
                    start++;
                    end--;
                }
            }
            return new String(ch);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


////给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 623 👎 0
