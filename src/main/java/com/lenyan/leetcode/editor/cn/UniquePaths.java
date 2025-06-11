//62 不同路径 unique-paths
//2025-03-29 21:10:56

package com.lenyan.leetcode.editor.cn;


public class UniquePaths{
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
        }
        return ans[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
}


////一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// Related Topics 数学 动态规划 组合数学 👍 2209 👎 0
