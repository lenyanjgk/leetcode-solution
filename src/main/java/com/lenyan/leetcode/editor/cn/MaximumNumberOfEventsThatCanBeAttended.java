//1353 最多可以参加的会议数目 maximum-number-of-events-that-can-be-attended
//2025-07-07 23:46:14

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEventsThatCanBeAttended().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, (a, b) -> a[0] - b[0]); // 按开始时间排序
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 存储可参加会议的结束时间

            int i = 0, res = 0, n = events.length;

            // 找出所有会议的最晚结束时间
            int maxDay = 0;
            for (int[] e : events) {
                maxDay = Math.max(maxDay, e[1]);
            }

            // 从第1天遍历到最后一天
            for (int day = 1; day <= maxDay; day++) {
                while (i < n && events[i][0] == day) minHeap.offer(events[i++][1]); // 加入今天开始的会议
                while (!minHeap.isEmpty() && minHeap.peek() < day) minHeap.poll();  // 移除已过期会议
                if (!minHeap.isEmpty()) { // 参加最早结束的会议
                    minHeap.poll();
                    res++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}