//23 合并 K 个升序链表
//2024-10-02 22:17:14

package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        ListNode listNode = solution.mergeKLists(lists);
        System.out.println(listNode);

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
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> deque =  new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
            for(ListNode tmp : lists) {
                if(tmp != null)
                deque.offer(tmp);
            }

            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while(!deque.isEmpty()) {
                ListNode minNode = deque.poll();
                tail.next = minNode;
                tail = minNode;
                if(minNode.next != null) {
                    deque.offer(minNode.next);
                }
            }
            return dummyHead.next;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode ans = null;
            for (ListNode node : lists) {
                ans = mergeTwoLists(ans, node);
            }
            return ans;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 != null ? l1 : l2;
            return dummy.next;
        }
    }

}



