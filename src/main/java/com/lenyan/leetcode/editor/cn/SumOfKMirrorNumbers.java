//2081  k 镜像数字的和 sum-of-k-mirror-numbers
//2025-06-23 08:45:13

package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfKMirrorNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfKMirrorNumbers().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
// LeetCode 2081题解决方案：k镜像数字的和
class Solution {
    // 最大需求量（题目限制n<=30）
    private static final int MAX_N = 30;
    // 存储各进制(k)对应的结果列表（k∈[2,9]）
    private final List<Long>[] ans = new ArrayList[10];
    // 初始化标记
    private boolean initialized = false;

    // 延迟初始化方法（替代静态代码块，提升性能）
    private void init() {
        if (initialized) return;
        initialized = true;

        // 初始化每个k的列表
        Arrays.setAll(ans, i -> new ArrayList<>());

        // 生成不同长度的回文数候选
        for (int base = 1; ; base *= 10) {
            // 奇数长度回文生成（如base=10时生成101~999）
            for (int i = base; i < base * 10; i++) {
                long x = i;
                // 构建回文数（保留前半部分并镜像后半部分）
                for (int t = i / 10; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                if (doPalindrome(x)) return; // 检查并收集符合条件的数
            }

            // 偶数长度回文生成（如base=10时生成1001~9999）
            for (int i = base; i < base * 10; i++) {
                long x = i;
                // 构建完整镜像
                for (int t = i; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                if (doPalindrome(x)) return;
            }
        }
    }

    // 检查x是否满足所有k进制要求
    private boolean doPalindrome(long x) {
        boolean done = true;
        for (int k = 2; k < 10; k++) {
            // 收集未满且满足条件的数
            if (ans[k].size() < MAX_N && isKPalindrome(x, k)) {
                ans[k].add(x);
            }
            if (ans[k].size() < MAX_N) {
                done = false; // 只要有一个k未满则继续
            }
        }
        if (!done) return false;

        // 所有k收集完成时计算前缀和
        for (int k = 2; k < 10; k++) {
            List<Long> s = ans[k];
            for (int i = 1; i < MAX_N; i++) {
                s.set(i, s.get(i) + s.get(i - 1)); // 原地累加
            }
        }
        return true;
    }

    // 判断x在k进制下是否为回文
    private boolean isKPalindrome(long x, int k) {
        if (x % k == 0) return false; // 排除以0结尾的情况（含前导0）
        int rev = 0;
        while (rev < x / k) {
            rev = rev * k + (int)(x % k); // 反转低位到高位
            x /= k;
        }
        return rev == x || rev == x / k; // 奇偶长度处理
    }

    // 主调用接口：返回第k进制前n小的和
    public long kMirror(int k, int n) {
        init(); // 首次调用触发初始化
        return ans[k].get(n - 1); // 直接返回预计算的前缀和
    }
}

//leetcode submit region end(Prohibit modification and deletion)


}

//一个 k 镜像数字 指的是一个在十进制和 k 进制下从前往后读和从后往前读都一样的 没有前导 0 的 正 整数。
//
//
// 比方说，9 是一个 2 镜像数字。9 在十进制下为 9 ，二进制下为 1001 ，两者从前往后读和从后往前读都一样。
// 相反地，4 不是一个 2 镜像数字。4 在二进制下为 100 ，从前往后和从后往前读不相同。
//
//
// 给你进制 k 和一个数字 n ，请你返回 k 镜像数字中 最小 的 n 个数 之和 。
//
//
//
// 示例 1：
//
// 输入：k = 2, n = 5
//输出：25
//解释：
//最小的 5 个 2 镜像数字和它们的二进制表示如下：
//  十进制       二进制
//    1          1
//    3          11
//    5          101
//    7          111
//    9          1001
//它们的和为 1 + 3 + 5 + 7 + 9 = 25 。
//
//
// 示例 2：
//
// 输入：k = 3, n = 7
//输出：499
//解释：
//7 个最小的 3 镜像数字和它们的三进制表示如下：
//  十进制       三进制
//    1          1
//    2          2
//    4          11
//    8          22
//    121        11111
//    151        12121
//    212        21212
//它们的和为 1 + 2 + 4 + 8 + 121 + 151 + 212 = 499 。
//
//
// 示例 3：
//
// 输入：k = 7, n = 17
//输出：20379000
//解释：17 个最小的 7 镜像数字分别为：
//1, 2, 3, 4, 5, 6, 8, 121, 171, 242, 292, 16561, 65656, 2137312, 4602064, 65979
//56, 6958596
//
//
//
//
// 提示：
//
//
// 2 <= k <= 9
// 1 <= n <= 30
//
//
// Related Topics 数学 枚举 👍 34 👎 0
