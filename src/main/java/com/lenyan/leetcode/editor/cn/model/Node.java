package com.lenyan.leetcode.editor.cn.model;

import java.util.List;

public class Node {
    public int val;
    public Node next;
    public Node random;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.children = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
        this.children = null;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.children = children;
    }
}
