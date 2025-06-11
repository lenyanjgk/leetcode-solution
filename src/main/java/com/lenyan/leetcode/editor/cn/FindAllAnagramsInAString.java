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
            if(n<m) return new ArrayList<>();
            int[] cnt = new int[26];
            int[] cntP = new int[26];
            for(int i=0;i<m;i++){
                cnt[s.charAt(i)-'a']++;
                cntP[p.charAt(i)-'a']++;
            }
            List<Integer> ans = new ArrayList<>();
            if(Arrays.equals(cnt,cntP)) ans.add(0);
            for(int i=m;i<n;i++){
                cnt[s.charAt(i)-'a']++;
                cnt[s.charAt(i-m)-'a']--;
                if(Arrays.equals(cnt,cntP)) ans.add(i-m+1);
            }
            return ans;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}