<p>给你一个链表，删除链表的倒数第&nbsp;<code>n</code><em>&nbsp;</em>个结点，并且返回链表的头结点。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], n = 2
<strong>输出：</strong>[1,2,3,5]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = [1], n = 1
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1,2], n = 1
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中结点的数目为 <code>sz</code></li> 
 <li><code>1 &lt;= sz &lt;= 30</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
 <li><code>1 &lt;= n &lt;= sz</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能尝试使用一趟扫描实现吗？</p>

<details><summary><strong>Related Topics</strong></summary>链表 | 双指针</details><br>

<div>👍 2949, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

要删除倒数第 `n` 个节点，就得获得倒数第 `n + 1` 个节点的引用。

获取单链表的倒数第 `k` 个节点，就是想考察 [双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中快慢指针的运用，一般都会要求你**只遍历一次链表**，就算出倒数第 `k` 个节点。

第一步，我们先让一个指针 `p1` 指向链表的头节点 `head`，然后走 `k` 步：

![](https://labuladong.online/algo/images/链表技巧/1.jpeg)

第二步，用一个指针 `p2` 指向链表头节点 `head`：

![](https://labuladong.online/algo/images/链表技巧/2.jpeg)

第三步，让 `p1` 和 `p2` 同时向前走，`p1` 走到链表末尾的空指针时走了 `n - k` 步，`p2` 也走了 `n - k` 步，也就是链表的倒数第 `k` 个节点：

![](https://labuladong.online/algo/images/链表技巧/3.jpeg)

这样，只遍历了一次链表，就获得了倒数第 `k` 个节点 `p2`。

解法中在链表头部接一个虚拟节点 `dummy` 是为了避免删除倒数第一个元素时出现空指针异常，在头部加入 `dummy` 节点并不影响尾部倒数第 `k` 个元素是什么。

**详细题解：[双指针技巧秒杀七道链表题目](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/)**

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

class Solution {
public:
    // 主函数
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        // 虚拟头结点
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode* x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x->next = x->next->next;
        return dummy->next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode* findFromEnd(ListNode* head, int k) {
        ListNode* p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1->next;
        }
        ListNode* p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != nullptr) {
            p2 = p2->next;
            p1 = p1->next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 主函数
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        # 虚拟头结点
        dummy = ListNode(-1)
        dummy.next = head
        # 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        x = self.findFromEnd(dummy, n + 1)
        # 删掉倒数第 n 个节点
        x.next = x.next.next
        return dummy.next

    # 返回链表的倒数第 k 个节点
    def findFromEnd(self, head: ListNode, k: int) -> ListNode:
        p1 = head
        # p1 先走 k 步
        for i in range(k):
            p1 = p1.next
        p2 = head
        # p1 和 p2 同时走 n - k 步
        while p1:
            p2 = p2.next
            p1 = p1.next
        # p2 现在指向第 n - k 个节点
        return p2
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 主函数
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    // 虚拟头结点
    dummy := &ListNode{-1, head}
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    x := findFromEnd(dummy, n+1)
    // 删掉倒数第 n 个节点
    x.Next = x.Next.Next
    return dummy.Next
}

// 返回链表的倒数第 k 个节点
func findFromEnd(head *ListNode, k int) *ListNode {
    p1 := head
    // p1 先走 k 步
    for i := 0; i < k; i++ {
        p1 = p1.Next
    }
    p2 := head
    // p1 和 p2 同时走 n - k 步
    for p1 != nil {
        p2 = p2.Next
        p1 = p1.Next
    }
    // p2 现在指向第 n - k 个节点
    return p2
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var removeNthFromEnd = function(head, n) {
    // 虚拟头结点
    let dummy = new ListNode(-1);
    dummy.next = head;
    // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
    let x = findFromEnd(dummy, n + 1);
    // 删掉倒数第 n 个节点
    x.next = x.next.next;
    return dummy.next;
};

// 返回链表的倒数第 k 个节点
function findFromEnd(head, k) {
    let p1 = head;
    // p1 先走 k 步
    for (let i = 0; i < k; i++) {
        p1 = p1.next;
    }
    let p2 = head;
    // p1 和 p2 同时走 n - k 步
    while (p1 !== null) {
        p2 = p2.next;
        p1 = p1.next;
    }
    // p2 现在指向第 n - k 个节点
    return p2;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_remove-nth-node-from-end-of-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_remove-nth-node-from-end-of-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
  - [21. 合并两个有序链表 🟢](/problems/merge-two-sorted-lists)
  - [23. 合并K个升序链表 🔴](/problems/merge-k-sorted-lists)
  - [86. 分隔链表 🟠](/problems/partition-list)
  - [876. 链表的中间结点 🟢](/problems/middle-of-the-linked-list)
  - [剑指 Offer 22. 链表中倒数第k个节点 🟢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [剑指 Offer 25. 合并两个排序的链表 🟢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [剑指 Offer 52. 两个链表的第一个公共节点 🟢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [剑指 Offer II 021. 删除链表的倒数第 n 个结点 🟠](/problems/SLwz0R)
  - [剑指 Offer II 022. 链表中环的入口节点 🟠](/problems/c32eOV)
  - [剑指 Offer II 023. 两个链表的第一个重合节点 🟢](/problems/3u1WK4)
  - [剑指 Offer II 078. 合并排序链表 🔴](/problems/vvXgSW)

</div>

</details>
</div>

