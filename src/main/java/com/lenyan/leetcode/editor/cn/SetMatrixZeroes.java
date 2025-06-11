//73 矩阵置零
//2024-09-29 10:21:43

package com.lenyan.leetcode.editor.cn;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetMatrixZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            boolean[] row = new boolean[m];
            boolean[] col = new boolean[n];
            // 标记需要置零的行和列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = col[j] = true;
                    }
                }
            }
            // 置零操作
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}
