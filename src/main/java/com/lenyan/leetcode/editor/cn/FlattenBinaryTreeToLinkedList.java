//114 二叉树展开为链表
//2024-10-04 17:47:38

package com.lenyan.leetcode.editor.cn;
import com.lenyan.leetcode.editor.cn.model.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            while(root != null) {
                if(root.left == null) {
                    root = root.right;
                } else {
                    TreeNode pre = root.left;
                    while(pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = root.right;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}