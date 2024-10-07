<p>给你一个 <strong>无重复元素</strong> 的整数数组&nbsp;<code>candidates</code> 和一个目标整数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中可以使数字和为目标数&nbsp;<code>target</code> 的 所有<em>&nbsp;</em><strong>不同组合</strong> ，并以列表形式返回。你可以按 <strong>任意顺序</strong> 返回这些组合。</p>

<p><code>candidates</code> 中的 <strong>同一个</strong> 数字可以 <strong>无限制重复被选取</strong> 。如果至少一个数字的被选数量不同，则两种组合是不同的。&nbsp;</p>

<p>对于给定的输入，保证和为&nbsp;<code>target</code> 的不同组合数少于 <code>150</code> 个。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>candidates = <span><code>[2,3,6,7], </code></span>target = <span><code>7</code></span>
<strong>输出：</strong>[[2,2,3],[7]]
<strong>解释：</strong>
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2,3,5]<span><code>, </code></span>target = 8
<strong>输出: </strong>[[2,2,2,2],[2,3,3],[3,5]]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong>candidates = <span><code>[2], </code></span>target = 1
<strong>输出: </strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= candidates.length &lt;= 30</code></li> 
 <li><code>2 &lt;= candidates[i] &lt;= 40</code></li> 
 <li><code>candidates</code> 的所有元素 <strong>互不相同</strong></li> 
 <li><code>1 &lt;= target &lt;= 40</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2900, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

你需要先看前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)，然后看这道题就很简单了，无非是回溯算法的运用而已。

这道题的关键在于 `candidates` 中的元素可以复用多次，体现在代码中是下面这段：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

对比 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/) 中不能重复使用元素的标准组合问题：

```java
void backtrack(int[] candidates, int start, int target, int sum) {
    // 回溯算法框架
    for (int i = start; i < candidates.length; i++) {
        // 选择 candidates[i]
        backtrack(candidates, i + 1, target, sum);
        // 撤销选择 candidates[i]
    }
}
```

体会到控制是否重复使用元素的关键了吗？

- **详细题解**：
  - [回溯算法秒杀所有排列/组合/子集问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)

</div>

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
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution {
public:
    vector<vector<int>> res;

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if (candidates.empty()) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    vector<int> track;

    // 回溯算法主函数
    void backtrack(vector<int>& candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.push_back(track);
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.size(); i++) {
            // 选择 candidates[i]
            track.push_back(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.pop_back();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def __init__(self):
        self.res = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return self.res
        self.backtrack(candidates, 0, target, 0)
        return self.res

    # 记录回溯的路径
    track = []

    # 回溯算法主函数
    def backtrack(self, candidates: List[int], start: int, target: int, sum: int) -> None:
        if sum == target:
            # 找到目标和
            self.res.append(self.track.copy())
            return
        if sum > target:
            # 超过目标和，直接结束
            return

        # 回溯算法框架
        for i in range(start, len(candidates)):
            # 选择 candidates[i]
            self.track.append(candidates[i])
            sum += candidates[i]
            # 递归遍历下一层回溯树
            self.backtrack(candidates, i, target, sum)
            # 撤销选择 candidates[i]
            sum -= candidates[i]
            self.track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 记录回溯的路径
    LinkedList<Integer> track = new LinkedList<>();

    // 回溯算法主函数
    void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            // 找到目标和
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            // 超过目标和，直接结束
            return;
        }

        // 回溯算法框架
        for (int i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.add(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(candidates, i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.removeLast();
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

import (
	"container/list"
)

// combinationSum ...
func combinationSum(candidates []int, target int) [][]int {
	res := make([][]int, 0)
	backtrack(candidates, 0, target, 0, list.New(), &res)
	return res
}

// 记录回溯的路径
// 回溯算法主函数
func backtrack(candidates []int, start, target, sum int, track *list.List, res *[][]int) {
	if sum == target {
		// 找到目标和
		temp := make([]int, track.Len())
		for i, e := 0, track.Front(); e != nil; i, e = i+1, e.Next() {
			temp[i] = e.Value.(int)
		}
		*res = append(*res, temp)
		return
	}

	if sum > target {
		// 超过目标和，直接结束
		return
	}

	// 回溯算法框架
	for i := start; i < len(candidates); i++ {
		// 选择 candidates[i]
		track.PushBack(candidates[i])
		sum += candidates[i]
		// 递归遍历下一层回溯树
		backtrack(candidates, i, target, sum, track, res)
		// 撤销选择 candidates[i]
		sum -= candidates[i]
		track.Remove(track.Back())
	}
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var combinationSum = function(candidates, target) {
    // 记录所有可能的组合结果
    let res = [];
    // 记录回溯的路径
    let track = [];

    // 回溯算法主函数
    function backtrack(start, target, sum) {
        // 找到目标和
        if (sum === target) {
            res.push([...track]);
            return;
        }

        // 超过目标和，直接结束
        if (sum > target) {
            return;
        }

        // 回溯算法框架
        for (let i = start; i < candidates.length; i++) {
            // 选择 candidates[i]
            track.push(candidates[i]);
            sum += candidates[i];
            // 递归遍历下一层回溯树
            backtrack(i, target, sum);
            // 撤销选择 candidates[i]
            sum -= candidates[i];
            track.pop();
        }
    }

    backtrack(0, target, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_combination-sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_combination-sum"></div></div>
</details><hr /><br />

</div>

</details>
</div>

