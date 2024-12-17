//383 赎金信 ransom-note
//2024-12-17 20:24:14

package com.lenyan.leetcode.editor.cn;


public class RansomNote{
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            // shortcut
            if (ransomNote.length() > magazine.length()) {
                return false;
            }
            // 定义一个哈希映射数组
            int[] record = new int[26];

            // 遍历
            for(char c : magazine.toCharArray()){
                record[c - 'a'] += 1;
            }

            for(char c : ransomNote.toCharArray()){
                record[c - 'a'] -= 1;
            }

            // 如果数组中存在负数，说明ransomNote字符串中存在magazine中没有的字符
            for(int i : record){
                if(i < 0){
                    return false;
                }
            }

            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
}


////给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 937 👎 0
