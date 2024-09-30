<p>给你一个整数数组 <code>nums</code> ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>

<p><strong><span data-keyword="subarray-nonempty">子数组 </span></strong>是数组中的一个连续部分。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>输出：</strong>6
<strong>解释：</strong>连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,-1,7,8]
<strong>输出：</strong>23
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果你已经实现复杂度为 <code>O(n)</code> 的解法，尝试使用更为精妙的 <strong>分治法</strong> 求解。</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 分治 | 动态规划</details><br>

<div>👍 6794, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/dynamic-programming/maximum-subarray/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这题类似 [300. 最长递增子序列](/problems/longest-increasing-subsequence)，`dp` 数组的含义：

**以 `nums[i]` 为结尾的「最大子数组和」为 `dp[i]`**。

`dp[i]` 有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；要么不与前面的子数组连接，自成一派，自己作为一个子数组。

在这两种选择中择优，就可以计算出最大子数组，而且空间复杂度还有优化空间，见详细题解。

**详细题解：[动态规划设计：最大子数组](https://labuladong.online/algo/dynamic-programming/maximum-subarray/)**

</div>

**标签：[一维动态规划](https://labuladong.online/algo/)，[动态规划](https://labuladong.online/algo/)，[数组](https://labuladong.online/algo/)**

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
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;
        vector<int> dp(n);
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = INT_MIN;
        for (int i = 0; i < n; i++) {
            res = max(res, dp[i]);
        }
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
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        dp = [0] * n
        # base case
        # 第一个元素前面没有子数组
        dp[0] = nums[0]
        # 状态转移方程
        for i in range(1, n):
            dp[i] = max(nums[i], nums[i] + dp[i - 1])
        # 得到 nums 的最大子数组
        res = float('-inf')
        for i in range(n):
            res = max(res, dp[i])
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func maxSubArray(nums []int) int {
    n := len(nums)
    if n == 0 {
        return 0
    }
    dp := make([]int, n)
    // base case
    // 第一个元素前面没有子数组
    dp[0] = nums[0]
    // 状态转移方程
    for i := 1; i < n; i++ {
        dp[i] = max(nums[i], nums[i] + dp[i-1])
    }
    // 得到 nums 的最大子数组
    res := math.MinInt
    for i := 0; i < n; i++ {
        res = max(res, dp[i])
    }
    return res
}

// Helper function to get the max of two integers
func max(x, y int) int {
    if x > y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var maxSubArray = function(nums) {
    const n = nums.length;
    if (n === 0) return 0;
    const dp = new Array(n);
    // base case
    // 第一个元素前面没有子数组
    dp[0] = nums[0];
    // 状态转移方程
    for (let i = 1; i < n; i++) {
        dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
    }
    // 得到 nums 的最大子数组
    let res = -Infinity;
    for (let i = 0; i < n; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_maximum-subarray" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_maximum-subarray"></div></div>
</details><hr /><br />

**类似题目**：
  - [152. 乘积最大子数组 🟠](/problems/maximum-product-subarray)
  - [209. 长度最小的子数组 🟠](/problems/minimum-size-subarray-sum)
  - [918. 环形子数组的最大和 🟠](/problems/maximum-sum-circular-subarray)
  - [剑指 Offer 42. 连续子数组的最大和 🟢](/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof)
  - [剑指 Offer II 008. 和大于等于 target 的最短子数组 🟠](/problems/2VG8Kg)

</div>

</details>
</div>

