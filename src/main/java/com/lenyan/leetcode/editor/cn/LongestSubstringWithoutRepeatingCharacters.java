//3 无重复字符的最长子串
//2024-09-26 14:10:32

package com.lenyan.leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        //pwwkew
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            List<Character> list = new ArrayList();
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                //如果集合中已包含了该字符，则从集合中删除该字符及之前的全部字符
                while (list.contains(s.charAt(i))) {
                    list.remove(0);
                }
                list.add(s.charAt(i));
                //每次添加字符串，就重新判断最大长度
                max = Math.max(max, list.size());
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}