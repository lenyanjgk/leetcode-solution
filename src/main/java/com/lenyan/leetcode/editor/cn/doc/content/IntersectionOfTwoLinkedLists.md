<p>给你两个单链表的头节点&nbsp;<code>headA</code> 和 <code>headB</code> ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 <code>null</code> 。</p>

<p>图示两个链表在节点 <code>c1</code> 开始相交<strong>：</strong></p>

<p><a href="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_statement.png" style="height:130px; width:400px" /></a></p>

<p>题目数据 <strong>保证</strong> 整个链式结构中不存在环。</p>

<p><strong>注意</strong>，函数返回结果后，链表必须 <strong>保持其原始结构</strong> 。</p>

<p><strong>自定义评测：</strong></p>

<p><strong>评测系统</strong> 的输入如下（你设计的程序 <strong>不适用</strong> 此输入）：</p>

<ul> 
 <li><code>intersectVal</code> - 相交的起始节点的值。如果不存在相交节点，这一值为 <code>0</code></li> 
 <li><code>listA</code> - 第一个链表</li> 
 <li><code>listB</code> - 第二个链表</li> 
 <li><code>skipA</code> - 在 <code>listA</code> 中（从头节点开始）跳到交叉节点的节点数</li> 
 <li><code>skipB</code> - 在 <code>listB</code> 中（从头节点开始）跳到交叉节点的节点数</li> 
</ul>

<p>评测系统将根据这些输入创建链式数据结构，并将两个头节点 <code>headA</code> 和 <code>headB</code> 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 <strong>视作正确答案</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png" target="_blank"><img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_1_1.png" style="height:130px; width:400px" /></a></p>

<pre>
<strong>输入：</strong>intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
<strong>输出：</strong>Intersected at '8'
<strong>解释：</strong>相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
— 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中<font size="1">第三个</font>节点，B 中第四个节点) 在内存中指向相同的位置。
</pre>

<p>&nbsp;</p>

<p><strong>示例&nbsp;2：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png" target="_blank"><img alt="" src="https://assets.leetcode.com/uploads/2021/03/05/160_example_2.png" style="height:136px; width:350px" /></a></p>

<pre>
<strong>输入：</strong>intersectVal&nbsp;= 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
<strong>输出：</strong>Intersected at '2'
<strong>解释：</strong>相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
</pre>

<p><strong>示例&nbsp;3：</strong></p>

<p><a href="https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png" target="_blank"><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/14/160_example_3.png" style="height:126px; width:200px" /></a></p>

<pre>
<strong>输入：</strong>intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
<strong>输出：</strong>null
<strong>解释：</strong>从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
这两个链表不相交，因此返回 null 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>listA</code> 中节点数目为 <code>m</code></li> 
 <li><code>listB</code> 中节点数目为 <code>n</code></li> 
 <li><code>1 &lt;= m, n &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= skipA &lt;= m</code></li> 
 <li><code>0 &lt;= skipB &lt;= n</code></li> 
 <li>如果 <code>listA</code> 和 <code>listB</code> 没有交点，<code>intersectVal</code> 为 <code>0</code></li> 
 <li>如果 <code>listA</code> 和 <code>listB</code> 有交点，<code>intersectVal == listA[skipA] == listB[skipB]</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能否设计一个时间复杂度 <code>O(m + n)</code> 、仅用 <code>O(1)</code> 内存的解决方案？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 2520, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

这题难点在于，由于两条链表的长度可能不同，两条链表之间的节点无法对应：

![](https://labuladong.online/algo/images/链表技巧/5.jpeg)

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，并不能**同时**走到公共节点，也就无法得到相交节点 `c1`。

**解决这个问题的关键是，通过某些方式，让 `p1` 和 `p2` 能够同时到达相交节点 `c1`**。

如果用两个指针 `p1` 和 `p2` 分别在两条链表上前进，我们可以让 `p1` 遍历完链表 `A` 之后开始遍历链表 `B`，让 `p2` 遍历完链表 `B` 之后开始遍历链表 `A`，这样相当于「逻辑上」两条链表接在了一起。

如果这样进行拼接，就可以让 `p1` 和 `p2` 同时进入公共部分，也就是同时到达相交节点 `c1`：

![](https://labuladong.online/algo/images/链表技巧/6.jpeg)

另一种思路，先计算两条链表的长度，然后让 `p1` 和 `p2` 距离链表尾部的距离相同，然后齐头并进，

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
    ListNode* getIntersectionNode(ListNode* headA, ListNode* headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode* p1 = headA;
        ListNode* p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            p1 = (p1 == nullptr) ? headB : p1->next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            p2 = (p2 == nullptr) ? headA : p2->next;
        }
        return p1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # p1 指向 A 链表头结点，p2 指向 B 链表头结点
        p1, p2 = headA, headB
        while p1 != p2:
            # p1 走一步，如果走到 A 链表末尾，转到 B 链表
            p1 = headB if p1 is None else p1.next
            # p2 走一步，如果走到 B 链表末尾，转到 A 链表
            p2 = headA if p2 is None else p2.next
        return p1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func getIntersectionNode(headA, headB *ListNode) *ListNode {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    p1, p2 := headA, headB
    for p1 != p2 {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if p1 == nil {
            p1 = headB
        } else {
            p1 = p1.Next
        }
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if p2 == nil {
            p2 = headA
        } else {
            p2 = p2.Next
        }
    }
    return p1
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var getIntersectionNode = function(headA, headB) {
    // p1 指向 A 链表头结点，p2 指向 B 链表头结点
    let p1 = headA, p2 = headB;
    while (p1 !== p2) {
        // p1 走一步，如果走到 A 链表末尾，转到 B 链表
        if (p1 === null) p1 = headB;
        else p1 = p1.next;
        // p2 走一步，如果走到 B 链表末尾，转到 A 链表
        if (p2 === null) p2 = headA;
        else p2 = p2.next;
    }
    return p1;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_intersection-of-two-linked-lists" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_intersection-of-two-linked-lists"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [19. 删除链表的倒数第 N 个结点 🟠](/problems/remove-nth-node-from-end-of-list)
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

