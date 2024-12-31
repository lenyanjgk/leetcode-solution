//429 N 叉树的层序遍历 n-ary-tree-level-order-traversal
//2024-12-31 11:05:13

package com.lenyan.leetcode.editor.cn;


import com.lenyan.leetcode.editor.cn.model.Node;

import java.util.*;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
    }
    // Definition for a Node.
//    class Node {
//        public int val;
//        public List<Node> children;
//
//        public Node() {}
//
//        public Node(int _val) {
//            val = _val;
//        }
//
//        public Node(int _val, List<Node> _children) {
//            val = _val;
//            children = _children;
//        }
//    };
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) return Collections.emptyList(); // 修复点：检查 root 是否为 null
            List<List<Integer>> ans = new ArrayList<>();
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> vals = new ArrayList<>(n);
                while (n-- > 0) {
                    Node node = queue.poll();
                    vals.add(node.val);
                    if (node.children != null) { // 修复点：检查 node.children 是否为 null
                        for (Node child : node.children) {
                            if (child != null) {
                                queue.add(child);
                            }
                        }
                    }
                }
                ans.add(vals);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
}


////给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10⁴] 之间 
// 
//
// Related Topics 树 广度优先搜索 👍 481 👎 0
