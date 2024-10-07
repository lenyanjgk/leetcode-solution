<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 6</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>

<div>👍 2975, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

[回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 中就是拿这个问题来解释回溯模板的，首先画出回溯树来看一看：

![](https://labuladong.online/algo/images/子集/3.jpg)

写代码遍历这棵回溯树即可。

- **详细题解**：
  - [回溯算法解题套路框架](https://labuladong.online/algo/essential-technique/backtrack-framework/)
  - [球盒模型：回溯算法穷举的两种视角](https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/)
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

#include <vector>
#include <list>

class Solution {

    std::vector<std::vector<int>> res;

public:
    // 主函数，输入一组不重复的数字，返回它们的全排列
    std::vector<std::vector<int>> permute(std::vector<int>& nums) {
        std::list<int> track; // 记录「路径」
        std::vector<bool> used(nums.size(), false); // 「路径」中的元素会被标记为 true，避免重复使用
        
        backtrack(nums, track, used);
        return res;
    }

private:
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(const std::vector<int>& nums, std::list<int>& track, std::vector<bool>& used) {
        // 触发结束条件
        if (track.size() == nums.size()) {
            res.push_back(std::vector<int>(track.begin(), track.end()));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.push_back(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.pop_back();
            used[i] = false;
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

    # 主函数，输入一组不重复的数字，返回它们的全排列
    def permute(self, nums):
        # 记录「路径」
        track = []
        # 「路径」中的元素会被标记为 true，避免重复使用
        used = [False] * len(nums)
        
        self.backtrack(nums, track, used)
        return self.res

    # 路径：记录在 track 中
    # 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    # 结束条件：nums 中的元素全都在 track 中出现
    def backtrack(self, nums, track, used):
        # 触发结束条件
        if len(track) == len(nums):
            self.res.append(track.copy())
            return

        for i in range(len(nums)):
            # 排除不合法的选择
            if used[i]: # <extend up -200>![](https://labuladong.online/algo/images/backtracking/6.jpg) #
                # nums[i] 已经在 track 中，跳过
                continue
            # 做选择
            track.append(nums[i])
            used[i] = True
            # 进入下一层决策树
            self.backtrack(nums, track, used)
            # 取消选择
            track.pop()
            used[i] = False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();

    // 主函数，输入一组不重复的数字，返回它们的全排列
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {/**<extend up -200>![](https://labuladong.online/algo/images/backtracking/6.jpg) */
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var res [][]int

// 主函数，输入一组不重复的数字，返回它们的全排列
func permute(nums []int) [][]int {
    res = [][]int{} // Initialize the result slice
    // 记录「路径」
    var track []int
    // 「路径」中的元素会被标记为 true，避免重复使用
    used := make([]bool, len(nums))

    backtrack(nums, track, used)
    return res
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
// 结束条件：nums 中的元素全都在 track 中出现
func backtrack(nums []int, track []int, used []bool) {
    // 触发结束条件
    if len(track) == len(nums) {
        newTrack := make([]int, len(track))
        copy(newTrack, track)
        res = append(res, newTrack)
        return
    }

    for i := 0; i < len(nums); i++ {
        // 排除不合法的选择
        if used[i] {
            // nums[i] 已经在 track 中，跳过
            continue
        }
        // 做选择
        track = append(track, nums[i])
        used[i] = true
        // 进入下一层决策树
        backtrack(nums, track, used)
        // 取消选择
        track = track[:len(track)-1]
        used[i] = false
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var permute = function(nums) {
    // 主函数，输入一组不重复的数字，返回它们的全排列
    let res = [];
    // 记录「路径」
    let track = [];
    // 「路径」中的元素会被标记为 true，避免重复使用
    let used = Array(nums.length).fill(false);

    // @visualize status(track)
    function backtrack(nums, track, used) {
        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
        // 结束条件：nums 中的元素全都在 track 中出现
        if (track.length === nums.length) {
            // 触发结束条件
            res.push([...track]);
            return;
        }

        for (let i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            // @visualize choose(nums[i])
            track.push(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            // @visualize unchoose()
            track.pop();
            used[i] = false;
        }
    }

    backtrack(nums, track, used);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_permutations" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_permutations"></div></div>
</details><hr /><br />

</div>

</details>
</div>

