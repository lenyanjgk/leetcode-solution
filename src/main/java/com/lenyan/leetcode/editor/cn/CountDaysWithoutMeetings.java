//3169 无需开会的工作日 count-days-without-meetings
//2025-07-11 13:54:12

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class CountDaysWithoutMeetings {
    public static void main(String[] args) {
        Solution solution = new CountDaysWithoutMeetings().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int usedDays = 0;
        int start = meetings[0][0], end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            int[] current = meetings[i];
            if (current[0] <= end + 1) {
                end = Math.max(end, current[1]);
            } else {
                usedDays += end - start + 1;
                start = current[0];
                end = current[1];
            }
        }
        usedDays += end - start + 1;
        return days - usedDays;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

    
}