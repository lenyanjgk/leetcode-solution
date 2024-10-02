<p>给定一个二叉树的根节点 <code>root</code> ，返回 <em>它的 <strong>中序</strong>&nbsp;遍历</em> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg" style="height: 200px; width: 125px;" /> 
<pre>
<strong>输入：</strong>root = [1,null,2,3]
<strong>输出：</strong>[1,3,2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[0, 100]</code> 内</li> 
 <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶:</strong>&nbsp;递归算法很简单，你可以通过迭代算法完成吗？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 2144, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

不要瞧不起二叉树的遍历问题，前文 [我的刷题经验总结](https://labuladong.online/algo/essential-technique/algorithm-summary/) 说过，二叉树的遍历代码是动态规划和回溯算法的祖宗。

动态规划思路的核心在于明确并利用函数的定义分解问题，中序遍历结果的特点是 `root.val` 在中间，左右子树在两侧：

![](https://labuladong.online/algo/images/二叉树系列2/1.jpeg)

回溯算法的核心很简单，就是 `traverse` 函数遍历二叉树。

本题就分别用两种不同的思路来写代码，注意体会两种思路的区别所在。

</div>

**标签：[二叉树](https://labuladong.online/algo/)**

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

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
std::vector<int> inorderTraversal(TreeNode* root) {
    std::vector<int> res;
    if (root == nullptr) {
        return res;
    }
    auto leftRes = inorderTraversal(root->left);
    res.insert(res.end(), leftRes.begin(), leftRes.end());
    res.push_back(root->val);
    auto rightRes = inorderTraversal(root->right);
    res.insert(res.end(), rightRes.begin(), rightRes.end());
    return res;
}

// 回溯算法思路
class Solution {
public:
    std::vector<int> res;

    // 返回前序遍历结果
    // Note: Despite the comment saying "preorder", this function actually returns inorder traversal result
    std::vector<int> inorderTraversal(TreeNode* root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);
        // 中序遍历位置
        res.push_back(root->val);
        traverse(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 动态规划思路
    # 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if root is None:
            return res
        res.extend(self.inorderTraversal(root.left))
        res.append(root.val)
        res.extend(self.inorderTraversal(root.right))
        return res

    # 回溯算法思路
    res = []

    # 返回前序遍历结果
    def inorderTraversal2(self, root: TreeNode) -> List[int]:
        self.traverse(root)
        return self.res

    # 二叉树遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        self.traverse(root.left)
        # 中序遍历位置
        self.res.append(root.val)
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 动态规划思路
    // 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }

    // 回溯算法思路
    LinkedList<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    public List<Integer> inorderTraversal2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        res.add(root.val);
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
func inorderTraversal(root *TreeNode) []int {
    var res []int
    if root == nil {
        return res
    }
    res = append(res, inorderTraversal(root.Left)...)
    res = append(res, root.Val)
    res = append(res, inorderTraversal(root.Right)...)
    return res
}

// 回溯算法思路
// 返回前序遍历结果
func inorderTraversal2(root *TreeNode) []int {
    var res []int
    traverse(root, &res)
    return res
}

// 二叉树遍历函数
func traverse(root *TreeNode, res *[]int) {
    if root == nil {
        return
    }
    traverse(root.Left, res)
    // 中序遍历位置
    *res = append(*res, root.Val)
    traverse(root.Right, res)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 动态规划思路
// 定义：输入一个节点，返回以该节点为根的二叉树的中序遍历结果
var inorderTraversal = function(root) {
    let res = [];
    if (root === null) {
        return res;
    }
    res = res.concat(inorderTraversal(root.left));
    res.push(root.val);
    res = res.concat(inorderTraversal(root.right));
    return res;
};

// 回溯算法思路
// 返回前序遍历结果
var inorderTraversal2 = function(root) {
    let res = [];
    traverse(root, res);
    return res;
};

// 二叉树遍历函数
var traverse = function(root, res) {
    if (root === null) {
        return;
    }
    traverse(root.left, res);
    // 中序遍历位置
    res.push(root.val);
    traverse(root.right, res);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_binary-tree-inorder-traversal" data="GxE7UVRrnhFRwcgAtDiwiYy7MJFm+YcHGX2LF/GkoSz1rYjR4Glh/WKEDLmtg0PyVBs43qjsqTQfnBdyHXgIlbpsWr2+lF+7GZSZS3FzpFoJC4REkACzZctminjwgp39B2E7su4SG1a8Vf3+bbWHaBYRjziFSZCaZmLWKbyqNxfV3kU0YxaVrn7Tg7mERJCG/DgTRTT7SQT/JbqOuFPdD1kPbdELOB9+28NV/CUxWOj0xcL5cZ4Cb/7X180xGE2MCNPO038YeDik3WN1mIs41CeV7z/zw/jilRqtWO+7qU4ffQtlS7PY19f13lODvycx3+GvMAc1n5/iAm/+2xns4rDAk2Yps1g7y/h6Cg95qQOkGJK7BzbrOa689xi+g67cq6gf1MyQbPQcxTpXwxjfqlZqbGJsr5phUBuQBnveMP9xlTS2wN1EwKn9NxbbDsQGlVXCngc2y57k0vc13arS5hdhDqGTL7XB7Nk6dMFPmRF4ACX74H2twUid8TrFVbZo1eibSkjq7HYX+ffd878mX8Un/UtJJG+TctnUR38TW+imvE2IBcyafp5maZLw4P2v38ZhiK6o2PJ4B/tJamkYyXHJic7G6KZPicO6KWs91MKpvUJLFtn0B700pbR7djNy+dTVswFKdR89s3SPgZRSYyeF9lhPuOIgbYZduHQ5j70nSWRz9KipdSlWo8aQbIe0J/h5RiSpiTu8oi9pfQShmGrPQFBtE4cYDHZXld/Gjro7TboSaVKAxkMibIJdu+n//fP2YZKhcoSNZKz4nMnOmOMOk1LcVDsaMvDfMsP/CVX1VFQBu2v7ei80sMT+6WG1Y2DGbQ7867SH9IcO0VmoeuRfjb2tTUlTu+ga9z2VuoJUlmM6s0yD0EwZgEhwoHJrgNT7JS962QHemJd6AEekGkRbaqhml29owj40SsEnyTnvIP8w+B+kcFlB6qnvoER1KP3AlGL4AbG0DJrm1cPVeqwC2tmRuAMi6P61GX0sFzhVL9fTFm1k8T0v8d9GC/hJoXVT9gXozbm/Kwy+6Aa5hSO8MEJlkfH/ddOMrs9x/KoujNCcc39nuE3+sw0a36Cy3zf512/FZeO7IuB7svHxS24wHq0G/hlpbwz3vEW1fXTsH29QL+p3z5PHULRjjWoer7+M1V2vPSP1I3CVMbgRPvQbvX0rGsTU74yE98qAJmt5qW1GVyjl1yfaDxq5l07ysy+sqOLExjDPm5roFrF/vEO9Vr95HhC7ncca1T2utZGE1Ot3TTMzUGb9HYTvCoN3RsF7ZcL7h8N3yAXRGmKN4d4quJTbtq8x4XZRLeVTj2sTxGoqD0UXKHqQcmBq33U7utmveSf2mJFTgm9thEJsTbIRMOGvNo89Mq4sTO60inLHoaR+LE4ekTafdxP/94pd5kHMD1+pElSkg/rR9sUzHVcFUlL1xHqtsQw88Y43NhTWi/qgdzeP0LIgtJFLr1uiNZ1KZ4/GeOBAe7msQiT4195TeNDSYY9nsWFVmNpSzt3ao607Gj0YNVpeiojW0uJuzQary4vMd0tvkonmbrW1p5sMd2u0hICO+lXHtx761eqdWu5azi5y7Fawu61fqT6Tqe+HnDtkeq75yhMi9bQb1LFlTxEH4d3EW3KcFtvDkPEcnnckWa6rSY9CDhkuXXoa+5TSTu6XkGbsXZjV0OGl4ysCHWytzNz37thS0l1b2Z69GCjwdAzSGReBlqEdpriHPmxoELS6sFNBbGnt+DFLV2IEyt3uKu6dfd6/PkJhpCa6BbgOj9E88Tms/WeM3kDYUGRSROkWHqNNEjvI05QiUEsOehh3gliTHTCX9uldsaMh0jbKM9YikJ9rXrInQixJW9MKOLMMI6oQ9hCNM8sQPF3AsYU9I4asaJIiYPTRDwlLV8InaPlFQoL9SI72XJne2yFrGsQm+UnevX60JGOrwZlu60BRluXRGReaMRqcWdcOHoXkzxuDOMuLfYOyQeGgvh0DM/445zq1bMnS0J5v8s6FJISNNiT7cueP8Od1C7aJD1KxVSWTpJwdBJljxGgbWoBRpcVM2+qCCiIvmgU89NDD4cpgWsDIdXMlV93gh/vLwzAaTVdhMKn0/3TtLjSjROTHpIh28WiZSBxyORKMhp7/QC9V88BmtgZl/XxMcMoUA6k49Xq/NwZDkiAmjL9SlVnmZe+UxKp0iXmb8TQGztgva3Ilo4N9mm5gqeuxT0v+dQEsI+zTXAcyyfTrNvFiy7w2ljK0B9taGxW1eff6Eb5TIdUeblQRCBZ39i00gc7xyAvAAXRgRKKYWWBLE/FgD5YDmvrUgdzfrFN8SqMdte+Wf+cS9ZjF1PE68OwG7SyxsGRNV4AlqAY5ydMzO0dayl1GMOeDkc5ehULsEng//stsY8LNS0piQhgIJAnosh8JoKTrWRHUXJkLJh78+XY2zYQO7UBDHXYANFtVFpRahdK6qwaoqBqgiWqAwqlB65UaoD5qgJaoAcqgBuh8DoBqpwEanAYoahqgj2nQahdgwvWuGLsDFh1rNLlfB6bbh+PGUgSYp5ishUGS5BBgqCCmVr4CPwVyDKJmoiXLQUTBFECGaCFHIQoUwIpoIUciaq5ZshyFaDE5iChQgCSiZpQly1GIFpOLiKO/ccdM1Jhjqzx8WBznm2dEEpvQ9Q3yniMQ8HlNsNZZQcv2uE2YUHIumwwJb/lfYnspFoPyAZNMRDdirGZgWQvfvmP/Ol6PqzsJ4aPJlLez2fIpg2zymAd1GcySM1CVwIdHYB2YmWcBFL/59tGU4SE+iEMZa9a6gnQB5ot/AfNJW6iPs4zz878imNaFPiaj3dCZlK++XfzA11AUReFNKmVy8YvJpv17urMF5cziFyhzjwFJzC5e4zmzWeLY63XJzOxf8oGKQUG6VRfO2rwo7uNu3/4poRgJMt5fwa9TliU/NqAGVcXR12OQ0b9kWvgZM4RefVEx1npxiz+XjIgUnJ6kzmRb+mmMs+FjMgzaixha2ZzHGPLR90hS0HyIqjSgLvH/Ji1cqDzqJgeUr2uNqqDq0YUoTICQP+QkrIG2KWosE8th0HBbHCNR3AIzgszpWkC0MOA/athibdb8QjF7Np785Tch5S+kzavcQ+Lv2ylEAEwMZ/64W5mNuT1FtCalPGXjP/pzDtajWSd5r60hbNY3HIcK/H3vQEjwesVUmVpuWsAIK0VCog55K/PTq2NIKosm9GgFaauvDKmaaqsoreX+ew1jKeNDYMJl2v92PQE="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_binary-tree-inorder-traversal"></div></div>
</details><hr /><br />

</div>

</details>
</div>

