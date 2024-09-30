<p>给定一个链表的头节点 &nbsp;<code>head</code>&nbsp;，返回链表开始入环的第一个节点。&nbsp;<em>如果链表无环，则返回&nbsp;<code>null</code>。</em></p>

<p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（<strong>索引从 0 开始</strong>）。如果 <code>pos</code> 是 <code>-1</code>，则在该链表中没有环。<strong>注意：<code>pos</code> 不作为参数进行传递</strong>，仅仅是为了标识链表的实际情况。</p>

<p><strong>不允许修改 </strong>链表。</p>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png" /></p>

<pre>
<strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>返回索引为 1 的链表节点
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" /></p>

<pre>
<strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>返回索引为 0 的链表节点
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" /></p>

<pre>
<strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>返回 null
<strong>解释：</strong>链表中没有环。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围在范围 <code>[0, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> 的值为 <code>-1</code> 或者链表中的一个有效索引</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你是否可以使用 <code>O(1)</code> 空间解决此题？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 2621, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

基于 [141. 环形链表](/problems/linked-list-cycle) 的解法，直观地来说就是当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。

原理也简单说下吧，我们假设快慢指针相遇时，慢指针 `slow` 走了 `k` 步，那么快指针 `fast` 一定走了 `2k` 步：

![](https://labuladong.online/algo/images/双指针/3.jpeg)

`fast` 一定比 `slow` 多走了 `k` 步，这多走的 `k` 步其实就是 `fast` 指针在环里转圈圈，所以 `k` 的值就是环长度的「整数倍」。

假设相遇点距环的起点的距离为 `m`，那么结合上图的 `slow` 指针，环的起点距头结点 `head` 的距离为 `k - m`，也就是说如果从 `head` 前进 `k - m` 步就能到达环起点。

巧的是，如果从相遇点继续前进 `k - m` 步，也恰好到达环起点：

![](https://labuladong.online/algo/images/双指针/2.jpeg)

所以，只要我们把快慢指针中的任一个重新指向 `head`，然后两个指针同速前进，`k - m` 步后一定会相遇，相遇之处就是环的起点了。

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

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast, *slow;
        fast = slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.online/algo/images/双指针/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == nullptr || fast->next == nullptr) {
            // fast 遇到空指针说明没有环
            return nullptr;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.online/algo/images/双指针/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast->next;
            slow = slow->next;
        }
        return slow;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        fast, slow = head, head
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break # <extend down -200>![](https://labuladong.online/algo/images/双指针/3.jpeg) #
        # 上面的代码类似 hasCycle 函数
        if fast is None or fast.next is None:
            # fast 遇到空指针说明没有环
            return None

        # 重新指向头结点
        slow = head # <extend up -100>![](https://labuladong.online/algo/images/双指针/2.jpeg) #
        # 快慢指针同步前进，相交点就是环起点
        while slow != fast:
            fast = fast.next
            slow = slow.next
        return slow
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;/**<extend down -200>![](https://labuladong.online/algo/images/双指针/3.jpeg) */
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;/**<extend up -100>![](https://labuladong.online/algo/images/双指针/2.jpeg) */
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func detectCycle(head *ListNode) *ListNode {
    var fast, slow *ListNode
    fast, slow = head, head
    for fast != nil && fast.Next != nil {
        fast = fast.Next.Next
        slow = slow.Next
        if fast == slow {
            break
        }
    }
    // 上面的代码类似 hasCycle 函数
    if fast == nil || fast.Next == nil {
        // fast 遇到空指针说明没有环
        return nil
    }

    // 重新指向头结点
    slow = head
    // 快慢指针同步前进，相交点就是环起点
    for slow != fast {
        fast = fast.Next
        slow = slow.Next
    }
    return slow
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var detectCycle = function(head) {
    let fast, slow;
    fast = slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) break;/**<extend down -200>![](https://labuladong.online/algo/images/双指针/3.jpeg) */
    }
    // 上面的代码类似 hasCycle 函数
    if (fast == null || fast.next == null) {
        // fast 遇到空指针说明没有环
        return null;
    }

    // 重新指向头结点
    slow = head;/**<extend up -100>![](https://labuladong.online/algo/images/双指针/2.jpeg) */
    // 快慢指针同步前进，相交点就是环起点
    while (slow != fast) {
        fast = fast.next;
        slow = slow.next;
    }
    return slow;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_linked-list-cycle-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [141. 环形链表 🟢](/problems/linked-list-cycle)
  - [160. 相交链表 🟢](/problems/intersection-of-two-linked-lists)
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



