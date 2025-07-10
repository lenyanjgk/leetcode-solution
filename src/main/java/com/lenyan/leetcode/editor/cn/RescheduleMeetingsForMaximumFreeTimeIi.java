//3440 重新安排会议得到最多空余时间 II reschedule-meetings-for-maximum-free-time-ii
//2025-07-10 12:42:27

package com.lenyan.leetcode.editor.cn;

public class RescheduleMeetingsForMaximumFreeTimeIi {
    public static void main(String[] args) {
        Solution solution = new RescheduleMeetingsForMaximumFreeTimeIi().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
            int n = startTime.length;
            boolean[] q = new boolean[n];
            for (int i = 0, t1 = 0, t2 = 0; i < n; i++) {
                if (endTime[i] - startTime[i] <= t1) {
                    q[i] = true;
                }
                t1 = Math.max(t1, startTime[i] - (i == 0 ? 0 : endTime[i - 1]));

                if (endTime[n - i - 1] - startTime[n - i - 1] <= t2) {
                    q[n - i - 1] = true;
                }
                t2 = Math.max(t2, (i == 0 ? eventTime : startTime[n - i]) - endTime[n - i - 1]);
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                int left = i == 0 ? 0 : endTime[i - 1];
                int right = i == n - 1 ? eventTime : startTime[i + 1];
                if (q[i]) {
                    res = Math.max(res, right - left);
                } else {
                    res = Math.max(res, right - left - (endTime[i] - startTime[i]));
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}