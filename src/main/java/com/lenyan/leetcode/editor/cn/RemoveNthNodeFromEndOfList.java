//19 删除链表的倒数第 N 个结点
//2024-09-30 22:03:17

  package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.ListNode;

public class RemoveNthNodeFromEndOfList{
      public static void main(String[] args) {
           Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
//           输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
           ListNode node = new ListNode(1);
           node.next = new ListNode(2);
           node.next.next = new ListNode(3);
           node.next.next.next = new ListNode(4);
           node.next.next.next.next = new ListNode(5);
          ListNode listNode = solution.removeNthFromEnd(node, 2);
          System.out.println(listNode);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getLength(head);
        ListNode cur = dummy;
        for(int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while(head!=null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

  }