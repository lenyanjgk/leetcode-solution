//3330  找到初始输入字符串 I find-the-original-typed-string-i
//2025-07-01 00:16:02

package com.lenyan.leetcode.editor.cn;

public class FindTheOriginalTypedStringI {
    public static void main(String[] args) {
        Solution solution = new FindTheOriginalTypedStringI().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int possibleStringCount(String word) {
                int n = word.length(), ans = 1;
                for (int i = 1; i < n; ++i) {
                    if (word.charAt(i - 1) == word.charAt(i)) {
                        ++ans;
                    }
                }
                return ans;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)


}

//Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
//
// 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
//
// 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
//
// 请你返回 Alice 一开始可能想要输入字符串的总方案数。
//
//
//
// 示例 1：
//
//
// 输入：word = "abbcccc"
//
//
// 输出：5
//
// 解释：
//
// 可能的字符串包括："abbcccc" ，"abbccc" ，"abbcc" ，"abbc" 和 "abcccc" 。
//
// 示例 2：
//
//
// 输入：word = "abcd"
//
//
// 输出：1
//
// 解释：
//
// 唯一可能的字符串是 "abcd" 。
//
// 示例 3：
//
//
// 输入：word = "aaaa"
//
//
// 输出：4
//
//
//
// 提示：
//
//
// 1 <= word.length <= 100
// word 只包含小写英文字母。
//
//
// Related Topics 字符串 👍 2 👎 0
