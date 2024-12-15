package com.lenyan.leetcode.editor.cn.model;

/**
 * @Program: leetcode-solution   //名称
 * @ClassName : ListNode  //类名
 * @Author: lenyan   /作者
 * @Date: 2024/9/30  20:58
 **/

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * 创建一个链表
     * @param arr 整数数组
     * @return 链表的头节点
     */
    public static ListNode create(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }
}
