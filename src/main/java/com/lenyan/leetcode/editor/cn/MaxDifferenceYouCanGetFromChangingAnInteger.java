//1432  改变一个整数能得到的最大差值 max-difference-you-can-get-from-changing-an-integer
//2025-06-15 09:25:57

package com.lenyan.leetcode.editor.cn;

public class MaxDifferenceYouCanGetFromChangingAnInteger {
    public static void main(String[] args) {
        Solution solution = new MaxDifferenceYouCanGetFromChangingAnInteger().new Solution();
        System.out.println(solution.maxDiff(123456));
        System.out.println(solution.maxDiff(555));
        System.out.println(solution.maxDiff(9288));
    }

        //leetcode submit region begin(Prohibit modification and deletion)
        public class Solution {
            public int maxDiff(int num) {
                String s = String.valueOf(num);

                // 构造最大值：替换第一个非9字符为9
                String maxStr = s;
                for (char c : s.toCharArray()) {
                    if (c != '9') {
                        maxStr = s.replace(c, '9');
                        break;
                    }
                }

                // 构造最小值：优先让首字符变1，否则让后续非0字符变0
                String minStr = s;
                if (s.charAt(0) != '1') {
                    // 首字符替换为1
                    char firstChar = s.charAt(0);
                    minStr = s.replace(firstChar, '1');
                } else {
                    // 查找后续可替换为0的字符（非1且>0）
                    boolean found = false;
                    char toReplace = ' ';
                    for (int i = 1; i < s.length(); i++) {
                        if (s.charAt(i) != s.charAt(0) && s.charAt(i) > '0') {
                            toReplace = s.charAt(i);
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        minStr = s.replace(toReplace, '0');
                    }
                }

                return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
            }
        }
//leetcode submit region end(Prohibit modification and deletion)


}

//给你一个整数 num 。你可以对它进行以下步骤共计 两次：
//
//
// 选择一个数字 x (0 <= x <= 9).
// 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
// 将 num 中所有出现 x 的数位都用 y 替换。
//
//
// 令两次对 num 的操作得到的结果分别为 a 和 b 。
//
// 请你返回 a 和 b 的 最大差值 。
//
// 注意，新的整数（a 或 b）必须不能 含有前导 0，并且 非 0。
//
//
//
// 示例 1：
//
//
//输入：num = 555
//输出：888
//解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
//第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
//现在，我们有 a = 999 和 b = 111 ，最大差值为 888
//
//
// 示例 2：
//
//
//输入：num = 9
//输出：8
//解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
//第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
//现在，我们有 a = 9 和 b = 1 ，最大差值为 8
//
//
// 示例 3：
//
//
//输入：num = 123456
//输出：820000
//
//
// 示例 4：
//
//
//输入：num = 10000
//输出：80000
//
//
// 示例 5：
//
//
//输入：num = 9288
//输出：8700
//
//
//
//
// 提示：
//
//
// 1 <= num <= 10^8
//
//
// Related Topics 贪心 数学 👍 29 👎 0
