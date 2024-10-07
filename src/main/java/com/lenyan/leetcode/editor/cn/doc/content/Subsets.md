<p>给你一个整数数组&nbsp;<code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的<span data-keyword="subset">子集</span>（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[[],[0]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 回溯</details><br>

<div>👍 2370, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/two-views-of-backtrack/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

有两种方法解决这道题，这里主要说回溯算法思路，因为比较通用，可以套前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 写过回溯算法模板。

本质上子集问题就是遍历这样用一棵回溯树：

![](https://labuladong.online/algo/images/子集/1.jpg)

- **详细题解**：
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

class Solution {
private:
    vector<vector<int>> res;

public:
    vector<vector<int>> subsets(vector<int>& nums) {
        // 记录走过的路径
        vector<int> track;
        backtrack(nums, 0, track);
        return res;
    }

private:
    void backtrack(vector<int>& nums, int start, vector<int>& track) {
        res.push_back(track);
        for (int i = start; i < nums.size(); i++) {
            // 做选择
            track.push_back(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track);
            // 撤销选择
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

    def subsets(self, nums: List[int]) -> List[List[int]]:
        # 记录走过的路径
        track = []
        self.backtrack(nums, 0, track)
        return self.res

    def backtrack(self, nums: List[int], start: int, track: List[int]) -> None:
        self.res.append(track[:])
        for i in range(start, len(nums)):
            # 做选择
            track.append(nums[i])
            # 回溯
            self.backtrack(nums, i + 1, track)
            # 撤销选择
            track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 记录走过的路径
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track);
            // 撤销选择
            track.remove(track.size() - 1);
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

func subsets(nums []int) [][]int {
    res = [][]int{}
    // 记录走过的路径
    track := []int{}
    backtrack(nums, 0, track)
    return res
}

func backtrack(nums []int, start int, track []int) {
    temp := make([]int, len(track))
    copy(temp, track)
    res = append(res, temp)
    for i := start; i < len(nums); i++ {
        // 做选择
        track = append(track, nums[i])
        // 回溯
        backtrack(nums, i+1, track)
        // 撤销选择
        track = track[:len(track)-1]
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var subsets = function(nums) {
    let res = [];
    
    var backtrack = function(start, track) {
        // 到达树的底部
        res.push([...track]);
        
        // 注意 i 从 start 开始递增
        for (let i = start; i < nums.length; i++) {
            // 做选择
            track.push(nums[i]);
            backtrack(i + 1, track);
            // 撤销选择
            track.pop();
        }
    }
    
    let track = [];
    backtrack(0, track);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_subsets" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_subsets"></div></div>
</details><hr /><br />

</div>

</details>
</div>

