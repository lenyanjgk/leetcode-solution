//3085  成为 K 特殊字符串需要删除的最少字符数 minimum-deletions-to-make-string-k-special
//2025-06-21 10:17:10

package com.lenyan.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionsToMakeStringKSpecial {
    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeStringKSpecial().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            /**
             * 计算使字符串中所有字符的出现次数满足条件所需的最小删除次数。
             * 条件为：对于选中的字符出现次数a，其他字符的出现次数b必须满足b <= a 或者 b <= a + k。
             *
             * @param word 给定的字符串
             * @param k 允许的额外删除次数，用于调整出现次数的上限
             * @return 最小删除次数
             */
            public int minimumDeletions(String word, int k) {
                // 统计每个字符在字符串中的出现次数
                Map<Character, Integer> cnt = new HashMap<>();
                for (char ch : word.toCharArray()) {
                    cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
                }

                // 初始化结果为最大可能删除次数（即整个字符串长度）
                int res = word.length();

                // 遍历每个字符的出现次数a，计算满足条件的最小删除次数
                for (int a : cnt.values()) {
                    int deleted = 0;
                    // 对于当前基准次数a，遍历所有字符的出现次数b：
                    // - 当b < a时，需删除所有b对应字符
                    // - 当b > a + k时，需删除超出(a + k)的部分
                    // - 当a <= b <= a + k时，无需删除
                    for (int b : cnt.values()) {
                        if (a > b) {
                            deleted += b;
                        } else if (b > a + k) {
                            deleted += b - (a + k);
                        }
                    }
                    // 更新全局最小删除次数
                    res = Math.min(res, deleted);
                }
                return res;
            }

        }
//leetcode submit region end(Prohibit modification and deletion)


}

//给你一个字符串 word 和一个整数 k。
//
// 如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j 都成立，则认为 word 是 k 特殊字
//符串。
//
// 此处，freq(x) 表示字符 x 在 word 中的出现频率，而 |y| 表示 y 的绝对值。
//
// 返回使 word 成为 k 特殊字符串 需要删除的字符的最小数量。
//
//
//
// 示例 1：
//
//
// 输入：word = "aabcaba", k = 0
//
//
// 输出：3
//
// 解释：可以删除 2 个 "a" 和 1 个 "c" 使 word 成为 0 特殊字符串。word 变为 "baba"，此时 freq('a') ==
//freq('b') == 2。
//
// 示例 2：
//
//
// 输入：word = "dabdcbdcdcd", k = 2
//
//
// 输出：2
//
// 解释：可以删除 1 个 "a" 和 1 个 "d" 使 word 成为 2 特殊字符串。word 变为 "bdcbdcdcd"，此时 freq('b')
//== 2，freq('c') == 3，freq('d') == 4。
//
// 示例 3：
//
//
// 输入：word = "aaabaaa", k = 2
//
//
// 输出：1
//
// 解释：可以删除 1 个 "b" 使 word 成为 2特殊字符串。因此，word 变为 "aaaaaa"，此时每个字母的频率都是 6。
//
//
//
// 提示：
//
//
// 1 <= word.length <= 10⁵
// 0 <= k <= 10⁵
// word 仅由小写英文字母组成。
//
//
// Related Topics 贪心 哈希表 字符串 计数 排序 👍 24 👎 0
