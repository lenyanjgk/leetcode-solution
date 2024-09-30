<p>以数组 <code>intervals</code> 表示若干个区间的集合，其中单个区间为 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> 。请你合并所有重叠的区间，并返回&nbsp;<em>一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间</em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>输出：</strong>[[1,6],[8,10],[15,18]]
<strong>解释：</strong>区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>intervals = [[1,4],[4,5]]
<strong>输出：</strong>[[1,5]]
<strong>解释：</strong>区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>intervals[i].length == 2</code></li> 
 <li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 排序</details><br>

<div>👍 2428, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/interval-problem-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

一个区间可以表示为 `[start, end]`，先按区间的 `start` 排序：

![](https://labuladong.online/algo/images/mergeInterval/1.jpg)

**显然，对于几个相交区间合并后的结果区间 `x`，`x.start` 一定是这些相交区间中 `start` 最小的，`x.end` 一定是这些相交区间中 `end` 最大的**：

![](https://labuladong.online/algo/images/mergeInterval/2.jpg)

由于已经排了序，`x.start` 很好确定，求 `x.end` 也很容易，可以类比在数组中找最大值的过程。

**详细题解：[一个方法解决三道区间问题](https://labuladong.online/algo/practice-in-action/interval-problem-summary/)**

</div>

**标签：[区间问题](https://labuladong.online/algo/)，排序**

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
    std::vector<std::vector<int>> merge(std::vector<std::vector<int>>& intervals) {
        std::vector<std::vector<int>> res;
        // 按区间的 start 升序排列
        std::sort(intervals.begin(), intervals.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
            return a[0] < b[0];
        });

        res.push_back(intervals[0]);
        for (int i = 1; i < intervals.size(); i++) {
            std::vector<int> curr = intervals[i];
            // res 中最后一个元素的引用
            std::vector<int>& last = res.back();
            if (curr[0] <= last[1]) {
                last[1] = std::max(last[1], curr[1]);
            } else {
                // 处理下一个待合并区间
                res.push_back(curr);
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
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        # 按区间的 start 升序排列
        intervals.sort(key=lambda x: x[0])

        res.append(intervals[0])
        for i in range(1, len(intervals)):
            curr = intervals[i]
            # res 中最后一个元素的引用
            last = res[-1]
            if curr[0] <= last[1]:
                last[1] = max(last[1], curr[1])
            else:
                # 处理下一个待合并区间
                res.append(curr)
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 按区间的 start 升序排列
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // res 中最后一个元素的引用
            int[] last = res.getLast();
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // 处理下一个待合并区间
                res.add(curr);
            }
        }
        return res.toArray(new int[0][0]);
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

type Intervals [][]int

func (ivs Intervals) Len() int { return len(ivs) }
func (ivs Intervals) Swap(i, j int) { ivs[i], ivs[j] = ivs[j], ivs[i] }
func (ivs Intervals) Less(i, j int) bool { return ivs[i][0] < ivs[j][0] }

func merge(intervals [][]int) [][]int {
    // 按区间的 start 升序排列
    sort.Sort(Intervals(intervals))
    
    var res [][]int
    res = append(res, intervals[0])
    
    for i := 1; i < len(intervals); i++ {
        curr := intervals[i]
        // res 中最后一个元素的引用
        last := res[len(res)-1]
        if curr[0] <= last[1] {
            last[1] = max(last[1], curr[1])
        } else {
            // 处理下一个待合并区间
            res = append(res, curr)
        }
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
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var merge = function(intervals) {
    let res = [];
    // 按区间的 start 升序排列
    intervals.sort((a, b) => a[0] - b[0]);

    res.push(intervals[0]);
    for (let i = 1; i < intervals.length; i++) {
        let curr = intervals[i];
        // res 中最后一个元素的引用
        let last = res[res.length - 1];
        if (curr[0] <= last[1]) {
            last[1] = Math.max(last[1], curr[1]);
        } else {
            // 处理下一个待合并区间
            res.push(curr);
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_merge-intervals" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_merge-intervals"></div></div>
</details><hr /><br />

**类似题目**：
  - [1288. 删除被覆盖区间 🟠](/problems/remove-covered-intervals)
  - [986. 区间列表的交集 🟠](/problems/interval-list-intersections)
  - [剑指 Offer II 074. 合并区间 🟠](/problems/SsGoHC)

</div>

</details>
</div>

