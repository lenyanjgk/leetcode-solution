//438 找到字符串中所有字母异位词
//2024-09-26 14:52:25

package com.lenyan.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int n = s.length(), m = p.length();
            if(n < m) {
                return new ArrayList<>();
            }
            List<Integer> ans = new ArrayList<>();
            int [] cnt1 = new int[26], cnt2 = new int[26];
            for(int i = 0; i < m; i++) {
                cnt1[s.charAt(i) - 'a']++;
                cnt2[p.charAt(i) - 'a']++;
            }
            if(Arrays.equals(cnt1, cnt2)) {
                ans.add(0);
            }
            for(int i = 0; i < n - m; i++) {
                cnt1[s.charAt(i) - 'a']--;
                cnt1[s.charAt(i + m) - 'a']++;
                if(Arrays.equals(cnt1, cnt2)) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}