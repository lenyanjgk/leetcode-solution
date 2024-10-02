<p>给定一个二叉树 <code>root</code> ，返回其最大深度。</p>

<p>二叉树的 <strong>最大深度</strong> 是指从根节点到最远叶子节点的最长路径上的节点数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/tmp-tree.jpg" style="width: 400px; height: 277px;" /></p>

<p>&nbsp;</p>

<pre>
<b>输入：</b>root = [3,9,20,null,null,15,7]
<b>输出：</b>3
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>root = [1,null,2]
<b>输出：</b>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数量在&nbsp;<code>[0, 10<sup>4</sup>]</code>&nbsp;区间内。</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉树</details><br>

<div>👍 1874, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[二叉树/递归的框架思维（纲领篇）](https://www.bilibili.com/video/BV1nG411x77H)

[我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树问题虽然简单，但是暗含了动态规划和回溯算法等高级算法的思想。

下面提供两种思路的解法代码。

**详细题解：[二叉树系列算法核心纲领](https://labuladong.online/algo/essential-technique/binary-tree-summary/)**

</div>

**标签：[二叉树](https://labuladong.online/algo/)，[动态规划](https://labuladong.online/algo/)，[回溯算法](https://labuladong.online/algo/)**

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

// **** 解法一，回溯算法思路 ****
class Solution {

public:
    int depth = 0;
    int res = 0;

    int maxDepth(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = max(res, depth);
        traverse(root->left);
        traverse(root->right);
        // 后序遍历位置
        depth--;
    }
};

// **** 解法二，动态规划思路 ****
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
public:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

# **** 解法一，回溯算法思路 ****
class Solution:
    def __init__(self):
        self.depth = 0
        self.res = 0

    def maxDepth(self, root):
        self.traverse(root)
        return self.res

    # 遍历二叉树
    def traverse(self, root):
        if root is None:
            return

        # 前序遍历位置
        self.depth += 1
        # 遍历的过程中记录最大深度
        self.res = max(self.res, self.depth)
        self.traverse(root.left)
        self.traverse(root.right)
        # 后序遍历位置
        self.depth -= 1

# **** 解法二，动态规划思路 ****
class Solution2:
    # 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    def maxDepth(self, root):
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + max(leftMax, rightMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// **** 解法一，回溯算法思路 ****
class Solution {

    int depth = 0;
    int res = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
}

// **** 解法二，动态规划思路 ****
class Solution2 {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 根据左右子树的最大深度推出原二叉树的最大深度
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// **** 解法一，回溯算法思路 ****
func maxDepth(root *TreeNode) int {
    var res int
    var depth int
    traverse(root, &depth, &res)
    return res
}

// 遍历二叉树
func traverse(root *TreeNode, depth *int, res *int) {
    if root == nil {
        return
    }

    // 前序遍历位置
    *depth++
    // 遍历的过程中记录最大深度
    if *depth > *res {
        *res = *depth
    }
    traverse(root.Left, depth, res)
    traverse(root.Right, depth, res)
    // 后序遍历位置
    *depth--
}

// **** 解法二，动态规划思路 ****
func maxDepthDP(root *TreeNode) int {
    // 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    if root == nil {
        return 0
    }
    leftMax := maxDepthDP(root.Left)
    rightMax := maxDepthDP(root.Right)
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + max(leftMax, rightMax)
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

/**
 * 解法一，回溯算法思路
 */
function maxDepth(root) {
    let depth = 0;
    let res = 0;
    // 遍历二叉树
    function traverse(root) {
        if (root === null) {
        return;
        }

        // 前序遍历位置
        depth++;
        // 遍历的过程中记录最大深度
        res = Math.max(res, depth);
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }
    traverse(root);
    return res;
}

/**
 * 解法二，动态规划思路
 */

// 定义：输入一个节点，返回以该节点为根的二叉树的最大深度
function maxDepth2(root) {
    if (root === null) {
        return 0;
    }
    const leftMax = maxDepth2(root.left);
    const rightMax = maxDepth2(root.right);
    // 根据左右子树的最大深度推出原二叉树的最大深度
    return 1 + Math.max(leftMax, rightMax);
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_mydata-maxdepth1" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth1"></div></div>
</details><hr /><br />

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_mydata-maxdepth2" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-maxdepth2"></div></div>
</details><hr /><br />

**类似题目**：
  - [1376. 通知所有员工所需的时间 🟠](/problems/time-needed-to-inform-all-employees)
  - [144. 二叉树的前序遍历 🟢](/problems/binary-tree-preorder-traversal)
  - [543. 二叉树的直径 🟢](/problems/diameter-of-binary-tree)
  - [559. N 叉树的最大深度 🟢](/problems/maximum-depth-of-n-ary-tree)
  - [865. 具有所有最深节点的最小子树 🟠](/problems/smallest-subtree-with-all-the-deepest-nodes)
  - [剑指 Offer 55 - I. 二叉树的深度 🟢](/problems/er-cha-shu-de-shen-du-lcof)

</div>

</details>
</div>

