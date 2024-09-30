//24 两两交换链表中的节点
//2024-09-30 22:12:21

  package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.ListNode;

public class SwapNodesInPairs{
      public static void main(String[] args) {
           Solution solution = new SwapNodesInPairs().new Solution();
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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }