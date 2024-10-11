//22 括号生成
//2024-10-12 00:57:26

  package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          private int n;
          private char[] path;
          private final List<String> ans = new ArrayList<>();

          public List<String> generateParenthesis(int n) {
              this.n = n;
              path = new char[n * 2];
              dfs(0, 0);
              return ans;
          }

          private void dfs(int i, int open) {
              if (i == n * 2) {
                  ans.add(new String(path));
                  return;
              }
              if (open < n) {
                  path[i] = '(';
                  dfs(i + 1, open + 1);
              }
              if (i - open < open) {
                  path[i] = ')';
                  dfs(i + 1, open);
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }