<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong><span data-keyword="anagram">异位词</span>&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "cbaebabacd", p = "abc"
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "abab", p = "ab"
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 1515, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

这题和 [567. 字符串的排列](/problems/permutation-in-string) 一样，只不过找到一个合法异位词（排列）之后将它的起始索引加入结果列表即可。

滑动窗口算法难度略高，具体的算法原理以及算法模板见详细题解。

**详细题解：[滑动窗口解题套路框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/)**

</div>

**标签：[数组双指针](https://labuladong.online/algo/)，[滑动窗口](https://labuladong.online/algo/)**

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
#include <string>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string t) {
        unordered_map<char, int> need;
        unordered_map<char, int> window;
        for (char c : t) {
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        vector<int> res;
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.size()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.push_back(left);
                }
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                if (need.count(d)) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
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

from collections import deque, Counter
from typing import List

class Solution:
    # 查找字符串中所有字母异位词
    def findAnagrams(self, s: str, p: str) -> List[int]:
        res = []
        p_count = Counter(p)
        s_count = Counter()
        
        # 滑动窗口模板
        for i in range(len(s)):
            # 扩大窗口，更新窗口最值
            s_count[s[i]] += 1
            if i >= len(p):
                # 缩小窗口，更新窗口最值
                if s_count[s[i - len(p)]] == 1:
                    del s_count[s[i - len(p)]]
                else:
                    s_count[s[i - len(p)]] -= 1
            # 在窗口收缩判断完之后才更新答案
            if s_count == p_count:
                res.append(i - len(p) + 1)
        return res

class MonotonicQueue:
    # 单调队列的通用实现，可以高效维护最大值和最小值
    # 由于我这里考虑了泛型和通用性，所以提交的性能会略差，你可自行精简
    def __init__(self):
        self.deque = deque()
    
    def push(self, value: int):
        while self.deque and self.deque[-1] < value:
            self.deque.pop()
        self.deque.append(value)
    
    def pop(self, value: int):
        if self.deque and self.deque[0] == value:
            self.deque.popleft()
    
    def max(self) -> int:
        return self.deque[0]
    
    def min(self) -> int:
        return self.deque[-1]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
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

func findAnagrams(s string, t string) []int {
    need := make(map[rune]int)
    window := make(map[rune]int)
    for _, c := range t {
        need[c] = need[c] + 1
    }

    left, right, valid := 0, 0, 0
    // 记录结果
    res := []int{}
    for right < len(s) {
        c := rune(s[right])
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c] = window[c] + 1
            if window[c] == need[c] {
                valid++
            }
        }
        // 判断左侧窗口是否要收缩
        for right-left >= len(t) {
            // 当窗口符合条件时，把起始索引加入 res
            if valid == len(need) {
                res = append(res, left)
            }
            d := rune(s[left])
            left++
            // 进行窗口内数据的一系列更新
            if _, ok := need[d]; ok {
                if window[d] == need[d] {
                    valid--
                }
                window[d] = window[d] - 1
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

var findAnagrams = function(s, t) {
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录结果
    let res = [];
    while (right < s.length) {
        let c = s[right];
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }
        // 判断左侧窗口是否要收缩
        while (right - left >= t.length) {
            // 当窗口符合条件时，把起始索引加入 res
            if (valid === need.size) {
                res.push(left);
            }
            let d = s[left];
            left++;
            // 进行窗口内数据的一系列更新
            if (need.has(d)) {
                if (window.get(d) === need.get(d)) {
                    valid--;
                }
                window.set(d, window.get(d) - 1);
            }
        }
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_find-all-anagrams-in-a-string" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-all-anagrams-in-a-string"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</div>

</details>
</div>

