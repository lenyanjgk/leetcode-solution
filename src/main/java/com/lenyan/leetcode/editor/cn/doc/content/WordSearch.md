<p>给定一个&nbsp;<code>m x n</code> 二维字符网格&nbsp;<code>board</code> 和一个字符串单词&nbsp;<code>word</code> 。如果&nbsp;<code>word</code> 存在于网格中，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word2.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
<strong>输出：</strong>true
</pre>

<p><strong>示例 3：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/15/word3.jpg" style="width: 322px; height: 242px;" /> 
<pre>
<strong>输入：</strong>board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == board.length</code></li> 
 <li><code>n = board[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 6</code></li> 
 <li><code>1 &lt;= word.length &lt;= 15</code></li> 
 <li><code>board</code> 和 <code>word</code> 仅由大小写英文字母组成</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以使用搜索剪枝的技术来优化解决方案，使其在 <code>board</code> 更大的情况下可以更快解决问题？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 字符串 | 回溯 | 矩阵</details><br>

<div>👍 1885, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：网站新增大量习题，新增排序算法专题及可视化，具体请查看 [网站更新日志](https://labuladong.online/algo/changelog/website/)~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这道题和 [一文秒杀所有岛屿题目](https://labuladong.online/algo/frequency-interview/island-dfs-summary/) 中讲到的题目非常类似，用 DFS 算法暴力搜索就行了。

注意我们要对已经匹配过的字符做标记，比如用一个额外的 `visited` 布尔数组，或者使用其他方法标记 `board` 中已经匹配过的字符。

如果不做标记的话会出现错误的结果，比如这个测试用例：

```java
[["A","B","C","E"],
 ["S","F","C","S"],
 ["A","D","E","E"]]
```

你如果在其中搜索 `"ABCB"`，按道理不应该搜到，但如果你不对已经匹配过的字符做标记的话，算法可能匹配了第一行前三列的 `"ABC"` 之后又回头匹配了第二列的 `"B"`，导致出现错误的结果。

我就用加负号的方式标记已经匹配过的字符，来避免走回头路，具体看代码吧。

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

class Solution {
    bool found = false;

public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size(), n = board[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    void dfs(vector<vector<char>>& board, int i, int j, string& word, int p) {
        if (p == word.length()) {
            // 整个 word 已经被匹配完，找到了一个答案
            found = true;
            return;
        }
        if (found) {
            // 已经找到了一个答案，不用再搜索了
            return;
        }
        int m = board.size(), n = board[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] != word[p]) {
            return;
        }

        // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
        board[i][j] = -board[i][j];
        // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        dfs(board, i + 1, j, word, p + 1);
        dfs(board, i, j + 1, word, p + 1);
        dfs(board, i - 1, j, word, p + 1);
        dfs(board, i, j - 1, word, p + 1);
        board[i][j] = -board[i][j];
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
        self.found = False

    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                self.dfs(board, i, j, word, 0)
                if self.found:
                    return True
        return False

    # 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    def dfs(self, board: List[List[str]], i: int, j: int, word: str, p: int):
        if p == len(word):
            # 整个 word 已经被匹配完，找到了一个答案
            self.found = True
            return
        if self.found:
            # 已经找到了一个答案，不用再搜索了
            return
        m, n = len(board), len(board[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            return
        if board[i][j] != word[p]:
            return

        # 已经匹配过的字符，我们用一个特殊字符标记，避免走回头路
        temp = board[i][j]
        board[i][j] = '#'
        # word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        self.dfs(board, i + 1, j, word, p + 1)
        self.dfs(board, i, j + 1, word, p + 1)
        self.dfs(board, i - 1, j, word, p + 1)
        self.dfs(board, i, j - 1, word, p + 1)
        board[i][j] = temp
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    boolean found = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, word, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    // 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    void dfs(char[][] board, int i, int j, String word, int p) {
        if (p == word.length()) {
            // 整个 word 已经被匹配完，找到了一个答案
            found = true;
            return;
        }
        if (found) {
            // 已经找到了一个答案，不用再搜索了
            return;
        }
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] != word.charAt(p)) {
            return;
        }

        // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
        board[i][j] = (char)(-board[i][j]);
        // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        dfs(board, i + 1, j, word, p + 1);
        dfs(board, i, j + 1, word, p + 1);
        dfs(board, i - 1, j, word, p + 1);
        dfs(board, i, j - 1, word, p + 1);
        board[i][j] = (char)(-board[i][j]);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var found bool

func exist(board [][]byte, word string) bool {
    m := len(board)
    n := len(board[0])
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            found = false
            dfs(board, i, j, word, 0)
            if found {
                return true
            }
        }
    }
    return false
}

// 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
func dfs(board [][]byte, i, j int, word string, p int) {
    if p == len(word) {
        // 整个 word 已经被匹配完，找到了一个答案
        found = true
        return
    }
    if found {
        // 已经找到了一个答案，不用再搜索了
        return
    }
    m, n := len(board), len(board[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        return
    }
    if board[i][j] != word[p] {
        return
    }

    // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
    original := board[i][j]
    board[i][j] = '^' - board[i][j]
    // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
    dfs(board, i + 1, j, word, p + 1)
    dfs(board, i, j + 1, word, p + 1)
    dfs(board, i - 1, j, word, p + 1)
    dfs(board, i, j - 1, word, p + 1)
    board[i][j] = original
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照我的 java 代码查看。

var exist = function(board, word) {
    let found = false;
    const m = board.length, n = board[0].length;

    // 从 (i, j) 开始向四周搜索，试图匹配 word[p..]
    const dfs = function(board, i, j, word, p) {
        if (p === word.length) {
            // 整个 word 已经被匹配完，找到了一个答案
            found = true;
            return;
        }
        if (found) {
            // 已经找到了一个答案，不用再搜索了
            return;
        }
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (board[i][j] !== word.charAt(p)) {
            return;
        }

        // 已经匹配过的字符，我们给它添一个负号作为标记，避免走回头路
        board[i][j] = String.fromCharCode(-board[i][j].charCodeAt(0));
        // word[p] 被 board[i][j] 匹配，开始向四周搜索 word[p+1..]
        dfs(board, i + 1, j, word, p + 1);
        dfs(board, i, j + 1, word, p + 1);
        dfs(board, i - 1, j, word, p + 1);
        dfs(board, i, j - 1, word, p + 1);
        board[i][j] = String.fromCharCode(-board[i][j].charCodeAt(0));
    };

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            dfs(board, i, j, word, 0);
            if (found) {
                return true;
            }
        }
    }
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_word-search" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_word-search"></div></div>
</details><hr /><br />

</div>

</details>
</div>

