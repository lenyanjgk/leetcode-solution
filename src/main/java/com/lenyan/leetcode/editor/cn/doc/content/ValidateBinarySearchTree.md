<p>给你一个二叉树的根节点 <code>root</code> ，判断其是否是一个有效的二叉搜索树。</p>

<p><strong>有效</strong> 二叉搜索树定义如下：</p>

<ul> 
 <li>节点的左<span data-keyword="subtree">子树</span>只包含<strong> 小于 </strong>当前节点的数。</li> 
 <li>节点的右子树只包含 <strong>大于</strong> 当前节点的数。</li> 
 <li>所有左子树和右子树自身必须也是二叉搜索树。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg" style="width: 302px; height: 182px;" /> 
<pre>
<strong>输入：</strong>root = [2,1,3]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg" style="width: 422px; height: 292px;" /> 
<pre>
<strong>输入：</strong>root = [5,1,4,null,null,3,6]
<strong>输出：</strong>false
<strong>解释：</strong>根节点的值是 5 ，但是右子节点的值是 4 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目范围在<code>[1, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-2<sup>31</sup> &lt;= Node.val &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 2426, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

初学者做这题很容易有误区：BST 不是左小右大么，那我只要检查 `root.val > root.left.val` 且 `root.val < root.right.val` 不就行了？

这样是不对的，因为 BST 左小右大的特性是指 `root.val` 要比左子树的所有节点都更大，要比右子树的所有节点都小，你只检查左右两个子节点当然是不够的。

正确解法是通过使用辅助函数，增加函数参数列表，在参数中携带额外信息，将这种约束传递给子树的所有节点，这也是二叉搜索树算法的一个小技巧吧。

**详细题解：[二叉搜索树心法（基操篇）](https://labuladong.online/algo/data-structure/bst-part2/)**

</div>

**标签：[二叉搜索树](https://labuladong.online/algo/)，[数据结构](https://labuladong.online/algo/)**

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
    bool isValidBST(TreeNode* root) {
        return isValidBST(root, nullptr, nullptr);
    }

    // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
    bool isValidBST(TreeNode* root, TreeNode* min, TreeNode* max) {
        // base case
        if (root == nullptr) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != nullptr && root->val <= min->val) return false;
        if (max != nullptr && root->val >= max->val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root->left, min, root) 
            && isValidBST(root->right, root, max);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.isValidBST(root, None, None)

    # 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
    def isValidBST(self, root: TreeNode, minNode: TreeNode = None, maxNode: TreeNode = None) -> bool:
        # base case
        if root is None:
            return True
        # 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if minNode is not None and root.val <= minNode.val:
            return False
        if maxNode is not None and root.val >= maxNode.val:
            return False
        # 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return self.isValidBST(root.left, minNode, root) and self.isValidBST(root.right, root, maxNode)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func isValidBST(root *TreeNode) bool {
    return isValidBSTHelper(root, nil, nil)
}

// 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
func isValidBSTHelper(root, min, max *TreeNode) bool {
    // base case
    if root == nil {
        return true
    }
    // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
    if min != nil && root.Val <= min.Val {
        return false
    }
    if max != nil && root.Val >= max.Val {
        return false
    }
    // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
    return isValidBSTHelper(root.Left, min, root) && isValidBSTHelper(root.Right, root, max)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var isValidBST = function(root) {
    // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
    function isValidBST(root, min, max) {
        // base case
        if (root === null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min !== null && root.val <= min.val) return false;
        if (max !== null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root) 
            && isValidBST(root.right, root, max);
    }
    
    return isValidBST(root, null, null);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_validate-binary-search-tree" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_validate-binary-search-tree"></div></div>
</details><hr /><br />

**类似题目**：
  - [255. 验证前序遍历序列二叉搜索树 🟠](/problems/verify-preorder-sequence-in-binary-search-tree)
  - [450. 删除二叉搜索树中的节点 🟠](/problems/delete-node-in-a-bst)
  - [700. 二叉搜索树中的搜索 🟢](/problems/search-in-a-binary-search-tree)
  - [701. 二叉搜索树中的插入操作 🟠](/problems/insert-into-a-binary-search-tree)

</div>

</details>
</div>

