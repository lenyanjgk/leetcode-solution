//56 合并区间
//2024-09-28 14:03:30

  package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals{
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] pre = intervals[0];
        int k = 0;
        for(int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if(cur[0] <= pre[1]) {
                int e = Math.max(pre[1],cur[1]);
                pre = new int[]{pre[0],e};
            } else {
                intervals[k++] = pre;
                pre = cur;
            }
        }
        intervals[k++] = pre;
        return  Arrays.copyOf(intervals,k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }