<p>给你一个链表的头节点 <code>head</code> ，判断链表中是否有环。</p>

<p>如果链表中有某个节点，可以通过连续跟踪 <code>next</code> 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 <code>pos</code> 来表示链表尾连接到链表中的位置（索引从 0 开始）。<strong>注意：<code>pos</code> 不作为参数进行传递&nbsp;</strong>。仅仅是为了标识链表的实际情况。</p>

<p><em>如果链表中存在环</em>&nbsp;，则返回 <code>true</code> 。 否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png" /></p>

<pre>
<strong>输入：</strong>head = [3,2,0,-4], pos = 1
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第二个节点。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png" /></p>

<pre>
<strong>输入：</strong>head = [1,2], pos = 0
<strong>输出：</strong>true
<strong>解释：</strong>链表中有一个环，其尾部连接到第一个节点。
</pre>

<p><strong>示例 3：</strong></p>

<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png" /></p>

<pre>
<strong>输入：</strong>head = [1], pos = -1
<strong>输出：</strong>false
<strong>解释：</strong>链表中没有环。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围是 <code>[0, 10<sup>4</sup>]</code></li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
 <li><code>pos</code> 为 <code>-1</code> 或者链表中的一个 <strong>有效索引</strong> 。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能用 <code>O(1)</code>（即，常量）内存解决此问题吗？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 链表 | 双指针</details><br>

<div>👍 2203, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/linked-list-skills-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[链表双指针技巧全面汇总](https://www.bilibili.com/video/BV1q94y1X7vy)

经典题目了，要使用双指针技巧中的快慢指针，每当慢指针 `slow` 前进一步，快指针 `fast` 就前进两步。

如果 `fast` 最终遇到空指针，说明链表中没有环；如果 `fast` 最终和 `slow` 相遇，那肯定是 `fast` 超过了 `slow` 一圈，说明链表中含有环。

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
    bool hasCycle(ListNode *head) {
        // 快慢指针初始化指向 head
        ListNode *slow = head, *fast = head;
        // 快指针走到末尾时停止
        while (fast != nullptr && fast->next != nullptr) {
            // 慢指针走一步，快指针走两步
            slow = slow->next;
            fast = fast->next->next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 快慢指针初始化指向 head
    def hasCycle(self, head: ListNode) -> bool:
        slow = head
        fast = head
        # 快指针走到末尾时停止
        while fast is not None and fast.next is not None:
            # 慢指针走一步，快指针走两步
            slow = slow.next
            fast = fast.next.next
            # 快慢指针相遇，说明含有环
            if slow == fast:
                return True
        # 不包含环
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func hasCycle(head *ListNode) bool {
    // 快慢指针初始化指向 head
    slow, fast := head, head
    // 快指针走到末尾时停止
    for fast != nil && fast.Next != nil {
        // 慢指针走一步，快指针走两步
        slow = slow.Next
        fast = fast.Next.Next
        // 快慢指针相遇，说明含有环
        if slow == fast {
            return true
        }
    }
    // 不包含环
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var hasCycle = function(head) {
    // 快慢指针初始化指向 head
    let slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast !== null && fast.next !== null) {
        // 慢指针走一步，快指针走两步
        slow = slow.next;
        fast = fast.next.next;
        // 快慢指针相遇，说明含有环
        if (slow === fast) {
            return true;
        }
    }
    // 不包含环
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_linked-list-cycle" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_linked-list-cycle"></div></div>
</details><hr /><br />

**类似题目**：
  - [142. 环形链表 II 🟠](/problems/linked-list-cycle-ii)
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

