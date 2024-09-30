//3 无重复字符的最长子串
//2024-09-26 14:10:32

package com.lenyan.leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        //pwwkew
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> ans = new HashMap<>();
            int i = -1 ,res = 0;
            for(int j = 0; j < s.length(); j++) {
                if(ans.containsKey(s.charAt(j)))
                    i = Math.max(i,ans.get(s.charAt(j)));
                ans.put(s.charAt(j),j);
                res = Math.max(res,j-i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}