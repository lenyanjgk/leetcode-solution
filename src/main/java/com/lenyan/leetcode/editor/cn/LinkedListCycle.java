//141 环形链表
//2024-09-30 20:53:31

  package com.lenyan.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle{
      public static void main(String[] args) {
           Solution solution = new LinkedListCycle().new Solution();
      }
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }