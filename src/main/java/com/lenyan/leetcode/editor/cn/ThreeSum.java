//15 三数之和
//2024-09-26 00:28:43

  package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) return ans;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0) {
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while(l < r && nums[r] == nums[r-1]) r--;
                    while(l > r && nums[l] == nums[l+1]) l++;
                    r--;
                    l++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }