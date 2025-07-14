//1290 二进制链表转整数 convert-binary-number-in-a-linked-list-to-integer
//2025-07-14 09:17:22

package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        Solution solution = new ConvertBinaryNumberInALinkedListToInteger().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Solution类提供了一种将链表表示的二进制数转换为十进制数的方法
 */
class Solution {
    /**
     * 将链表代表的二进制数转换为十进制数
     *
     * @param head 链表的头节点，链表中的每个节点包含一个二进制位（0或1）
     * @return 链表代表的二进制数对应的十进制值
     */
    public int getDecimalValue(ListNode head) {
        int result = 0; // 初始化结果变量为0，用于累加每个二进制位的十进制值
        while (head != null) { // 遍历链表，直到到达尾部（即节点为null）
            result = result * 2 + head.val; // 将当前结果乘以2，然后加上当前节点的值
            head = head.next; // 移动到下一个节点，处理下一位二进制数
        }
        return result; // 返回最终计算出的十进制数
    }
}

//leetcode submit region end(Prohibit modification and deletion)

    
}