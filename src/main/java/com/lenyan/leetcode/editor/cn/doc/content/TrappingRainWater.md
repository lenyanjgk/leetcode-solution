<p>给定&nbsp;<code>n</code> 个非负整数表示每个宽度为 <code>1</code> 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png" style="height: 161px; width: 412px;" /></p>

<pre>
<strong>输入：</strong>height = [0,1,0,2,1,0,1,3,2,1,2,1]
<strong>输出：</strong>6
<strong>解释：</strong>上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>height = [4,2,0,3,2,5]
<strong>输出：</strong>9
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == height.length</code></li> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= height[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 双指针 | 动态规划 | 单调栈</details><br>

<div>👍 5320, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/trapping-rain-water/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

对于任意一个位置 `i`，能够装的水为：

```python
water[i] = min(
           # 左边最高的柱子
           max(height[0..i]),
           # 右边最高的柱子
           max(height[i..end])
        ) - height[i]
```

![](https://labuladong.online/algo/images/接雨水/1.jpg)

**关键在于，如何能够快速计算出某一个位置左侧所有柱子的最大高度和右侧所有柱子的最大高度**。

这道题的解法比较多样，可以预计算数组，可以用 [双指技巧](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/)，可以用[单调栈技巧](https://labuladong.online/algo/data-structure/monotonic-stack/)，这里就说一个最简单的解法，用预计算的方式求解，优化暴力解法的时间复杂度，更多解法请看详细题解。

**详细题解：[如何高效解决接雨水问题](https://labuladong.online/algo/frequency-interview/trapping-rain-water/)**

</div>

**标签：[数组双指针](https://labuladong.online/algo/)**

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

#include <vector>
#include <algorithm>

class Solution {
public:
    int trap(std::vector<int>& height) {
        if (height.empty()) {
            return 0;
        }
        int n = height.size();
        int res = 0;
        // 数组充当备忘录
        std::vector<int> l_max(n);
        std::vector<int> r_max(n);
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = std::max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = std::max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += std::min(l_max[i], r_max[i]) - height[i];
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
    def trap(self, height):
        if len(height) == 0:
            return 0
        n = len(height)
        res = 0
        # 数组充当备忘录
        l_max = [0] * n
        r_max = [0] * n
        # 初始化 base case
        l_max[0] = height[0]
        r_max[n - 1] = height[n - 1]
        # 从左向右计算 l_max
        for i in range(1, n):
            l_max[i] = max(height[i], l_max[i - 1])
        # 从右向左计算 r_max
        for i in range(n - 2, -1, -1):
            r_max[i] = max(height[i], r_max[i + 1])
        # 计算答案
        for i in range(1, n - 1):
            res += min(l_max[i], r_max[i]) - height[i]
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];/**<extend up -300>![](https://labuladong.online/algo/images/接雨水/1.jpg) */
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func trap(height []int) int {
    if len(height) == 0 {
        return 0
    }
    n := len(height)
    res := 0
    // 数组充当备忘录
    l_max := make([]int, n)
    r_max := make([]int, n)
    // 初始化 base case
    l_max[0] = height[0]
    r_max[n-1] = height[n-1]
    // 从左向右计算 l_max
    for i := 1; i < n; i++ {
        l_max[i] = max(height[i], l_max[i-1])
    }
    // 从右向左计算 r_max
    for i := n - 2; i >= 0; i-- {
        r_max[i] = max(height[i], r_max[i+1])
    }
    // 计算答案
    for i := 1; i < n - 1; i++ {
        res += min(l_max[i], r_max[i]) - height[i]
    }
    return res
}

// Helper function to find the maximum of two integers
func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}

// Helper function to find the minimum of two integers
func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var trap = function(height) {
    if (height.length === 0) {
        return 0;
    }
    const n = height.length;
    let res = 0;
    // 数组充当备忘录
    const l_max = new Array(n);
    const r_max = new Array(n);
    // 初始化 base case
    l_max[0] = height[0];
    r_max[n - 1] = height[n - 1];
    // 从左向右计算 l_max
    for (let i = 1; i < n; i++)
        l_max[i] = Math.max(height[i], l_max[i - 1]);
    // 从右向左计算 r_max
    for (let i = n - 2; i >= 0; i--)
        r_max[i] = Math.max(height[i], r_max[i + 1]);
    // 计算答案
    for (let i = 1; i < n - 1; i++)
        res += Math.min(l_max[i], r_max[i]) - height[i];
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_trapping-rain-water" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_trapping-rain-water"></div></div>
</details><hr /><br />

**类似题目**：
  - [11. 盛最多水的容器 🟠](/problems/container-with-most-water)

</div>

</details>
</div>

