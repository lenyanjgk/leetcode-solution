<p>给你一个单链表的头节点 <code>head</code> ，请你判断该链表是否为<span data-keyword="palindrome-sequence">回文链表</span>。如果是，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg" style="width: 422px; height: 62px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,2,1]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg" style="width: 182px; height: 62px;" /> 
<pre>
<strong>输入：</strong>head = [1,2]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点数目在范围<code>[1, 10<sup>5</sup>]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你能否用&nbsp;<code>O(n)</code> 时间复杂度和 <code>O(1)</code> 空间复杂度解决此题？</p>

<details><summary><strong>Related Topics</strong></summary>栈 | 递归 | 链表 | 双指针</details><br>

<div>👍 1962, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/data-structure/palindrome-linked-list/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这道题的关键在于，单链表无法倒着遍历，无法使用双指针技巧。

那么最简单的办法就是，把原始链表反转存入一条新的链表，然后比较这两条链表是否相同。

更聪明一些的办法是借助双指针算法：

**1、先通过 [双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 中的快慢指针来找到链表的中点**：

![](https://labuladong.online/algo/images/回文链表/1.jpg)

**2、如果 `fast` 指针没有指向 `null`，说明链表长度为奇数，`slow` 还要再前进一步**：

![](https://labuladong.online/algo/images/回文链表/2.jpg)

**3、从 `slow` 开始反转后面的链表，现在就可以开始比较回文串了**：

![](https://labuladong.online/algo/images/回文链表/3.jpg)

**详细题解：[如何判断回文链表](https://labuladong.online/algo/data-structure/palindrome-linked-list/)**

</div>

**标签：回文问题，[数据结构](https://labuladong.online/algo/)，[链表](https://labuladong.online/algo/)，[链表双指针](https://labuladong.online/algo/)**

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
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
        }

        if (fast != nullptr)
            slow = slow->next;

        ListNode* left = head;
        ListNode* right = reverse(slow);
        while (right != nullptr) {
            if (left->val != right->val)
                return false;
            left = left->next;
            right = right->next;
        }

        return true;
    }

    ListNode* reverse(ListNode* head) {
        ListNode* pre = nullptr;
        ListNode* cur = head;
        while (cur != nullptr) {
            ListNode* next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = fast = head
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        if fast is not None:
            slow = slow.next

        left = head
        right = self.reverse(slow)
        while right is not None:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        return True

    def reverse(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur is not None:
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return pre
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func isPalindrome(head *ListNode) bool {
    slow, fast := head, head
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
    }

    if fast != nil {
        slow = slow.Next
    }

    left := head
    right := reverse(slow)
    for right != nil {
        if left.Val != right.Val {
            return false
        }
        left = left.Next
        right = right.Next
    }

    return true
}

func reverse(head *ListNode) *ListNode {
    var pre *ListNode
    cur := head
    for cur != nil {
        next := cur.Next
        cur.Next = pre
        pre = cur
        cur = next
    }
    return pre
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var isPalindrome = function(head) {
    var reverse = function(head) {
        let pre = null, cur = head;
        while (cur != null) {
            let next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    };

    let slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    if (fast != null)
        slow = slow.next;

    let left = head;
    let right = reverse(slow);
    while (right != null) {
        if (left.val !== right.val)
            return false;
        left = left.next;
        right = right.next;
    }

    return true;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_palindrome-linked-list" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_palindrome-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer II 027. 回文链表 🟢](/problems/aMhZSa)

</div>

</details>
</div>

