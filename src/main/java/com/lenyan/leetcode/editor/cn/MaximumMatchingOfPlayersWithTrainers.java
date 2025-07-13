//2410 运动员和训练师的最大匹配数 maximum-matching-of-players-with-trainers
//2025-07-13 10:47:49

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {
    public static void main(String[] args) {
        Solution solution = new MaximumMatchingOfPlayersWithTrainers().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);

            int count = 0;
            int i = 0, j = 0;
            int m = players.length, n = trainers.length;

            while (i < m && j < n) {
                if (players[i] <= trainers[j]) {
                    count++;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }

            return count;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
}