//1900 最佳运动员的比拼回合 the-earliest-and-latest-rounds-where-players-compete
//2025-07-12 23:42:33

package com.lenyan.leetcode.editor.cn;

public class TheEarliestAndLatestRoundsWherePlayersCompete {
    public static void main(String[] args) {
        Solution solution = new TheEarliestAndLatestRoundsWherePlayersCompete().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][][] F = new int[30][30][30];
        private int[][][] G = new int[30][30][30];

        private int[] dp(int n, int f, int s) {
            if (F[n][f][s] != 0) {
                return new int[]{F[n][f][s], G[n][f][s]};
            }
            if (f + s == n + 1) {
                return new int[]{1, 1};
            }
            // F(n,f,s) = F(n, n + 1 - s, n + 1 - f)
            if (f + s > n + 1) {
                int[] res = dp(n, n + 1 - s, n + 1 - f);
                F[n][f][s] = res[0];
                G[n][f][s] = res[1];
                return new int[]{F[n][f][s], G[n][f][s]};
            }

            int earlist = Integer.MAX_VALUE, latest = Integer.MIN_VALUE;
            int n_half = (n + 1) / 2;
            if (s <= n_half) {
                // 在左侧或者中间
                for (int i = 0; i < f; ++i) {
                    for (int j = 0; j < s - f; ++j) {
                        int[] res = dp(n_half, i + 1, i + j + 2);
                        earlist = Math.min(earlist, res[0]);
                        latest = Math.max(latest, res[1]);
                    }
                }
            } else {
                // s 在右侧
                int s_prime = n + 1 - s;
                int mid = (n - 2 * s_prime + 1) / 2;
                for (int i = 0; i < f; ++i) {
                    for (int j = 0; j < s_prime - f; ++j) {
                        int[] res = dp(n_half, i + 1, i + j + mid + 2);
                        earlist = Math.min(earlist, res[0]);
                        latest = Math.max(latest, res[1]);
                    }
                }
            }

            F[n][f][s] = earlist + 1;
            G[n][f][s] = latest + 1;
            return new int[]{F[n][f][s], G[n][f][s]};
        }

        public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            // F(n,f,s) = F(n,s,f)
            if (firstPlayer > secondPlayer) {
                int temp = firstPlayer;
                firstPlayer = secondPlayer;
                secondPlayer = temp;
            }

            int[] res = dp(n, firstPlayer, secondPlayer);
            return new int[]{res[0], res[1]};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}