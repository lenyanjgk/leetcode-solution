//18 四数之和 4sum
//2024-12-18 13:29:50

package com.lenyan.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                if(nums[i] > target && nums[i] >= 0) break;
                if(i >0 && nums[i] == nums[i-1]) continue;
                for(int j = i + 1; j < nums.length - 2; j++) {
                    if(nums[j] + nums[i] > target && nums[j] + nums[i] >=0 ) break;
                    if(j > i + 1 && nums[j] == nums[j-1]) continue;
                    int left = j + 1;
                    int right = nums.length - 1;
                    while(left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if(sum > target) right--;
                        else if(sum < target) left++;
                        else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while(left < right && nums[left] == nums[left+1]) left++;
                            while(left < right && nums[right] == nums[right-1]) right--;
                            left++;
                            right--;
                        }
                    }
                }
            }
            return result;
        }

//        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[] nums = {1, 0, -1, 0, -2, 2};
//            int target = 0;
//            List<List<Integer>> results = solution.fourSum(nums, target);
//            for (List<Integer> result : results) {
//                System.out.println(result);
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}


////给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1996 👎 0
