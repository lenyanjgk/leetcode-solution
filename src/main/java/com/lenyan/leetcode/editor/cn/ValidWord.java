//3136 有效单词 valid-word
//2025-07-15 09:58:11

package com.lenyan.leetcode.editor.cn;

import static cn.hutool.poi.excel.sax.ElementName.c;

public class ValidWord {
    public static void main(String[] args) {
        Solution solution = new ValidWord().new Solution();
        System.out.println(solution.isValid("234Adas"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String word) {
            if (word.length() < 3) return false;

            boolean hasVowel = false;
            boolean hasConsonant = false;

            for (char c : word.toCharArray()) {
                if (!Character.isLetterOrDigit(c)) {
                    return false; // 包含非法字符
                }

                if (Character.isDigit(c)) {
                    continue; // 数字不参与元音/辅音判断
                }

                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) >= 0) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }

            return hasVowel && hasConsonant;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    
}