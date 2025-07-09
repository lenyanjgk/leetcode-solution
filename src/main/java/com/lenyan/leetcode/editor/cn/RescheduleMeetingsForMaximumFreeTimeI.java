//3439 重新安排会议得到最多空余时间 I reschedule-meetings-for-maximum-free-time-i
//2025-07-09 09:16:25

package com.lenyan.leetcode.editor.cn;

public class RescheduleMeetingsForMaximumFreeTimeI {
    public static void main(String[] args) {
        Solution solution = new RescheduleMeetingsForMaximumFreeTimeI().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            int n = startTime.length;
            int[] free = new int[n + 1];
            free[0] = startTime[0]; // 最左边的空余时间段
            for (int i = 1; i < n; i++) {
                free[i] = startTime[i] - endTime[i - 1]; // 中间的空余时间段
            }
            free[n] = eventTime - endTime[n - 1]; // 最右边的空余时间段

            // 套定长滑窗模板（窗口长为 k+1）
            int ans = 0;
            int s = 0;
            for (int i = 0; i <= n; i++) {
                s += free[i];
                if (i < k) {
                    continue;
                }
                ans = Math.max(ans, s);
                s -= free[i - k];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}