//234 回文链表
//2024-09-30 20:35:44

  package com.lenyan.leetcode.editor.cn;
  public class PalindromeLinkedList{
      public static void main(String[] args) {
           Solution solution = new PalindromeLinkedList().new Solution();
      }
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    ListNode root;

    public boolean isPalindrome(ListNode head) {
        this.root = head;
        return check(head.next);
    }

    private boolean check(ListNode head) {
        if(head == null) return true;
        if(head == root) return true;
        boolean res = check(head.next) && (root.val == head.val);
        root = root.next;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }