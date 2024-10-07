//46 全排列
//2024-10-08 00:58:17

  package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations{
      public static void main(String[] args) {
           Solution solution = new Permutations().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          List<List<Integer>> ans = new ArrayList<>();
          LinkedList<Integer> path = new LinkedList<>();
          boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) {
            return ans;
        }
        used = new boolean[nums.length];
        backTrack(nums);
        return ans;
    }
    private void backTrack(int[] nums) {
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTrack(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }


