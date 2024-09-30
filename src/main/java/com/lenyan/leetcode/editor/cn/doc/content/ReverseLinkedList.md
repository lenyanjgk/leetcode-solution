给你单链表的头节点 <code>head</code> ，请你反转链表，并返回反转后的链表。

<div class="original__bRMd"> 
 <div> 
  <p>&nbsp;</p> 
 </div>
</div>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[5,4,3,2,1]
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;" /> 
<pre>
<strong>输入：</strong>head = [1,2]
<strong>输出：</strong>[2,1]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>链表中节点的数目范围是 <code>[0, 5000]</code></li> 
 <li><code>-5000 &lt;= Node.val &lt;= 5000</code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？</p>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表</details><br>

<div>👍 3683, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

递归实现反转链表常常用来考察递归思想，我这里就用纯递归来翻转链表。

**对于递归算法，最重要的就是明确递归函数的定义**。具体来说，我们的 `reverse` 函数定义是这样的：

**输入一个节点 `head`，将「以 `head` 为起点」的链表反转，并返回反转之后的头结点**。

明白了函数的定义，再来看这个问题。比如说我们想反转这个链表：

![](https://labuladong.online/algo/images/反转链表/1.jpg)

那么输入 `reverse(head)` 后，会在这里进行递归：

```java
ListNode last = reverse(head.next);
```

不要跳进递归（你的脑袋能压几个栈呀？），而是要根据刚才的函数定义，来弄清楚这段代码会产生什么结果：

![](https://labuladong.online/algo/images/反转链表/2.jpg)

这个 `reverse(head.next)` 执行完成后，整个链表就成了这样：

![](https://labuladong.online/algo/images/反转链表/3.jpg)

并且根据函数定义，`reverse` 函数会返回反转之后的头结点，我们用变量 `last` 接收了。

现在再来看下面的代码：

```java
head.next.next = head;
```

![](https://labuladong.online/algo/images/反转链表/4.jpg)

接下来：

```java
head.next = null;
return last;
```

![](https://labuladong.online/algo/images/反转链表/5.jpg)

神不神奇，这样整个链表就反转过来了！

**详细题解：[单链表的花式反转方法汇总](https://labuladong.online/algo/data-structure/reverse-linked-list-recursion/)**

</div>

**标签：单链表**

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
    ListNode* reverseList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* last = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return last;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # public ListNode reverseList(ListNode head) {
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        last = self.reverseList(head.next) # <extend up -200>![](https://labuladong.online/algo/images/反转链表/3.jpg) #
        head.next.next = head # <extend up -200>![](https://labuladong.online/algo/images/反转链表/4.jpg) #
        head.next = None # <extend up -200>![](https://labuladong.online/algo/images/反转链表/5.jpg) #
        return last
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);/**<extend up -200>![](https://labuladong.online/algo/images/反转链表/3.jpg) */
        head.next.next = head;/**<extend up -200>![](https://labuladong.online/algo/images/反转链表/4.jpg) */
        head.next = null;/**<extend up -200>![](https://labuladong.online/algo/images/反转链表/5.jpg) */
        return last;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func reverseList(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    last := reverseList(head.Next)
    // ![](https://labuladong.online/algo/images/反转链表/3.jpg)
    head.Next.Next = head
    // ![](https://labuladong.online/algo/images/反转链表/4.jpg)
    head.Next = nil
    // ![](https://labuladong.online/algo/images/反转链表/5.jpg)
    return last
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var reverseList = function(head) {
    if (head === null || head.next === null) {
        return head;
    }
    var last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_reverse-linked-list" data="G2swoiiTixzhOLAbvg4Qo8WkWCwcxodMXCvlqyMyE2qU3u4BCQP//JvO+qqN0h3bHrC92x3hJ/ApGngDaGAp3cPHBtK+3+81DkEhbcrGVUZVyEx9O/7AX5Wwev1lHt937i2SQlRARsSq+vVLp9MKSN+qcKV/I469eTSLbDbjGb+3qVVRJSruIrynb6I+KHUa3x/T+DxRizeWKMQQatpSuu7w+F3XvDvYjYdtEkac7cbDuj7BwDV1z5Ubsoxm+rLuczUuXfay25mRnLo1K2f+h1AFMNqN+/NIy3eTWFcoVjbmtAZ7bktlp6tKVLevxiWsuq5p9W9tLgiifngLNXlmtw22G5V1PgES6k/HsHdM6GcZLSw9/PC2r4UHt0vJRZRSyB06TiTT7rZ9IJaHr77J2SxMZr3j/Z/f34yrKvF8gFqSYLKHr316m8phC4aNlBqZVtZVjJ6iGzn+8P3nsBvRNHW12LN0M6dFjgN7XrjEekofKMpLmYn+mvL5CzeJ7CluTODb6IHalu09H979Ya3cZ8iz8q9BUkwf240t+bpPByqI+SpVspn8TyjeKAKbNn/EVKnZqiPrCk9CO9//VbAUeOwF5pZR1bo3BPBLgubbMOjRBpBYOI4cZuKCzTcMmt0oDPa9w/hFRwzgmAjNNAtNkFg4jq7HFWvNNJrLKJzse48xRjTgmAjNZhbaILFwHD3xcVo0m7EZ6iwEGPgeT2NkBhwTodnNgKADjQUBrC38bekdTIYPAHoBhdGI+GWpPX7sBR7uXghlzZPP9LyUl1ziZWHyEm0fcFlfGaTzJvwFXeApryOGH1K1suRsOrBpxifoSaI2SgR8oXPG+UgtGeyRkG5BgW/h7+UKtArCKAs056scmyskfGtWlPkoKnxVRY9Yi3gEUfwtefsFC2xLVq/oCGxkd1bXZe3vuGGw8gbNu/B3PSmmoLXEFrEVBeAley8YHzdYfsQwQWhU8gyiwqGnBBW0ltgituJggUS8H0Qop5kgZtTapRiFQc8UVNBaYovYioMFGuL9IKL5dtFyytAoP0cMGjSBnioVAIysfM/98JUUcg536ouEhnCIhMORgrLfi99pxmmBHGRdyylHWdfKhSyEQh7CoaC6Ec7Y/v88VScaUHMRlNEfrrhx2WCKJFs34TMcCdE7dokMCZthSIqAws2Q4AwiKQIKE0MCM+EmBbyyDLGC15epriObqzG+HPoar3AFS3cvPNxweq92m4CxtAoD25OjkqaY68lkJqSTjqbUYPVixlfbfOxma2v36eCaiWEZEg8FU1FGOhxdjzzvdubvx2CV0n06sgKnNLI2Vls3vBRqmBzN2Gyoo9Gh+p197+CdNXT5U4qgaufDQRty9je9CDN6L7utYWf506pI0SKc09ju/8ueI2bY6OR1wDjB04P0Vm2LFquqUVfacuKAEFyqtfkpjjhy9MQqndEiT9C2Wo/vjfchs7RgxnJxbGS2FsfakPd3XuccgFEBO4wiWwVCWoAsY2M3aFcLjRZhpOEp9rCq2JjfEGDpMCKOfbfbNqSFgkRabbOKHbTjnLHZs8QycLs/K2n2LBGMCQ/61Da0Eg58PMPC2pwJi6EUrfmJ3480s32EmawjUs8vEQwVLOfP+PO3Tx0EPbiSCo4Mwb7uQy2NrdWCp9CWE5/SHL7oQ9FcxeWr14tSwLXetSHfmXO0YiINJ+JL9w6b5kbWIKJs/e0/BZ9nldB83ceU1M24YEuVCT8/tGKBaRZUzfB9Z0UGyEbnUuQ7/T4nDjvALBR/Ibidtu39mTeBxR7kYugHPZnitdWHZDzndG/OeZk7fOqQjCZU2lOTOqIMPRv9GVOulkQdhkUJFmdpGjnKkT70OwRgXeZGSst2Ia7zQUHMgWG1c2J0whXAm3ZyseRN136DrgzEiESGY+9tYnVo/QZRbzpS3aEVcuA3UIDJNfRKCSJL+PO3T+876ZfDT2xwj8shHqPuuyERcydcf/t8HDjoJIxVyOWI+WBOPm5JoeA7zJXUmGYIUq6HsrDT+51EK5wd/BLA6t6G+dHTI+6VnGvh1zG1dkOe2TILhZsfv+9v4M0CygKsySpvC//vNRYf7nyMLUdNOO4/qHb6rmvt5e8nC6hU5sKomkZQIcyBamUElcZIFrXDTAiVQCJqexFU6iKovaVBJY0I2lgEla40qF0RQYmKoK6UBlUiYvF+skZbdTT9Rzh605a1don1PJpPpoesCRkYszkKg8XVSJlJNr+x5ZthtaRjDjkag97ROOkNnRXoHY1O72gsekMnUnpHY9AbOrHSOxqD3tBNlL74eX9egv0IWq4CUD4xH1vKWd8Ak08uv6tLl10uVl1mHrrgmpNFXTq5O74MqKwjg7d7IUvOP4bM33+VtFfOEg0kyKdFuvBkHc70tEKEgQbtLYhpSxqCqfvj6lI1wNw0QKKXT2kL1v6rkNb5H0IxcYn9yZNHAfPrGijjdN6W45JmG6GtxK8gIQwv9vsV"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_reverse-linked-list"></div></div>
</details><hr /><br />

**类似题目**：
  - [25. K 个一组翻转链表 🔴](/problems/reverse-nodes-in-k-group)
  - [92. 反转链表 II 🟠](/problems/reverse-linked-list-ii)
  - [剑指 Offer 24. 反转链表 🟢](/problems/fan-zhuan-lian-biao-lcof)
  - [剑指 Offer II 024. 反转链表 🟢](/problems/UHnkqh)

</div>

</details>
</div>

