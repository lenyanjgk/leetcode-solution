<p>给你一个由&nbsp;<code>'1'</code>（陆地）和 <code>'0'</code>（水）组成的的二维网格，请你计算网格中岛屿的数量。</p>

<p>岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。</p>

<p>此外，你可以假设该网格的四条边均被水包围。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == grid.length</code></li> 
 <li><code>n == grid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 300</code></li> 
 <li><code>grid[i][j]</code> 的值为 <code>'0'</code> 或 <code>'1'</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 矩阵</details><br>

<div>👍 2598, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/frequency-interview/island-dfs-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

岛屿系列问题可以用 DFS/BFS 算法或者 [Union-Find 并查集算法](https://labuladong.online/algo/data-structure/union-find/) 来解决。

用 DFS 算法解决岛屿题目是最常见的，每次遇到一个岛屿中的陆地，就用 DFS 算法吧这个岛屿「淹掉」。

如何使用 DFS 算法遍历二维数组？你把二维数组中的每个格子看做「图」中的一个节点，这个节点和周围的四个节点连通，这样二维矩阵就被抽象成了一幅网状的「图」。

为什么每次遇到岛屿，都要用 DFS 算法把岛屿「淹了」呢？主要是为了省事，避免维护 `visited` 数组。

[图算法遍历基础](https://labuladong.online/algo/data-structure-basic/graph-basic/) 说了，遍历图是需要 `visited` 数组记录遍历过的节点防止走回头路。

因为 `dfs` 函数遍历到值为 `0` 的位置会直接返回，所以只要把经过的位置都设置为 `0`，就可以起到不走回头路的作用。

**详细题解：[一文秒杀所有岛屿题目](https://labuladong.online/algo/frequency-interview/island-dfs-summary/)**

</div>

**标签：[DFS 算法](https://labuladong.online/algo/)，二维矩阵**

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
    // 主函数，计算岛屿数量
    int numIslands(vector<vector<char>>& grid) {
        int res = 0;
        int m = grid.size(), n = grid[0].size();
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(vector<vector<char>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    # 主函数，计算岛屿数量
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        m, n = len(grid), len(grid[0])
        # 遍历 grid
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    # 每发现一个岛屿，岛屿数量加一
                    res += 1
                    # 然后使用 DFS 将岛屿淹了
                    self.dfs(grid, i, j)
        return res

    # 从 (i, j) 开始，将与之相邻的陆地都变成海水
    def dfs(self, grid: List[List[str]], i: int, j: int) -> None:
        m, n = len(grid), len(grid[0])
        if i < 0 or j < 0 or i >= m or j >= n:
            # 超出索引边界
            return
        if grid[i][j] == '0':
            # 已经是海水了
            return
        # 将 (i, j) 变成海水
        grid[i][j] = '0'
        # 淹没上下左右的陆地
        self.dfs(grid, i + 1, j)
        self.dfs(grid, i, j + 1)
        self.dfs(grid, i - 1, j)
        self.dfs(grid, i, j - 1)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 主函数，计算岛屿数量
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (grid[i][j] == '0') {
            // 已经是海水了
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 主函数，计算岛屿数量
func numIslands(grid [][]byte) int {
    res := 0
    m := len(grid)
    n := len(grid[0])
    // 遍历 grid
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            if grid[i][j] == '1' {
                // 每发现一个岛屿，岛屿数量加一
                res++
                // 然后使用 DFS 将岛屿淹了
                dfs(grid, i, j)
            }
        }
    }
    return res
}

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
func dfs(grid [][]byte, i, j int) {
    m := len(grid)
    n := len(grid[0])
    if i < 0 || j < 0 || i >= m || j >= n {
        // 超出索引边界
        return
    }
    if grid[i][j] == '0' {
        // 已经是海水了
        return
    }
    // 将 (i, j) 变成海水
    grid[i][j] = '0'
    // 淹没上下左右的陆地
    dfs(grid, i+1, j)
    dfs(grid, i, j+1)
    dfs(grid, i-1, j)
    dfs(grid, i, j-1)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

// 主函数，计算岛屿数量
var numIslands = function(grid) {
    let res = 0;
    let m = grid.length, n = grid[0].length;
    // 遍历 grid
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === '1') {
                // 每发现一个岛屿，岛屿数量加一
                res++;
                // 然后使用 DFS 将岛屿淹了
                dfs(grid, i, j);
            }
        }
    }
    return res;
};

// 从 (i, j) 开始，将与之相邻的陆地都变成海水
var dfs = function(grid, i, j) {
    let m = grid.length, n = grid[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) {
        // 超出索引边界
        return;
    }
    if (grid[i][j] === '0') {
        // 已经是海水了
        return;
    }
    // 将 (i, j) 变成海水
    grid[i][j] = '0';
    // 淹没上下左右的陆地
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_number-of-islands" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-islands"></div></div>
</details><hr /><br />

**类似题目**：
  - [1020. 飞地的数量 🟠](/problems/number-of-enclaves)
  - [1254. 统计封闭岛屿的数目 🟠](/problems/number-of-closed-islands)
  - [1905. 统计子岛屿 🟠](/problems/count-sub-islands)
  - [694. 不同岛屿的数量 🟠](/problems/number-of-distinct-islands)
  - [695. 岛屿的最大面积 🟠](/problems/max-area-of-island)
  - [剑指 Offer II 105. 岛屿的最大面积 🟠](/problems/ZL6zAn)

</div>

</details>
</div>

