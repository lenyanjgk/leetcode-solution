//239 滑动窗口最大值
//2024-09-27 10:54:59

  package com.lenyan.leetcode.editor.cn;

import java.util.ArrayDeque;

public class SlidingWindowMaximum{
      public static void main(String[] args) {
           Solution solution = new SlidingWindowMaximum().new Solution();
           //nums = [1,3,-1,-3,5,3,6,7], k = 3
          System.out.println(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[] maxSlidingWindow(int[] nums, int k) {
              ArrayDeque<Integer> deque = new ArrayDeque<>();
              int len = nums.length;
              int[] res = new int[len - k + 1];
              int idx = 0;
              for(int i = 0; i < len; i++) {
                  while(!deque.isEmpty() && deque.peek() < i-k+1) {
                      deque.poll();
                  }
                  while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                      deque.pollLast();
                  }
                  deque.offer(i);
                  if(i >= k - 1) {
                      res[idx++] = nums[deque.peek()];
                  }
              }
              return res;
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }