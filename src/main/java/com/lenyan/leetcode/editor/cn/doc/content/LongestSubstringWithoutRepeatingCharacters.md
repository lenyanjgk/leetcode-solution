<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长 <span data-keyword="substring-nonempty">子串</span></strong><strong>&nbsp;</strong>的长度。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "abcabcbb"
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <span><code>"abc"</code></span>，所以其长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "bbbbb"
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <span><code>"b"</code></span>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>s = "pwwkew"
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<span><code>"wke"</code></span>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<span><code>"pwke"</code></span>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 10343, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

这题比其他滑动窗口的题目简单，连 `need` 和 `valid` 都不需要，而且更新窗口内数据也只需要简单的更新计数器 `window` 即可。

当 `window[c]` 值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动 `left` 缩小窗口了。

另外，要在收缩窗口完成后更新 `res`，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复。

**详细题解：[滑动窗口解题套路框架](https://labuladong.online/algo/essential-technique/sliding-window-framework/)**

</div>

**标签：[滑动窗口](https://labuladong.online/algo/)**

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
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;

        int left = 0, right = 0;
        // 记录结果
        int res = 0;
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;
            // 判断左侧窗口是否要收缩
            while (window[c] > 1) {
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                window[d]--;
            }
            // 在这里更新答案
            res = max(res, right - left);
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
    # 区间调度问题
    def findMinArrowShots(self, intvs: List[List[int]]) -> int:
        if not intvs:
            return 0
        # 按 end 升序排序
        intvs.sort(key=lambda x: x[1])
        # 至少有一个区间不相交
        count = 1
        # 排序后，第一个区间就是 x
        x_end = intvs[0][1]
        for interval in intvs:
            start = interval[0]
            # 把 >= 改成 > 就行了
            if start > x_end:
                count += 1
                x_end = interval[1]
        return count
    
    # 无重复字符的最长子串
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_map = {}
        left = 0
        max_length = 0
        
        for right in range(len(s)):
            if s[right] in char_map and char_map[s[right]] >= left:
                left = char_map[s[right]] + 1
            char_map[s[right]] = right
            max_length = max(max_length, right - left + 1)
        
        return max_length
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        // 记录结果
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.get(d) - 1);
            }
            // 在这里更新答案
            res = Math.max(res, right - left);
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

func lengthOfLongestSubstring(s string) int {
    window := make(map[rune]int)

    left, right := 0, 0
    // 记录结果
    res := 0
    for right < len(s) {
        c := rune(s[right])
        right++
        // 进行窗口内数据的一系列更新
        window[c] = window[c] + 1
        // 判断左侧窗口是否要收缩
        for window[c] > 1 {
            d := rune(s[left])
            left++
            // 进行窗口内数据的一系列更新
            window[d] = window[d] - 1
        }
        // 在这里更新答案
        if res < right-left {
            res = right - left
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

var lengthOfLongestSubstring = function(s) {
    let window = new Map();

    let left = 0, right = 0;
    // 记录结果
    let res = 0;
    while (right < s.length) {
        let c = s.charAt(right);
        right++;
        // 进行窗口内数据的一系列更新
        window.set(c, (window.get(c) || 0) + 1);
        // 判断左侧窗口是否要收缩
        while (window.get(c) > 1) {
            let d = s.charAt(left);
            left++;
            // 进行窗口内数据的一系列更新
            window.set(d, window.get(d) - 1);
        }
        // 在这里更新答案
        res = Math.max(res, right - left);
    }
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_longest-substring-without-repeating-characters" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-substring-without-repeating-characters"></div></div>
</details><hr /><br />

**类似题目**：
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
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

