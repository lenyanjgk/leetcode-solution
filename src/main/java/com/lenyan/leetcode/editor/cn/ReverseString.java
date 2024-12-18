//344 反转字符串 reverse-string
//2024-12-18 13:50:43

package com.lenyan.leetcode.editor.cn;


public class ReverseString{
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
        solution.reverseString(new char[]{'h','e','l','l','o'});
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int l = 0;
            int r = s.length - 1;
            while (l < r) {
                s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
                s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
                s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
                l++;
                r--;
            }
            System.out.println(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //简单：
//    class Solution {
//        public void reverseString(char[] s) {
//            int l = 0;
//            int r = s.length - 1;
//            while(l < r){
//                char temp = s[l];
//                s[l] = s[r];
//                s[r] = temp;
//                l++;
//                r--;
//            }
//        }
//    }


}


////编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 都是 ASCII 码表中的可打印字符 
// 
//
// Related Topics 双指针 字符串 👍 925 👎 0
