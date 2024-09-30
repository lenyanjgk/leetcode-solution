<p>给你链表的头节点 <code>head</code> ，每&nbsp;<code>k</code><em>&nbsp;</em>个节点一组进行翻转，请你返回修改后的链表。</p>

<p><code>k</code> 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是&nbsp;<code>k</code><em>&nbsp;</em>的整数倍，那么请将最后剩余的节点保持原有顺序。</p>

<p>你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 2
<strong>输出：</strong>[2,1,4,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;" /></p>

<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 3
<strong>输出：</strong>[3,2,1,4,5]
</pre>

<p>&nbsp;</p> 
<strong>提示：</strong>

<ul> 
 <li>链表中的节点数目为 <code>n</code></li> 
 <li><code>1 &lt;= k &lt;= n &lt;= 5000</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 1000</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以设计一个只用 <code>O(1)</code> 额外内存空间的算法解决此问题吗？</p>

<ul> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 2410, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

输入 `head`，`reverseKGroup` 函数能够把以 `head` 为头的这条链表进行翻转。

我们要充分利用这个递归函数的定义，把原问题分解成规模更小的子问题进行求解。

**1、先反转以 `head` 开头的 `k` 个元素**。

![](https://labuladong.online/algo/images/kgroup/3.jpg)

**2、将第 `k + 1` 个元素作为 `head` 递归调用 `reverseKGroup` 函数**。

![](https://labuladong.online/algo/images/kgroup/4.jpg)

**3、将上述两个过程的结果连接起来**。

![](https://labuladong.online/algo/images/kgroup/5.jpg)

最后函数递归完成之后就是这个结果，完全符合题意：

![](https://labuladong.online/algo/images/kgroup/7.jpg)

**详细题解：[单链表的花式反转方法汇总](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/)**

</div>

**标签：[数据结构](https://labuladong.online/algo/)，[链表](https://labuladong.online/algo/)，[链表双指针](https://labuladong.online/algo/)**

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

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == nullptr) return nullptr;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode *a, *b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == nullptr) return head;
            b = b->next;
        }
        // 反转前 k 个元素
        ListNode* newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a->next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    ListNode* reverse(ListNode* a, ListNode* b) {
        ListNode *pre, *cur, *nxt;
        pre = nullptr;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur->next;
            cur->next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if head is None:
            return None
        # 区间 [a, b) 包含 k 个待反转元素
        a = b = head
        for i in range(k):
            # 不足 k 个，不需要反转，base case
            if b is None:
                return head
            b = b.next
        # 反转前 k 个元素
        newHead = self.reverse(a, b)
        # 递归反转后续链表并连接起来
        a.next = self.reverseKGroup(b, k) # <extend up -90>![](https://labuladong.online/algo/images/kgroup/6.jpg) #
        return newHead

    # 反转区间 [a, b) 的元素，注意是左闭右开
    def reverse(self, a: ListNode, b: ListNode) -> ListNode: # <extend up -300>![](https://labuladong.online/algo/images/kgroup/8.gif) #
        pre = None
        cur = a
        nxt = a
        # while 终止的条件改一下就行了
        while cur != b:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        # 返回反转后的头结点
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);/**<extend up -90>![](https://labuladong.online/algo/images/kgroup/6.jpg) */
        return newHead;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    ListNode reverse(ListNode a, ListNode b) {/**<extend up -300>![](https://labuladong.online/algo/images/kgroup/8.gif) */
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func reverseKGroup(head *ListNode, k int) *ListNode {
    if head == nil {
        return nil
    }
    // 区间 [a, b) 包含 k 个待反转元素
    a, b := head, head
    for i := 0; i < k; i++ {
        // 不足 k 个，不需要反转，base case
        if b == nil {
            return head
        }
        b = b.Next
    }
    // 反转前 k 个元素
    newHead := reverse(a, b)
    // 递归反转后续链表并连接起来
    a.Next = reverseKGroup(b, k)
    return newHead
}

// 反转区间 [a, b) 的元素，注意是左闭右开
func reverse(a, b *ListNode) *ListNode {
    var pre, cur, nxt *ListNode
    cur = a
    nxt = a
    // while 终止的条件改一下就行了
    for cur != b {
        nxt = cur.Next
        cur.Next = pre
        pre = cur
        cur = nxt
    }
    // 返回反转后的头结点
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var reverseKGroup = function(head, k) {
    if (head == null) return null;
    // 区间 [a, b) 包含 k 个待反转元素
    let a, b;
    a = b = head;
    for (let i = 0; i < k; i++) {
        // 不足 k 个，不需要反转，base case
        if (b == null) return head;
        b = b.next;
    }
    // 反转前 k 个元素
    let newHead = reverse(a, b);
    // 递归反转后续链表并连接起来
    a.next = reverseKGroup(b, k);
    return newHead;
};

// 反转区间 [a, b) 的元素，注意是左闭右开
function reverse(a, b) {
    let pre, cur, nxt;
    pre = null;
    cur = a;
    nxt = a;
    // while 终止的条件改一下就行了
    while (cur !== b) {
        nxt = cur.next;
        cur.next = pre;
        pre = cur;
        cur = nxt;
    }
    // 返回反转后的头结点
    return pre;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_reverse-nodes-in-k-group" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-nodes-in-k-group"></div></div>
</details><hr /><br />

**类似题目**：
  - [206. 反转链表 🟢](/problems/reverse-linked-list)
  - [24. 两两交换链表中的节点 🟠](/problems/swap-nodes-in-pairs)
  - [92. 反转链表 II 🟠](/problems/reverse-linked-list-ii)
  - [剑指 Offer 24. 反转链表 🟢](/problems/fan-zhuan-lian-biao-lcof)
  - [剑指 Offer II 024. 反转链表 🟢](/problems/UHnkqh)

</div>

</details>
</div>

