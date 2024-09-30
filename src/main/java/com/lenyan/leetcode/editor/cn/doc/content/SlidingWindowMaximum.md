<p>给你一个整数数组 <code>nums</code>，有一个大小为&nbsp;<code>k</code><em>&nbsp;</em>的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 <code>k</code>&nbsp;个数字。滑动窗口每次只向右移动一位。</p>

<p>返回 <em>滑动窗口中的最大值 </em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>nums = [1,3,-1,-3,5,3,6,7], k = 3
<b>输出：</b>[3,3,5,5,6,7]
<b>解释：</b>
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>nums = [1], k = 1
<b>输出：</b>[1]
</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= k &lt;= nums.length</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>队列 | 数组 | 滑动窗口 | 单调队列 | 堆（优先队列）</details><br>

<div>👍 2888, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/data-structure/monotonic-queue/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 我在 [155. 最小栈](/problems/min-stack) 的思路中详细分析了动态集合中维护最值的「千古难题」，如果你没有做，可以先去做一下。我想请你结合这两道题仔细思考：队列和栈分别是如何解决最值维护问题的？

使用一个队列充当不断滑动的窗口，每次滑动记录其中的最大值：

![](https://labuladong.online/algo/images/单调队列/1.png)

如何在 `O(1)` 时间计算最大值，只需要一个特殊的数据结构「单调队列」，`push` 方法依然在队尾添加元素，但是要把前面比自己小的元素都删掉，直到遇到更大的元素才停止删除。

![](https://labuladong.online/algo/images/单调队列/3.png)

使用单调队列数据结构就能完成本题。

**详细题解：[单调队列结构解决滑动窗口问题](https://labuladong.online/algo/data-structure/monotonic-queue/)**

</div>

**标签：[数据结构](https://labuladong.online/algo/)，[滑动窗口](https://labuladong.online/algo/)，[队列](https://labuladong.online/algo/)**

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
    // 单调队列的实现
    class MonotonicQueue {
        deque<int> q;
    public:
        void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.empty() && q.back() < n) {
                q.pop_back();
            }
            // 然后将 n 加入尾部
            q.push_back(n);
        }

        int max() {
            return q.front();
        }

        void pop(int n) {
            if (n == q.front()) {
                q.pop_front();
            }
        }
    };

public:
    // 解题函数的实现
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MonotonicQueue window;
        vector<int> res;

        for (int i = 0; i < nums.size(); i++) {
            if (i < k - 1) {
                // 先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.push_back(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 单调队列的实现
    class MonotonicQueue:
        def __init__(self):
            self.q = []

        def push(self, n):
            # 将小于 n 的元素全部删除
            while self.q and self.q[-1] < n: # <extend down -300>![](https://labuladong.online/algo/images/单调队列/3.png) #
                self.q.pop()
            # 然后将 n 加入尾部
            self.q.append(n)

        def max(self):
            return self.q[0]

        def pop(self, n):
            if n == self.q[0]:
                self.q.pop(0)

    # 解题函数的实现
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        window = self.MonotonicQueue()
        res = []

        for i in range(len(nums)):
            if i < k - 1:
                # 先填满窗口的前 k - 1
                window.push(nums[i])
            else: # <extend up -150>![](https://labuladong.online/algo/images/单调队列/1.png) #
                # 窗口向前滑动，加入新数字
                window.push(nums[i])
                # 记录当前窗口的最大值
                res.append(window.max())
                # 移出旧数字
                window.pop(nums[i - k + 1])
        # 需要转成 int[] 数组再返回
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 单调队列的实现
    class MonotonicQueue {
        LinkedList<Integer> q = new LinkedList<>();
        public void push(int n) {
            // 将小于 n 的元素全部删除
            while (!q.isEmpty() && q.getLast() < n) {/**<extend down -300>![](https://labuladong.online/algo/images/单调队列/3.png) */
                q.pollLast();
            }
            // 然后将 n 加入尾部
            q.addLast(n);
        }

        public int max() {
            return q.getFirst();
        }

        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    // 解题函数的实现
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {/**<extend up -150>![](https://labuladong.online/algo/images/单调队列/1.png) */
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                res.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

type MonotonicQueue struct {
    q []int
}

// 单调队列的实现
func (mq *MonotonicQueue) push(n int) {
    // 将小于 n 的元素全部删除
    for len(mq.q) > 0 && mq.q[len(mq.q)-1] < n {
        mq.q = mq.q[:len(mq.q)-1]
    }
    // 然后将 n 加入尾部
    mq.q = append(mq.q, n)
}

func (mq *MonotonicQueue) max() int {
    return mq.q[0]
}

func (mq *MonotonicQueue) pop(n int) {
    if len(mq.q) > 0 && n == mq.q[0] {
        mq.q = mq.q[1:]
    }
}

// 解题函数的实现
func maxSlidingWindow(nums []int, k int) []int {
    window := &MonotonicQueue{}
    res := []int{}

    for i := 0; i < len(nums); i++ {
        if i < k-1 {
            // 先填满窗口的前 k - 1
            window.push(nums[i])
        } else {
            // 窗口向前滑动，加入新数字
            window.push(nums[i])
            // 记录当前窗口的最大值
            res = append(res, window.max())
            // 移出旧数字
            window.pop(nums[i-k+1])
        }
    }
    // 需要转成 int[] 数组再返回
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 单调队列的实现
var MonotonicQueue = function() {
    this.q = [];
};

MonotonicQueue.prototype.push = function(n) {
    // 将小于 n 的元素全部删除
    while (this.q.length > 0 && this.q[this.q.length - 1] < n) {
        this.q.pop();
    }
    // 然后将 n 加入尾部
    this.q.push(n);
};

MonotonicQueue.prototype.max = function() {
    return this.q[0];
};

MonotonicQueue.prototype.pop = function(n) {
    if (n === this.q[0]) {
        this.q.shift();
    }
};

// 解题函数的实现
var maxSlidingWindow = function(nums, k) {
    var window = new MonotonicQueue();
    var res = [];

    for (var i = 0; i < nums.length; i++) {
        if (i < k - 1) {
            // 先填满窗口的前 k - 1
            window.push(nums[i]);
        } else {
            // 窗口向前滑动，加入新数字
            window.push(nums[i]);
            // 记录当前窗口的最大值
            res.push(window.max());
            // 移出旧数字
            window.pop(nums[i - k + 1]);
        }
    }
    // 需要转成 int[] 数组再返回
    return res;
};
```

</div></div>
</div></div>

**类似题目**：
  - [155. 最小栈 🟠](/problems/min-stack)
  - [剑指 Offer 30. 包含min函数的栈 🟢](/problems/bao-han-minhan-shu-de-zhan-lcof)
  - [剑指 Offer 59 - I. 滑动窗口的最大值 🔴](/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof)
  - [面试题59 - II. 队列的最大值 🟠](/problems/dui-lie-de-zui-da-zhi-lcof)

</div>

</details>
</div>

