<p>给你一个整数数组 <code>nums</code> ，判断是否存在三元组 <code>[nums[i], nums[j], nums[k]]</code> 满足 <code>i != j</code>、<code>i != k</code> 且 <code>j != k</code> ，同时还满足 <code>nums[i] + nums[j] + nums[k] == 0</code> 。请你返回所有和为 <code>0</code> 且不重复的三元组。</p>

<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
<strong>解释：</strong>
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,1]
<strong>输出：</strong>[]
<strong>解释：</strong>唯一可能的三元组和不为 0 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,0]
<strong>输出：</strong>[[0,0,0]]
<strong>解释：</strong>唯一可能的三元组和为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>3 &lt;= nums.length &lt;= 3000</code></li> 
 <li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 7071, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/nsum/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

nSum 系列问题的核心思路就是**排序 + 双指针**。

先给数组从小到大排序，然后双指针 `lo` 和 `hi` 分别在数组开头和结尾，这样就可以控制 `nums[lo]` 和 `nums[hi]` 这两数之和的大小：

如果你想让它俩的和大一些，就让 `lo++`，如果你想让它俩的和小一些，就让 `hi--`。

![](https://labuladong.online/algo/images/nSum/1.jpeg)

基于两数之和可以得到一个万能函数 `nSumTarget`，扩展出 n 数之和的解法，具体分析见详细题解。

**详细题解：[一个方法团灭 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/)**

</div>

**标签：[数组双指针](https://labuladong.online/algo/)，递归**

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
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        // n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return nSumTarget(nums, 3, 0, 0);
    }

private:
    // 注意：调用这个函数之前一定要先给 nums 排序
    // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    vector<vector<int>> nSumTarget(vector<int>& nums, int n, int start, long long target) {
        int sz = nums.size();
        vector<vector<int>> res;
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case
        if (n == 2) {
            // 双指针那一套操作
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.push_back({left, right});
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; ++i) {
                vector<vector<int>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (auto& arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.push_back(nums[i]);
                    res.push_back(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) ++i;
            }
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

from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        # n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return self.nSumTarget(nums, 3, 0, 0)

    # 注意：调用这个函数之前一定要先给 nums 排序
    # n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    def nSumTarget(self, nums: List[int], n: int, start: int, target: int) -> List[List[int]]:
        sz = len(nums)
        res = []
        # 至少是 2Sum，且数组大小不应该小于 n
        if n < 2 or sz < n:
            return res
        # 2Sum 是 base case
        if n == 2:
            # 双指针那一套操作
            lo, hi = start, sz - 1
            while lo < hi:
                sum_val = nums[lo] + nums[hi]
                left, right = nums[lo], nums[hi]
                if sum_val < target:
                    while lo < hi and nums[lo] == left:
                        lo += 1
                elif sum_val > target:
                    while lo < hi and nums[hi] == right:
                        hi -= 1
                else:
                    res.append([left, right])
                    while lo < hi and nums[lo] == left:
                        lo += 1
                    while lo < hi and nums[hi] == right:
                        hi -= 1
        else:
            # n > 2 时，递归计算 (n-1)Sum 的结果
            for i in range(start, sz):
                # Skip the duplicate element to avoid duplicate triplet
                if i > start and nums[i] == nums[i - 1]:
                    continue
                sub = self.nSumTarget(nums, n - 1, i + 1, target - nums[i])
                for arr in sub:
                    # (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.append(nums[i])
                    res.append(arr)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // n 为 3，从 nums[0] 开始计算和为 0 的三元组
        return nSumTarget(nums, 3, 0, 0);
    }

    // 注意：调用这个函数之前一定要先给 nums 排序
    // n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 至少是 2Sum，且数组大小不应该小于 n
        if (n < 2 || sz < n) return res;
        // 2Sum 是 base case
        if (n == 2) {
            // 双指针那一套操作
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            // n > 2 时，递归计算 (n-1)Sum 的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.add(nums[i]);
                    res.add(arr);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
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

import (
	"sort"
)

// nSumTarget(nums, 3, 0, 0)
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	// n 为 3，从 nums[0] 开始计算和为 0 的三元组
	return nSumTarget(nums, 3, 0, 0)
}

// 注意：调用这个函数之前一定要先给 nums 排序
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
func nSumTarget(nums []int, n int, start int, target int64) [][]int {
	sz := len(nums)
	var res [][]int
	// 至少是 2Sum，且数组大小不应该小于 n
	if n < 2 || sz < n {
		return res
	}
	// 2Sum 是 base case
	if n == 2 {
		// 双指针那一套操作
		lo, hi := start, sz-1
		for lo < hi {
			sum := nums[lo] + nums[hi]
			if sum < int(target) {
				lo++
			} else if sum > int(target) {
				hi--
			} else {
				res = append(res, []int{nums[lo], nums[hi]})
				lo++
				hi--
				// Skip duplicates
				for lo < hi && nums[lo] == nums[lo-1] {
					lo++
				}
				for lo < hi && nums[hi] == nums[hi+1] {
					hi--
				}
			}
		}
	} else {
		// n > 2 时，递归计算 (n-1)Sum 的结果
		for i := start; i < sz; i++ {
			if i > start && nums[i] == nums[i-1] {
				continue
			}
			sub := nSumTarget(nums, n-1, i+1, target-int64(nums[i]))
			for _, arr := range sub {
				// (n-1)Sum 加上 nums[i] 就是 nSum
				res = append(res, append(arr, nums[i]))
			}
		}
	}
	return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var threeSum = function(nums) {
    nums.sort((a, b) => a - b);
    // n 为 3，从 nums[0] 开始计算和为 0 的三元组
    return nSumTarget(nums, 3, 0, 0);
};

// 注意：调用这个函数之前一定要先给 nums 排序
// n 填写想求的是几数之和，start 从哪个索引开始计算（一般填 0），target 填想凑出的目标和
function nSumTarget(nums, n, start, target) {
    const sz = nums.length;
    let res = [];
    // 至少是 2Sum，且数组大小不应该小于 n
    if (n < 2 || sz < n) return res;
    // 2Sum 是 base case
    if (n === 2) {
        // 双指针那一套操作
        let lo = start, hi = sz - 1;
        while (lo < hi) {
            const sum = nums[lo] + nums[hi];
            const left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] === left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] === right) hi--;
            } else {
                res.push([left, right]);
                while (lo < hi && nums[lo] === left) lo++;
                while (lo < hi && nums[hi] === right) hi--;
            }
        }
    } else {
        // n > 2 时，递归计算 (n-1)Sum 的结果
        for (let i = start; i < sz; i++) {
            const sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
            for (let arr of sub) {
                // (n-1)Sum 加上 nums[i] 就是 nSum
                arr.push(nums[i]);
                res.push(arr);
            }
            while (i < sz - 1 && nums[i] === nums[i + 1]) i++;
        }
    }
    return res;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_3sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_3sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [1. 两数之和 🟢](/problems/two-sum)
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [18. 四数之和 🟠](/problems/4sum)
  - [剑指 Offer II 007. 数组中和为 0 的三个数 🟠](/problems/1fGaJU)

</div>

</details>
</div>



