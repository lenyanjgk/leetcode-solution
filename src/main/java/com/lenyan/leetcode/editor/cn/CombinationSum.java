//39 组合总和
//2024-10-08 01:45:56

  package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum{
      public static void main(String[] args) {
           Solution solution = new CombinationSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<List<Integer>> combinationSum(int[] candidates, int target) {
              List<List<Integer>> res = new ArrayList<>();
              Arrays.sort(candidates); // 先进行排序
              backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
              return res;
          }

          public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
              // 找到了数字和为 target 的组合
              if (sum == target) {
                  res.add(new ArrayList<>(path));
                  return;
              }

              for (int i = idx; i < candidates.length; i++) {
                  // 如果 sum + candidates[i] > target 就终止遍历
                  if (sum + candidates[i] > target) break;
                  path.add(candidates[i]);
                  backtracking(res, path, candidates, target, sum + candidates[i], i);
                  path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }