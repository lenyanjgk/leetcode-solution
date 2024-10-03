<p>给你二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>层序遍历</strong> 。 （即逐层地，从左到右访问所有节点）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" /> 
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>[[3],[9,20],[15,7]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[[1]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[0, 2000]</code> 内</li> 
 <li><code>-1000 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 广度优先搜索 | 二叉树</details><br>

<div>👍 2022, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这题没啥可说的，[二叉树的递归/层序遍历](https://labuladong.online/algo/data-structure-basic/binary-tree-traverse-basic/) 遍历中介绍了三种层序（BFS）遍历的写法，任写一种都可以。

</div>

**标签：[BFS 算法](https://labuladong.online/algo/)，[二叉树](https://labuladong.online/algo/)**

<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

#include <vector>
#include <queue>

class Solution {
public:
    std::vector<std::vector<int>> levelOrder(TreeNode* root) {
        std::vector<std::vector<int>> res;
        if (root == nullptr) {
            return res;
        }

        std::queue<TreeNode*> q;
        q.push(root);
        // while 循环控制从上向下一层层遍历
        while (!q.empty()) {
            int sz = q.size();
            // 记录这一层的节点值
            std::vector<int> level;
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode* cur = q.front();
                q.pop();
                level.push_back(cur->val);
                if (cur->left != nullptr)
                    q.push(cur->left);
                if (cur->right != nullptr)
                    q.push(cur->right);
            }
            res.push_back(level);
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        if root is None:
            return res

        q = deque()
        q.append(root)
        # while 循环控制从上向下一层层遍历
        while q:
            sz = len(q)
            # 记录这一层的节点值
            level = []
            # for 循环控制每一层从左向右遍历
            for i in range(sz):
                cur = q.popleft()
                level.append(cur.val)
                if cur.left is not None:
                    q.append(cur.left)
                if cur.right is not None:
                    q.append(cur.right)
            res.append(level)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 记录这一层的节点值
            List<Integer> level = new LinkedList<>();
            // for 循环控制每一层从左向右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            res.add(level);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func levelOrder(root *TreeNode) [][]int {
    var res [][]int
    if root == nil {
        return res
    }

    q := []*TreeNode{root}
    // while 循环控制从上向下一层层遍历
    for len(q) > 0 {
        sz := len(q)
        // 记录这一层的节点值
        level := make([]int, sz)
        // for 循环控制每一层从左向右遍历
        for i := 0; i < sz; i++ {
            cur := q[0]
            q = q[1:]
            level[i] = cur.Val
            if cur.Left != nil {
                q = append(q, cur.Left)
            }
            if cur.Right != nil {
                q = append(q, cur.Right)
            }
        }
        res = append(res, level)
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var levelOrder = function(root) {
    let res = [];
    if (!root) {
        return res;
    }

    let q = [];
    q.push(root);
    // while 循环控制从上向下一层层遍历
    while (q.length > 0) {
        let sz = q.length;
        // 记录这一层的节点值
        let level = [];
        // for 循环控制每一层从左向右遍历
        for (let i = 0; i < sz; i++) {
            let cur = q.shift();
            level.push(cur.val);
            if (cur.left)
                q.push(cur.left);
            if (cur.right)
                q.push(cur.right);
        }
        res.push(level);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_binary-tree-level-order-traversal" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-level-order-traversal"></div></div>
</details><hr /><br />

**类似题目**：
  - [103. 二叉树的锯齿形层序遍历 🟠](/problems/binary-tree-zigzag-level-order-traversal)
  - [107. 二叉树的层序遍历 II 🟠](/problems/binary-tree-level-order-traversal-ii)
  - [1161. 最大层内元素和 🟠](/problems/maximum-level-sum-of-a-binary-tree)
  - [1302. 层数最深叶子节点的和 🟠](/problems/deepest-leaves-sum)
  - [1609. 奇偶树 🟠](/problems/even-odd-tree)
  - [429. N 叉树的层序遍历 🟠](/problems/n-ary-tree-level-order-traversal)
  - [637. 二叉树的层平均值 🟢](/problems/average-of-levels-in-binary-tree)
  - [919. 完全二叉树插入器 🟠](/problems/complete-binary-tree-inserter)
  - [958. 二叉树的完全性检验 🟠](/problems/check-completeness-of-a-binary-tree)
  - [剑指 Offer 32 - I. 从上到下打印二叉树 🟠](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof)
  - [剑指 Offer 32 - II. 从上到下打印二叉树 II 🟢](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof)
  - [剑指 Offer 32 - III. 从上到下打印二叉树 III 🟠](/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof)

</div>

</details>
</div>

