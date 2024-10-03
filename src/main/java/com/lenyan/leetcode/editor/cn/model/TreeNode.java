package com.lenyan.leetcode.editor.cn.model;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 从给定的整数数组创建二叉树
    public static TreeNode create(Integer[] integers) {
        if (integers == null || integers.length == 0) return null;
        List<TreeNode> nodes = new ArrayList<>();
        for (Integer i : integers) {
            if (i == null) nodes.add(null);
            else nodes.add(new TreeNode(i));
        }

        int n = nodes.size();
        for (int i = 0; i < n / 2; i++) {
            TreeNode node = nodes.get(i);
            if (node != null) {
                node.left = nodes.get(2 * i + 1);
                node.right = nodes.get(2 * i + 2);
            }
        }
        return nodes.get(0); // 返回根节点
    }

    // 获取二叉树的右侧视图
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) { // 只在每层的最后一个节点添加到结果列表
                    result.add(current.val);
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        TreeNode root = TreeNode.create(new Integer[]{1, 2, 3, null, 5, null, 4});
        List<Integer> view = TreeNode.rightSideView(root);
        System.out.println(view); // 输出 [1, 3, 4]
    }
}
