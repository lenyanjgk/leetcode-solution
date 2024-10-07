<p>给你二叉树的根结点 <code>root</code> ，请你将它展开为一个单链表：</p>

<ul> 
 <li>展开后的单链表应该同样使用 <code>TreeNode</code> ，其中 <code>right</code> 子指针指向链表中下一个结点，而左子指针始终为 <code>null</code> 。</li> 
 <li>展开后的单链表应该与二叉树 <a href="https://baike.baidu.com/item/%E5%85%88%E5%BA%8F%E9%81%8D%E5%8E%86/6442839?fr=aladdin" target="_blank"><strong>先序遍历</strong></a> 顺序相同。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg" style="width: 500px; height: 226px;" /> 
<pre>
<strong>输入：</strong>root = [1,2,5,3,4,null,6]
<strong>输出：</strong>[1,null,2,null,3,null,4,null,5,null,6]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [0]
<strong>输出：</strong>[0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中结点数在范围 <code>[0, 2000]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以使用原地算法（<code>O(1)</code> 额外空间）展开这棵树吗？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 链表 | 二叉树</details><br>

<div>👍 1735, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/data-structure/binary-tree-part1/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[二叉树/递归的框架思维（纲领篇）](https://www.bilibili.com/video/BV1nG411x77H)

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

前者较简单，只要运用二叉树的递归遍历框架即可；后者的关键在于明确递归函数的定义，然后利用这个定义，这题就属于后者，`flatten` 函数的定义如下：

**给 `flatten` 函数输入一个节点 `root`，那么以 `root` 为根的二叉树就会被拉平为一条链表**。

如何利用这个定义来完成算法？你想想怎么把以 `root` 为根的二叉树拉平为一条链表？

很简单，以下流程：

1、将 `root` 的左子树和右子树拉平。

2、将 `root` 的右子树接到左子树下方，然后将整个左子树作为右子树。

![](https://labuladong.online/algo/images/二叉树系列/2.jpeg)

至于如何把 `root` 的左右子树拉平，不用你操心，`flatten` 函数的定义就是这样，交给他做就行了。

把上面的逻辑翻译成代码，即可解决本题。

**详细题解：[二叉树心法（思路篇）](https://labuladong.online/algo/data-structure/binary-tree-part1/)**

</div>

**标签：[二叉树](https://labuladong.online/algo/)，[数据结构](https://labuladong.online/algo/)**

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
public:
    // 定义：将以 root 为根的树拉平为链表
    void flatten(TreeNode* root) {
        // base case
        if (root == nullptr) return;
        // 先递归拉平左右子树
        flatten(root->left);
        flatten(root->right);

        // ***后序遍历位置***
        // 1、左右子树已经被拉平成一条链表
        TreeNode* left = root->left;
        TreeNode* right = root->right;

        // 2、将左子树作为右子树
        root->left = nullptr;
        root->right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode* p = root;
        while (p->right != nullptr) {
            p = p->right;
        }
        p->right = right;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 定义：将以 root 为根的树拉平为链表
    def flatten(self, root):
        # base case
        if root is None:
            return
        
        # 先递归拉平左右子树
        self.flatten(root.left)
        self.flatten(root.right)

        # ***后序遍历位置***
        # 1、左右子树已经被拉平成一条链表
        left = root.left
        right = root.right

        # 2、将左子树作为右子树
        root.left = None
        root.right = left

        # 3、将原先的右子树接到当前右子树的末端
        p = root
        while p.right is not None:
            p = p.right
        p.right = right
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：将以 root 为根的树拉平为链表
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;
        // 先递归拉平左右子树
        flatten(root.left);
        flatten(root.right);

        // ***后序遍历位置***
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;/**<extend up -50>![](https://labuladong.online/algo/images/二叉树系列/2.jpeg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 定义：将以 root 为根的树拉平为链表
func flatten(root *TreeNode) {
    // base case
    if root == nil {
        return
    }
    // 先递归拉平左右子树
    flatten(root.Left)
    flatten(root.Right)

    // ***后序遍历位置***
    // 1、左右子树已经被拉平成一条链表
    left := root.Left
    right := root.Right

    // 2、将左子树作为右子树
    root.Left = nil
    root.Right = left

    // 3、将原先的右子树接到当前右子树的末端
    p := root
    for p.Right != nil {
        p = p.Right
    }
    p.Right = right
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var flatten = function(root) {
    // 定义：将以 root 为根的树拉平为链表
    var flattenTree = function(root) {
        // base case
        if (root == null) return;
        // 先递归拉平左右子树
        flattenTree(root.left);
        flattenTree(root.right);

        // ***后序遍历位置***
        // 1、左右子树已经被拉平成一条链表
        let left = root.left;
        let right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        let p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    };

    flattenTree(root);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_flatten-binary-tree-to-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_flatten-binary-tree-to-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [116. 填充每个节点的下一个右侧节点指针 🟠](/problems/populating-next-right-pointers-in-each-node)
  - [226. 翻转二叉树 🟢](/problems/invert-binary-tree)
  - [897. 递增顺序搜索树 🟢](/problems/increasing-order-search-tree)
  - [剑指 Offer 27. 二叉树的镜像 🟢](/problems/er-cha-shu-de-jing-xiang-lcof)
  - [剑指 Offer II 052. 展平二叉搜索树 🟢](/problems/NYBBNL)

</div>

</details>
</div>

