//25 K 个一组翻转链表
//2024-09-30 22:25:47

package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode tail = dummy;
            while(true) {
                int count = 0;
                while(tail != null && count != k) {
                    count ++;
                    tail = tail.next;
                }
                if(tail == null) break;
                ListNode head1 = pre.next;
                while(pre.next != tail) {
                    ListNode next = pre.next;
                    pre.next = next.next;
                    next.next = tail.next;
                    tail.next = next;
                }
                pre = head1;
                tail = head1;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}