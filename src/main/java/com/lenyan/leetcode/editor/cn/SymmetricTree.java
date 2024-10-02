//101 对称二叉树
//2024-10-03 03:15:11

package com.lenyan.leetcode.editor.cn;
import com.lenyan.leetcode.editor.cn.model.TreeNode
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return check(root,root);
        }
        public boolean check(TreeNode p ,TreeNode q) {
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;
            return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}