<p>给你一个字符串 <code>s</code> 、一个字符串 <code>t</code> 。返回 <code>s</code> 中涵盖 <code>t</code> 所有字符的最小子串。如果 <code>s</code> 中不存在涵盖 <code>t</code> 所有字符的子串，则返回空字符串 <code>""</code> 。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong></p>

<ul> 
 <li>对于 <code>t</code> 中重复字符，我们寻找的子字符串中该字符数量必须不少于 <code>t</code> 中该字符数量。</li> 
 <li>如果 <code>s</code> 中存在这样的子串，我们保证它是唯一的答案。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "ADOBECODEBANC", t = "ABC"
<strong>输出：</strong>"BANC"
<strong>解释：</strong>最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a", t = "a"
<strong>输出：</strong>"a"
<strong>解释：</strong>整个字符串 s 是最小覆盖子串。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> s = "a", t = "aa"
<strong>输出:</strong> ""
<strong>解释:</strong> t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code><sup>m == s.length</sup></code></li> 
 <li><code><sup>n == t.length</sup></code></li> 
 <li><code>1 &lt;= m, n &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> 和 <code>t</code> 由英文字母组成</li> 
</ul>

<p>&nbsp;</p> 
<strong>进阶：</strong>你能设计一个在 
<code>o(m+n)</code> 时间内解决此问题的算法吗？

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>

<div>👍 3006, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/essential-technique/sliding-window-framework/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

这题就是典型的滑动窗口类题目，一般来说难度略高，解法框架如下：

```java
int left = 0, right = 0;

while (right < nums.size()) {
    // 增大窗口
    window.addLast(nums[right]);
    right++;
    
    while (window needs shrink) {
        // 缩小窗口
        window.removeFirst(nums[left]);
        left++;
    }
}
```

具体的算法原理看详细题解吧，这里写不下。

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

class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) {
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = INT_MAX;

        while (right < s.size()) {
            // c 是将移入窗口的字符
            char c = s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.count(c)) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s[left];
                // 左移窗口
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
        // 返回最小覆盖子串
        return len == INT_MAX ? "" : s.substr(start, len);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 记录前缀和
    # 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        
        from collections import Counter
        
        # Create a map to count all characters in t
        map_t = Counter(t)
        required = len(t)
        
        left = 0
        right = 0
        min_len = float("inf")
        min_start = 0
        
        while right < len(s):
            char_right = s[right]
            if char_right in map_t:
                if map_t[char_right] > 0:
                    required -= 1
                map_t[char_right] -= 1
            right += 1
            
            while required == 0:
                # 前序遍历位置
                if right - left < min_len:
                    min_len = right - left
                    min_start = left
                
                char_left = s[left]
                if char_left in map_t:
                    map_t[char_left] += 1
                    if map_t[char_left] > 0:
                        required += 1
                left += 1
        
        # 从二叉树的根节点开始，路径和为 pathSum - targetSum 的路径条数
        # 就是路径和为 targetSum 的路径条数
        # 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数

        # 后序遍历位置
        return "" if min_len == float("inf") else s[min_start:min_start + min_len]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
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
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func minWindow(s string, t string) string {
    need := make(map[rune]int)
    window := make(map[rune]int)
    for _, c := range t {
        need[c] = need[c] + 1
    }

    left, right := 0, 0
    valid := 0
    // 记录最小覆盖子串的起始索引及长度
    start, length := 0, int(^uint(0) >> 1)

    for right < len(s) {
        // c 是将移入窗口的字符
        c := rune(s[right])
        // 右移窗口
        right++
        // 进行窗口内数据的一系列更新
        if _, ok := need[c]; ok {
            window[c] = window[c] + 1
            if window[c] == need[c] {
                valid++
            }
        }

        // 判断左侧窗口是否要收缩
        for valid == len(need) {
            // 在这里更新最小覆盖子串
            if right-left < length {
                start = left
                length = right - left
            }
            // d 是将移出窗口的字符
            d := rune(s[left])
            // 左移窗口
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

    // 返回最小覆盖子串
    if length == int(^uint(0)>>1) {
        return ""
    }
    return s[start : start+length]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var minWindow = function(s, t) {
    let need = new Map();
    let window = new Map();
    for (let c of t) {
        need.set(c, (need.get(c) || 0) + 1);
    }

    let left = 0, right = 0;
    let valid = 0;
    // 记录最小覆盖子串的起始索引及长度
    let start = 0, len = Infinity;

    while (right < s.length) {
        // c 是将移入窗口的字符
        let c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        if (need.has(c)) {
            window.set(c, (window.get(c) || 0) + 1);
            if (window.get(c) === need.get(c)) {
                valid++;
            }
        }

        // 判断左侧窗口是否要收缩
        while (valid === need.size) {
            // 在这里更新最小覆盖子串
            if (right - left < len) {
                start = left;
                len = right - left;
            }
            // d 是将移出窗口的字符
            let d = s[left];
            // 左移窗口
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
    // 返回最小覆盖子串
    return len === Infinity ? "" : s.substring(start, start + len);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_minimum-window-substring" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-window-substring"></div></div>
</details><hr /><br />

**类似题目**：
  - [3. 无重复字符的最长子串 🟠](/problems/longest-substring-without-repeating-characters)
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</div>

</details>
</div>

