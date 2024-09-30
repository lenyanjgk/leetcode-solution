//76 最小覆盖子串
//2024-09-27 15:02:01

  package com.lenyan.leetcode.editor.cn;
  public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public String minWindow(String S, String t) {
              char[] s = S.toCharArray();
              int m = s.length;
              int ansLeft = -1;
              int ansRight = m;
              int left = 0;
              int less = 0;
              int[] cntS = new int[128]; // s 子串字母的出现次数
              int[] cntT = new int[128]; // t 中字母的出现次数
              for (char c : t.toCharArray()) {
                  if (cntT[c]++ == 0) {
                      less++; // 有 less 种字母的出现次数 < t 中的字母出现次数
                  }
              }
              for (int right = 0; right < m; right++) { // 移动子串右端点
                  char c = s[right]; // 右端点字母（移入子串）
                  if (++cntS[c] == cntT[c]) {
                      less--; // c 的出现次数从 < 变成 >=
                  }
                  while (less == 0) { // 涵盖：所有字母的出现次数都是 >=
                      if (right - left < ansRight - ansLeft) { // 找到更短的子串
                          ansLeft = left; // 记录此时的左右端点
                          ansRight = right;
                      }
                      char x = s[left++]; // 左端点字母（移出子串）
                      if (cntS[x]-- == cntT[x]) {
                          less++; // x 的出现次数从 >= 变成 <
                      }
                  }
              }
              return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
          }
      }


//leetcode submit region end(Prohibit modification and deletion)

  }