<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/11/09/200px-telephone-keypad2svg.png" style="width: 200px;" /></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>digits = "23"
<strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>digits = ""
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>digits = "2"
<strong>输出：</strong>["a","b","c"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= digits.length &lt;= 4</code></li> 
 <li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 回溯</details><br>

<div>👍 2914, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

你需要先看前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)，然后看这道题就很简单了，无非是回溯算法的运用而已。

组合问题本质上就是遍历一棵回溯树，套用回溯算法代码框架即可。

- **详细题解**：
  - [【强化练习】回溯算法经典习题 I](https://labuladong.online/algo/problem-set/backtrack-i/)

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
#include <string>
#include <unordered_map>

class Solution {
    // 每个数字到字母的映射
    std::unordered_map<char, std::string> mapping = {
        {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
        {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
    };

    std::vector<std::string> res;
    std::string sb;

public:
    std::vector<std::string> letterCombinations(std::string digits) {
        if (digits.empty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(const std::string& digits, int start) {
        if (sb.size() == digits.size()) {
            // 到达回溯树底部
            res.push_back(sb);
            return;
        }

        // 回溯算法框架
        char digit = digits[start];
        for (char c : mapping[digit]) {
            // 做选择
            sb.push_back(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.pop_back();
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
    # 每个数字到字母的映射
    mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ]

    def __init__(self):
        self.res = []
        self.sb = []

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return self.res
        # 从 digits[0] 开始进行回溯
        self.backtrack(digits, 0)
        return self.res

    # 回溯算法主函数
    def backtrack(self, digits: str, start: int) -> None:
        if len(self.sb) == len(digits):
            # 到达回溯树底部
            self.res.append(''.join(self.sb))
            return

        # 回溯算法框架
        digit = ord(digits[start]) - ord('0')
        for c in self.mapping[digit]:
            # 做选择
            self.sb.append(c)
            # 递归下一层回溯树
            self.backtrack(digits, start + 1)
            # 撤销选择
            self.sb.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 每个数字到字母的映射
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(String digits, int start) {
        if (sb.length() == digits.length()) {
            // 到达回溯树底部
            res.add(sb.toString());
            return;
        }

        // 回溯算法框架
        int digit = digits.charAt(start) - '0';
        for (char c : mapping[digit].toCharArray()) {
            // 做选择
            sb.append(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func letterCombinations(digits string) []string {
    if len(digits) == 0 {
        return []string{}
    }
    // 每个数字到字母的映射
    var mapping = []string{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
    }
    var res []string
    // 从 digits[0] 开始进行回溯
    backtrack(digits, 0, "", &res, mapping)
    return res
}

// 回溯算法主函数
func backtrack(digits string, start int, combination string, res *[]string, mapping []string) {
    if len(combination) == len(digits) {
        // 到达回溯树底部
        *res = append(*res, combination)
        return
    }

    // 回溯算法框架
    digit := digits[start] - '0'
    for _, c := range mapping[digit] {
        // 做选择
        backtrack(digits, start+1, combination+string(c), res, mapping)
        // 递归下一层回溯树
        // Note: The following comment is not needed as there is no action taken for "undo the choice"
        // 撤销选择
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var letterCombinations = function(digits) {
    // 每个数字到字母的映射
    const mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ];

    let res = [];
    let sb = "";

    if (digits === "") {
        return res;
    }

    // 从 digits[0] 开始进行回溯
    // @visualize status(sb)
    function backtrack(digits, start) {
        // 回溯算法主函数
        if (sb.length === digits.length) {
            // 到达回溯树底部
            res.push(sb);
            return;
        }

        // 回溯算法框架
        let digit = digits.charCodeAt(start) - '0'.charCodeAt(0);
        for (let c of mapping[digit].split("")) {
            // 做选择
            // @visualize choose(c)
            sb += c;
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            // @visualize unchoose()
            sb = sb.slice(0, -1);
        }
    }

    backtrack(digits, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_letter-combinations-of-a-phone-number" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_letter-combinations-of-a-phone-number"></div></div>
</details><hr /><br />

</div>

</details>
</div>

