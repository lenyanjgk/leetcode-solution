//94 二叉树的中序遍历
//2024-10-03 01:59:40

  package com.lenyan.leetcode.editor.cn;

import com.lenyan.leetcode.editor.cn.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root,List<Integer> res) {
        if(root == null) {
            return ;
        }
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        public void dfs(TreeNode root,List<Integer> res) {
            if(root == null) {
                return ;
            }
            dfs(root.left, res);
            res.add(root.val);
            dfs(root.right, res);
        }
    }

  }