<p>给你一棵二叉树的根节点，返回该树的 <strong>直径</strong> 。</p>

<p>二叉树的 <strong>直径</strong> 是指树中任意两个节点之间最长路径的 <strong>长度</strong> 。这条路径可能经过也可能不经过根节点 <code>root</code> 。</p>

<p>两节点之间路径的 <strong>长度</strong> 由它们之间边数表示。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/diamtree.jpg" style="width: 292px; height: 302px;" /> 
<pre>
<strong>输入：</strong>root = [1,2,3,4,5]
<strong>输出：</strong>3
<strong>解释：</strong>3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 1605, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/binary-tree-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[二叉树/递归的框架思维（纲领篇）](https://www.bilibili.com/video/BV1nG411x77H)

所谓二叉树的直径，就是左右子树的最大深度之和，那么直接的想法是对每个节点计算左右子树的最大高度，得出每个节点的直径，从而得出最大的那个直径。

但是由于 `maxDepth` 也是递归函数，所以上述方式时间复杂度较高。

这题类似 [366. 寻找二叉树的叶子节点](/problems/find-leaves-of-binary-tree)，需要灵活运用二叉树的后序遍历，在 `maxDepth` 的后序遍历位置顺便计算最大直径。

**详细题解：[二叉树系列算法核心纲领](https://labuladong.online/algo/essential-technique/binary-tree-summary/)**

</div>

**标签：[二叉树](https://labuladong.online/algo/)，后序遍历**

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

class Solution {
    int maxDiameter = 0;

public:
    int diameterOfBinaryTree(TreeNode* root) {
        maxDepth(root);
        return maxDiameter;
    }

private:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = std::max(maxDiameter, leftMax + rightMax);
        return 1 + std::max(leftMax, rightMax);
    }
};

// 这是一种简单粗暴，但是效率不高的解法
class BadSolution {
public:
    int diameterOfBinaryTree(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        // 计算出左右子树的最大高度
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        // root 这个节点的直径
        int res = leftMax + rightMax;
        // 递归遍历 root.left 和 root.right 两个子树
        return std::max(res,
                std::max(diameterOfBinaryTree(root->left),
                        diameterOfBinaryTree(root->right)));
    }

private:
    int maxDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        int leftMax = maxDepth(root->left);
        int rightMax = maxDepth(root->right);
        return 1 + std::max(leftMax, rightMax);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.maxDiameter = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.maxDepth(root)
        return self.maxDiameter

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 后序遍历位置顺便计算最大直径
        self.maxDiameter = max(self.maxDiameter, leftMax + rightMax)
        return 1 + max(leftMax, rightMax)

# 这是一种简单粗暴，但是效率不高的解法
class BadSolution:
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        if root is None:
            return 0
        # 计算出左右子树的最大高度
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # root 这个节点的直径
        res = leftMax + rightMax
        # 递归遍历 root.left 和 root.right 两个子树
        return max(res,
                   max(self.diameterOfBinaryTree(root.left),
                       self.diameterOfBinaryTree(root.right)))

    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        return 1 + max(leftMax, rightMax)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}

// 这是一种简单粗暴，但是效率不高的解法
class BadSolution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算出左右子树的最大高度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // root 这个节点的直径
        int res = leftMax + rightMax;
        // 递归遍历 root.left 和 root.right 两个子树
        return Math.max(res,
                Math.max(diameterOfBinaryTree(root.left),
                        diameterOfBinaryTree(root.right)));
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func diameterOfBinaryTree(root *TreeNode) int {
    var maxDiameter int
    maxDepth(root, &maxDiameter)
    return maxDiameter
}

func maxDepth(root *TreeNode, maxDiameter *int) int {
    if root == nil {
        return 0
    }
    leftMax := maxDepth(root.Left, maxDiameter)
    rightMax := maxDepth(root.Right, maxDiameter)
    // 后序遍历位置顺便计算最大直径
    *maxDiameter = max(*maxDiameter, leftMax+rightMax)
    return 1 + max(leftMax, rightMax)
}

// 这是一种简单粗暴，但是效率不高的解法
func badDiameterOfBinaryTree(root *TreeNode) int {
    if root == nil {
        return 0
    }
    // 计算出左右子树的最大高度
    leftMax := badMaxDepth(root.Left)
    rightMax := badMaxDepth(root.Right)
    // root 这个节点的直径
    res := leftMax + rightMax
    // 递归遍历 root.left 和 root.right 两个子树
    return max(res, max(badDiameterOfBinaryTree(root.Left), badDiameterOfBinaryTree(root.Right)))
}

func badMaxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    leftMax := badMaxDepth(root.Left)
    rightMax := badMaxDepth(root.Right)
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

var diameterOfBinaryTree = function(root) {
    let maxDiameter = 0;

    function maxDepth(root) {
        if (root === null) {
            return 0;
        }
        let leftMax = maxDepth(root.left);
        let rightMax = maxDepth(root.right);
        // 后序遍历位置顺便计算最大直径
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }

    maxDepth(root);
    return maxDiameter;
};

// 这是一种简单粗暴，但是效率不高的解法
var badDiameterOfBinaryTree = function(root) {
    if (root === null) {
        return 0;
    }
    // 计算出左右子树的最大高度
    let leftMax = maxDepth(root.left);
    let rightMax = maxDepth(root.right);
    // root 这个节点的直径
    let res = leftMax + rightMax;
    // 递归遍历 root.left 和 root.right 两个子树
    return Math.max(res,
        Math.max(diameterOfBinaryTree(root.left),
            diameterOfBinaryTree(root.right)));

    function maxDepth(root) {
        if (root === null) {
            return 0;
        }
        let leftMax = maxDepth(root.left);
        let rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_mydata-diameter-of-binary-tree" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_mydata-diameter-of-binary-tree"></div></div>
</details><hr /><br />

**类似题目**：
  - [104. 二叉树的最大深度 🟢](/problems/maximum-depth-of-binary-tree)
  - [124. 二叉树中的最大路径和 🔴](/problems/binary-tree-maximum-path-sum)
  - [1245. 树的直径 🟠](/problems/tree-diameter)
  - [144. 二叉树的前序遍历 🟢](/problems/binary-tree-preorder-traversal)
  - [250. 统计同值子树 🟠](/problems/count-univalue-subtrees)
  - [366. 寻找二叉树的叶子节点 🟠](/problems/find-leaves-of-binary-tree)
  - [687. 最长同值路径 🟠](/problems/longest-univalue-path)
  - [814. 二叉树剪枝 🟠](/problems/binary-tree-pruning)
  - [979. 在二叉树中分配硬币 🟠](/problems/distribute-coins-in-binary-tree)
  - [剑指 Offer 55 - I. 二叉树的深度 🟢](/problems/er-cha-shu-de-shen-du-lcof)
  - [剑指 Offer II 047. 二叉树剪枝 🟠](/problems/pOCWxh)
  - [剑指 Offer II 051. 节点之和最大的路径 🔴](/problems/jC7MId)

</div>

</details>
</div>

