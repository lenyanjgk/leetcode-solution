<p>数字 <code>n</code>&nbsp;代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 3
<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>["()"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 8</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划 | 回溯</details><br>

<div>👍 3698, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/generate-parentheses/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

本题可以改写为：

现在有 `2n` 个位置，每个位置可以放置字符 `(` 或者 `)`，组成的所有括号组合中，有多少个是合法的？

这就是典型的回溯算法提醒，暴力穷举就行了。

不过为了减少不必要的穷举，我们要知道合法括号串有以下性质：

**1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解**。

**2、对于一个「合法」的括号字符串组合 `p`，必然对于任何 ` 0 <= i < len(p)` 都有：子串 `p[0..i]` 中左括号的数量都大于或等于右括号的数量**。

因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。

用 `left` 记录还可以使用多少个左括号，用 `right` 记录还可以使用多少个右括号，就可以直接套用 [回溯算法套路框架](https://labuladong.online/algo/essential-technique/backtrack-framework/) 了。

- **详细题解**：
  - [回溯算法实践：括号生成](https://labuladong.online/algo/practice-in-action/generate-parentheses/)

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

using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return {};
        // 记录所有合法的括号组合
        vector<string> res;
        // 回溯过程中的路径
        string track;
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

private:
    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    void backtrack(int left, int right, string& track, vector<string>& res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }

        // 尝试放一个左括号
        // 选择
        track.push_back('(');
        backtrack(left - 1, right, track, res);
        // 撤消选择
        track.pop_back();

        // 尝试放一个右括号
        // 选择
        track.push_back(')');
        backtrack(left, right - 1, track, res);
        // 撤消选择
        track.pop_back();
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []
        # 记录所有合法的括号组合
        res = []
        # 回溯过程中的路径
        track = []
        # 可用的左括号和右括号数量初始化为 n
        self.backtrack(n, n, track, res)
        return res

    # 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    def backtrack(self, left: int, right: int, track: List[str], res: List[str]):
        # 若左括号剩下的多，说明不合法
        if right < left:
            return
        # 数量小于 0 肯定是不合法的
        if left < 0 or right < 0:
            return
        # 当所有括号都恰好用完时，得到一个合法的括号组合
        if left == 0 and right == 0:
            res.append("".join(track))
            return

        # 尝试放一个左括号
        # 选择
        track.append('(')
        self.backtrack(left - 1, right, track, res)
        # 撤消选择
        track.pop()

        # 尝试放一个右括号
        # 选择
        track.append(')')
        self.backtrack(left, right - 1, track, res)
        # 撤消选择
        track.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    private void backtrack(int left, int right, StringBuilder track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        // 选择
        track.append('(');
        backtrack(left - 1, right, track, res);
        // 撤消选择
        track.deleteCharAt(track.length() - 1);

        // 尝试放一个右括号
        // 选择
        track.append(')');
        backtrack(left, right - 1, track, res);
        // 撤消选择
        track.deleteCharAt(track.length() - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

func generateParenthesis(n int) []string {
    if n == 0 {
        return []string{}
    }
    // 记录所有合法的括号组合
    var res []string
    // 回溯过程中的路径
    var track string
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, &track, &res)
    return res
}

// 可用的左括号数量为 left 个，可用的右括号数量为 right 个
func backtrack(left, right int, track *string, res *[]string) {
    // 若左括号剩下的多，说明不合法
    if right < left {
        return
    }
    // 数量小于 0 肯定是不合法的
    if left < 0 || right < 0 {
        return
    }
    // 当所有括号都恰好用完时，得到一个合法的括号组合
    if left == 0 && right == 0 {
        *res = append(*res, *track)
        return
    }

    // 尝试放一个左括号
    // 选择
    *track += "("
    backtrack(left-1, right, track, res)
    // 撤消选择
    *track = (*track)[:len(*track)-1]

    // 尝试放一个右括号
    // 选择
    *track += ")"
    backtrack(left, right-1, track, res)
    // 撤消选择
    *track = (*track)[:len(*track)-1]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var generateParenthesis = function(n) {
    if (n === 0) return [];
    // 记录所有合法的括号组合
    let res = [];
    // 回溯过程中的路径
    let track = [];
    // 可用的左括号和右括号数量初始化为 n
    backtrack(n, n, track, res);
    return res;
};

// 可用的左括号数量为 left 个，可用的右括号数量为 right 个
var backtrack = function(left, right, track, res) {
    // 若左括号剩下的多，说明不合法
    if (right < left) return;
    // 数量小于 0 肯定是不合法的
    if (left < 0 || right < 0) return;
    // 当所有括号都恰好用完时，得到一个合法的括号组合
    if (left === 0 && right === 0) {
        res.push(track.join(''));
        return;
    }

    // 尝试放一个左括号
    // 选择
    track.push('(');
    backtrack(left - 1, right, track, res);
    // 撤消选择
    track.pop();

    // 尝试放一个右括号
    // 选择
    track.push(')');
    backtrack(left, right - 1, track, res);
    // 撤消选择
    track.pop();
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_generate-parentheses" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_generate-parentheses"></div></div>
</details><hr /><br />

</div>

</details>
</div>

