//48 旋转图像
//2024-09-29 10:45:29

  package com.lenyan.leetcode.editor.cn;
  public class RotateImage{
      public static void main(String[] args) {
           Solution solution = new RotateImage().new Solution();
           //matrix = [[1,2,3],[4,5,6],[7,8,9]]
          //数组
          int[][] rotate = solution.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
          for (int[] ints : rotate) {
              for (int anInt : ints) {
                  System.out.print(anInt + " ");
              }
              System.out.println();
          }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[][] rotate(int[][] matrix) {
              int n = matrix.length;
              for(int i = 0; i < n/2; i++) {
                  for(int j = 0; j < (n+1) / 2; j++) {
                      int tmp = matrix[i][j];
                      matrix[i][j] = matrix[n-1-j][i];
                      matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                      matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                      matrix[j][n-1-i] = tmp;
                  }
              }
              return matrix;
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }