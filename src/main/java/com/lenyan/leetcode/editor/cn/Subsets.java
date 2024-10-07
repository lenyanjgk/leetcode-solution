//78 子集
//2024-10-08 01:04:47

  package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets{
      public static void main(String[] args) {
           Solution solution = new Subsets().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
          LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
          public List<List<Integer>> subsets(int[] nums) {
              subsetsHelper(nums, 0);
              return result;
          }

          private void subsetsHelper(int[] nums, int startIndex){
              result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
              if (startIndex >= nums.length){ //终止条件可不加
                  return;
              }
              for (int i = startIndex; i < nums.length; i++){
                  path.add(nums[i]);
                  subsetsHelper(nums, i + 1);
                  path.removeLast();
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }

