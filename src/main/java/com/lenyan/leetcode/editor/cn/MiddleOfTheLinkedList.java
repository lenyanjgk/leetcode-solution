//876 链表的中间结点 middle-of-the-linked-list
//2024-12-15 10:07:13

package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.ListNode;

public class MiddleOfTheLinkedList{
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        System.out.println(solution.middleNode(ListNode.create(new int[]{1,2,3,4,5,6})).val);
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
    public ListNode middleNode(ListNode head) {
        int length = getLength(head);
        int temp = length / 2;
        while(temp-- > 0) {
            head = head.next;
        }
        return head;
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


////给你单链表的头结点 head ，请你找出并返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[3,4,5]
//解释：链表只有一个中间结点，值为 3 。
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2,3,4,5,6]
//输出：[4,5,6]
//解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 链表的结点数范围是 [1, 100] 
// 1 <= Node.val <= 100 
// 
//
// Related Topics 链表 双指针 👍 1033 👎 0
