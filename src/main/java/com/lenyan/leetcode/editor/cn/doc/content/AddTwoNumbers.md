<p>给你两个&nbsp;<strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>

<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>

<p>你可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" /> 
<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,0,8]
<strong>解释：</strong>342 + 465 = 807.
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>输出：</strong>[8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>题目数据保证列表表示的数字不含前导零</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表 | 数学</details><br>

<div>👍 10830, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

逆序存储很友好了，直接遍历链表就是从个位开始的，符合我们计算加法的习惯顺序。如果是正序存储，那倒要费点脑筋了，可能需要 [翻转链表](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/) 或者使用栈来辅助。

这道题主要考察 [链表双指针技巧](https://labuladong.online/algo/essential-technique/linked-list-skills-summary/) 和加法运算过程中对进位的处理。注意这个 `carry` 变量的处理，在我们手动模拟加法过程的时候会经常用到。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**。你可以试试，如果不使用 `dummy` 虚拟节点，代码会稍显复杂，而有了 `dummy` 节点这个占位符，可以避免处理初始的空指针情况，降低代码的复杂性。

</div>

**标签：[数据结构](https://labuladong.online/algo/)，[链表双指针](https://labuladong.online/algo/)**

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // 在两条链表上的指针
        ListNode *p1 = l1, *p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode *dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode *p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != nullptr || p2 != nullptr || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != nullptr) {
                val += p1->val;
                p1 = p1->next;
            }
            if (p2 != nullptr) {
                val += p2->val;
                p2 = p2->next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p->next = new ListNode(val);
            p = p->next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 在两条链表上的指针
        p1, p2 = l1, l2
        # 虚拟头结点（构建新链表时的常用技巧）
        dummy = ListNode(-1)
        # 指针 p 负责构建新链表
        p = dummy
        # 记录进位
        carry = 0
        # 开始执行加法，两条链表走完且没有进位时才能结束循环
        while p1 is not None or p2 is not None or carry > 0:
            # 先加上上次的进位
            val = carry
            if p1 is not None:
                val += p1.val
                p1 = p1.next
            if p2 is not None:
                val += p2.val
                p2 = p2.next
            # 处理进位情况
            carry = val // 10
            val = val % 10
            # 构建新节点
            p.next = ListNode(val)
            p = p.next
        # 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // 在两条链表上的指针
    p1, p2 := l1, l2
    // 虚拟头结点（构建新链表时的常用技巧）
    dummy := &ListNode{-1, nil}
    // 指针 p 负责构建新链表
    p := dummy
    // 记录进位
    carry := 0
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    for p1 != nil || p2 != nil || carry > 0 {
        // 先加上上次的进位
        val := carry
        if p1 != nil {
            val += p1.Val
            p1 = p1.Next
        }
        if p2 != nil {
            val += p2.Val
            p2 = p2.Next
        }
        // 处理进位情况
        carry = val / 10
        val = val % 10
        // 构建新节点
        p.Next = &ListNode{val, nil}
        p = p.Next
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var addTwoNumbers = function(l1, l2) {
    // 在两条链表上的指针
    let p1 = l1, p2 = l2;
    // 虚拟头结点（构建新链表时的常用技巧）
    let dummy = new ListNode(-1);
    // 指针 p 负责构建新链表
    let p = dummy;
    // 记录进位
    let carry = 0;
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    while (p1 !== null || p2 !== null || carry > 0) {
        // 先加上上次的进位
        let val = carry;
        if (p1 !== null) {
            val += p1.val;
            p1 = p1.next;
        }
        if (p2 !== null) {
            val += p2.val;
            p2 = p2.next;
        }
        // 处理进位情况
        carry = Math.floor(val / 10);
        val = val % 10;
        // 构建新节点
        p.next = new ListNode(val);
        p = p.next;
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.next;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_add-two-numbers" data="G/NHIxG2YXDafCRC2DiAhGwmirI5qQJqlcAdKr54FwSPRqk0gm4DlvACDpdk4Oq731rDzDEyQhqTCGlORLRXgPKSbMcId4jtbAxVvvrbHODcOH52zYfLbM/PLdVDfPrjLCW3N1EgtGjzawP/eNoe4RB3jMiflIJBhaCDI00cvr2oYdvG/oAZadFa+Q4pDB02CoAd6I+/667ZCgLMzAaI1X0coI3RcSbOxa+f/s9WSEKr45/FiPzebGmX0nyyM0dRm0K4rvdtNi+01pJBePdleCr/KyQSGeD/8U+MFwoKfcuFwZclMz6p/4xp8nCQ4Li7tgzBfOMjzrYWY3ONq0I+AV2cLra9/9+B8bb8/X77OtVEVmda9w0D560rvwN1aCSz+hI4/mNLzCIfU2/54cVi+Zm89R/GClYj/98vLlV/PImtjbXPLJra7j+uSfmt3aj2thJdEzHPOVkGKr3G+lgKzlemmfaaz7VbYJ8inQJ59ca1WBektBlWe76UTcNn62mb4XU5S7UPOIeO1XFsXiXQf5vxYds2+oMtyoGo6ie6hPpV/wlZqmQdVfbeS1iHIwGUbCf3LUDjXeyM9FvwH8F271uAx1sdXfaLWEPTIsfpel2YemtnWeh8+pQ/3z88bQ6eQsPHYiJY/qIou18/I3T0fZSrQZHhbeEunkAB8vzlX1ZIyJwIYLsjuA92+FBlMfph7JByM/PSZMg2X6j6Tsw2cm592mW38McCUUDQSuwiMdfeNx1y0C809zbC/FRGQZFlv14qRQ6r0U803l5jJnuuy1x9vFmua/jiDxUrUmTInM494cW73f5Q92IPZj4eRN9i73f4hTZfWwRKRM/rlFv+eIoXWT4oRcXMKjLarMjbV9cvpzdoabQV5ACJzWyBXB10jvGWVUKbImEpehAqJs811I2W+4kKxAK6y7qOeBkFdEcUaJs0hWRVh2SNU5lgRQ3WJetoPqXpob/PvyVInf9CoUy9AUxvoBWVIF+6YOUi0VzHtQj02Pn969jAP+v98w/fNrKdQGfZZHI2QDNRMAjDZfT6RtiSohfe7a0r5LUZW3FsVpvTresqt5DMXLKADKGM+RRrw8buZ1/rxuuNrY24SW4K1MKqaa2qyDYWDBHy1htV9o3WC2eMjMa4FHPTT0ffjuGtvdTe0q2qSHyVW0RoLlowlkA/Ebmh8XTAnwGMBeAMV5wj3f6QidtUgIbUu7QICK4PpMz+cJcR5COgKXdvcLodR0oMrD2L6MtRa2VyxkhltC/UVPZ6UG04FKDLxBDt46BcA7X3fPQ1A3y/Yyhz1iHY2f9lLXRFqqcgJpR0shm4eHJyfoHHpFzACHHWUabG5ub/W0zHjmOFC+XExZaPYFqM0lxzrSUL0UJtqj7GgjNdZcqf1bSumJmvYm6wYsC6VGhEchj2Ugopd2I3ly1medRjCE54jRmuNkiShJmvYtRCCOalwgU0J85hWt4GUpcDzcczG2iZ1MPE9XRyllMchSRJyEzFRMFmjySgxOPO8RwwF4abnJlKLcKq1vmr2VtsdZazaP8uiYDxLm1c+w3+hwEdUwKTKzEQXUgQMtT8f8MZ0lwKqZKQ6YpJdVQZLPULSbn5DzRppBuNFOiXCo3wP2qjpDHVLankEoM8Q/VValshQWJfBqUaKXAvFRoalMsyXBmit44xeW905FIvgmpWnNZRMtCnSB8Tu2P/nqRJJcW0q5jMVIz75nSuoCRV5DX6U3gNhfFOKvBxg//JgI8pgcmVHIguFAgZav6/4QxpvgqpkpCJKoMdL9ElBHABWzuXQDeNEnJ7/dAsquTOijSLmwRSn20iixh1CZPKizL9J2tMiZ0S5TRxvvMJOGy2PW0XCcZK4eTTkhBi2Yf2tVbvCsoT5kB2FvUY71NR1QleaM+ikf8+yfQnW2D3ji3I5bZQkYJ2EvduuOyLo+oUDkUPSgr9jkSFU88o99E3D2zFHQwYaP8RDktuYSBgr2Bkc1bN6noCOqhMLdf4bJXDandjIGA/BQ6r3IWBgAWWB9/dHIewod8GTPRrXQjv5tCROGbuCGjuzKLX1aYvEWaBsV3HSBfK8Wj+Wr95aERrDrIVKWxbAZnn2d/m9fl6PUIbqzZ/3UzaqzvF7mOtKM3L7DLl68bvIbuzLEYMkfoGd+GwoKFgznLQjClnQ3CmDrhPh6kj7n4YkRpHCqbEYUVDw9xKOm2vX5flMNQKo6qMx6S61IoleQ/fp9Ppe1J4LJK9/SNh5qjVCf5c+GKgXf+BfailYxfjktc2hvUmj0bYZVi4yQPHc/7777+872I8cYCQh3aaCLrph7kfUmNO3h0BxU4ObjTEQUvUEkx3IDmTMY1YyFG0ky/zIVvssYAusJLQqr3sKLb3XpyOTUz8YqLkJVby5RJ1HKc+ce5UzBpJrsEDh8/li9YueVzOnVqk1edQ2GW2shLusbsMPp9i9VAVV/anFoYPOtsZm726ueeEJ/2OeBLe8uIV9Dvi3j4pF+wM0pGmfQsH4bGMEX1A+OJQzj9iM+ujDEt40ne5RVqJFjPxku9fXtdS4rS4vr2PTmK6xUmhxvMlZ7+OTq9tPnN4sNTJi/uLXPvCIYakIylu+SYj0kMkDoF/4ruxmQqbuGPO081fux9SjV8i8EMgabqdmPOR4uHQdq/p6oaDUTemicYpkIGnNkzAo8N0zhXah0OmnOu+Ws7wlz092eWVzFu7oklZ+8Rs62hEB9kuyOLpFq9rqXJqStHE9R2SrA6YMyj6snqynqsHDXuk3rxqziW576tykUDIw6m47kFkh47OKXYNwh3sxN3rEnhdT69EDOHd3c6EN7Pbi3TIjcayI0jd7UD4r8muJYppsq2+qFXsTSS/VCrhpPr+5bX7TE7aDeDp5r3o26U7socqG4nE6KimToG4K6eBw1H5kMaPlh5WrLOYmeTb/aq+47eXRaxrTXpRS5SrA1Wl4jVWNxhF9Qq6O8SXRio50Y7bWEhdaEWEiOrGn4qfFB8+cBSn9Qv/Wm0sn8e33vbxWHnHFUiFja27fg+/FgErSrw5ViARFTeciiUKEZN/Q+UBEdt/c4zLO/kou04xcxEBF/JsJxyPFpJlEScWUV8Rw9VJImt6IqpCNioinSJuKaKQQqYoYoJCuhcO8FUqfy7WMGb3pQMrE9rZww4TQMRUYV6QSxPLOVyWiCmIiuuCHEzMJG/4EzYTu7ncPDvcNjtckR2sqWaldSh2jkC1CK1DucECxUkLVCvSOhQHLVBtwNGh3GGB4qQFqp1oHYqFFqgOpHUoZo5AdQJtFupVWgW4bQcPXtHhQ7RQAMj3PyhlDiW74WmaNQCIIrZUwcctc6Z60Sn/RmVOujaSJU4mI1dEtQO8Oa9HU2OYG8BGQ2twy7PLaADJ0EFvKbErD2Hq8W/+li0TkK59lILrX1If8dzqIxNNNPbjOM+qJexKxt9NKG7s3ZmKY6xwVPOveAUEWlZkpbShH/ymTuChjma++7ohUYfVoANV0W+5/mW8fOMfmlk+NKzV2CFdY48AAXaE3L10SKMQqHQ59GOMHyCl8OsNfMjHUcfwnfD8GBPEbR+DDmkKlBOA4/wOOnTR/mU9Y89uI/2fzlfxSUB6vcaORgM0n8/y1+UHfgxg2sPmSob8rdglilYNgylMRehWZ8HrIgyd913AhGPT1fCSUDfS4R/PcBTJ2Ok6SFnD1wvEboL4BYaXCQIlnIGR0GFOul9jGz1D7fpSATDlfi9UMoG/iceyLRuirouRicAIqyevbNHm9erdD2axCGQzWVu7Rzx0kCz8jnus5wB2tz5MEWxv+qYyqGzArIgNLKM2AdkDDQI9J0WPwGZjQwByLz791cc4UT5zRchw4wNqtUtzTs5YhFwxq+JrF3oEuA7MkSgorFzxY84j0WMlhPITsjKXtMQFFcQ5BnUMnCRkLC3q/LLwi+Cfs9IyMl7+YWB1XiH4YBMDcwaZaRWun/lWkbS9AjQpBZEsjpRi7vtCFuq5i0tCakqP/5HX2Z/KE+6xpQpEHaAKqqDLA05Vp2FtlVRR89SOE4dTYxWb3bj2vlhIGve4ugPX0fmfv3CpPOa+lrKXj4ahoBoK7HXEfnsfcivKCsPE2KJ3J5UA108gShgbR7UqvF6SSiWfA0YWCDk6hggKnFofrVbae++AMiy9r0RZwyXrnosh/Y4tgMvvq8MqUl8biY7pnKy13ns="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-two-numbers"></div></div>
</details><hr /><br />

**类似题目**：
  - [445. 两数相加 II 🟠](/problems/add-two-numbers-ii)
  - [67. 二进制求和 🟢](/problems/add-binary)
  - [剑指 Offer II 025. 链表中的两数相加 🟠](/problems/lMSNwu)

</div>

</details>
</div>

