<p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4]
<strong>输出：</strong>[2,1,4,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 2293, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这道题不难，常规方法就是维护多个指针，遍历一遍链表顺便把每两个节点翻转。不过迭代的思路虽然直接，但细节问题会比较多，写起来麻烦。

所以我直接用递归的方式来写，只要搞明白递归函数的定义，然后利用这个定义就可以完成这道题。

其实前文 [如何 `k` 个一组反转链表](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/) 中讲过的 [25. K 个一组翻转链表](/problems/reverse-nodes-in-k-group) 就是这道题的进阶版，你可以去做一做。

</div>

**标签：单链表，递归**

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
public: // Ensure that swapPairs is public
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* first = head;
        ListNode* second = head->next;
        ListNode* others = head->next->next;
        // 先把前两个元素翻转
        second->next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first->next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

# 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
# 返回翻转后的链表头结点
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        first = head
        second = head.next
        others = head.next.next
        # 先把前两个元素翻转
        second.next = first
        # 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = self.swapPairs(others)
        # 现在整个链表都成功翻转了，返回新的头结点
        return second
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode others = head.next.next;
        // 先把前两个元素翻转
        second.next = first;
        // 利用递归定义，将剩下的链表节点两两翻转，接到后面
        first.next = swapPairs(others);
        // 现在整个链表都成功翻转了，返回新的头结点
        return second;/**<extend up -200>![](https://labuladong.online/algo/images/kgroup/7.jpg) */
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func swapPairs(head *ListNode) *ListNode {
    // 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
    // 返回翻转后的链表头结点
    if head == nil || head.Next == nil {
        return head
    }
    first := head
    second := head.Next
    others := head.Next.Next
    // 先把前两个元素翻转
    second.Next = first
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.Next = swapPairs(others)
    // 现在整个链表都成功翻转了，返回新的头结点
    return second
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 定义：输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
// 返回翻转后的链表头结点
var swapPairs = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    let first = head;
    let second = head.next;
    let others = head.next.next;
    // 先把前两个元素翻转
    second.next = first;
    // 利用递归定义，将剩下的链表节点两两翻转，接到后面
    first.next = swapPairs(others);
    // 现在整个链表都成功翻转了，返回新的头结点
    return second;
    // ![](https://labuladong.online/algo/images/kgroup/7.jpg) // This line is a comment with a picture reference which is not valid in this context.
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_swap-nodes-in-pairs" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_swap-nodes-in-pairs"></div></div>
</details><hr /><br />

</div>

</details>
</div>

