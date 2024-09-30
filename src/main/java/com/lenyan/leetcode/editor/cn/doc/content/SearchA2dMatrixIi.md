<p>编写一个高效的算法来搜索&nbsp;<code><em>m</em>&nbsp;x&nbsp;<em>n</em></code>&nbsp;矩阵 <code>matrix</code> 中的一个目标值 <code>target</code> 。该矩阵具有以下特性：</p>

<ul> 
 <li>每行的元素从左到右升序排列。</li> 
 <li>每列的元素从上到下升序排列。</li> 
</ul>

<p>&nbsp;</p>

<p><b>示例 1：</b></p> 
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid2.jpg" /> 
<pre>
<b>输入：</b>matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
<b>输出：</b>true
</pre>

<p><b>示例 2：</b></p> 
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/11/25/searchgrid.jpg" /> 
<pre>
<b>输入：</b>matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
<b>输出：</b>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m == matrix.length</code></li> 
 <li><code>n == matrix[i].length</code></li> 
 <li><code>1 &lt;= n, m &lt;= 300</code></li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li> 
 <li>每行的所有元素从左到右升序排列</li> 
 <li>每列的所有元素从上到下升序排列</li> 
 <li><code>-10<sup>9</sup>&nbsp;&lt;= target &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 分治 | 矩阵</details><br>

<div>👍 1534, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

作为 [74. 搜索二维矩阵](/problems/search-a-2d-matrix) 的进阶题目，这道题不算 [二分搜索算法](https://labuladong.online/algo/essential-technique/binary-search-framework/)，更像 [一个方法秒杀所有 N 数之和问题](https://labuladong.online/algo/practice-in-action/nsum/)，因为它们的思想上有些类似。

这道题说 `matrix` 从上到下递增，从左到右递增，显然左上角是最小元素，右下角是最大元素。**我们如果想高效在 `matrix` 中搜索一个元素，肯定需要从某个角开始**，比如说从左上角开始，然后每次只能向右或向下移动，不要走回头路。

如果真从左上角开始的话，就会发现无论向右还是向下走，元素大小都会增加，那么到底向右还是向下？不确定，那只好用类似 [动态规划算法](https://labuladong.online/algo/essential-technique/dynamic-programming-framework/) 的思路穷举了。

但实际上不用这么麻烦，我们不要从左上角开始，而是从右上角开始，规定只能向左或向下移动。

你注意，如果向左移动，元素在减小，如果向下移动，元素在增大，这样的话我们就可以根据当前位置的元素和 `target` 的相对大小来判断应该往哪移动，不断接近从而找到 `target` 的位置。

当然，如果你想从左下角开始，规定只能向右或向上移动也可以，具体看代码吧。

</div>

**标签：[数组](https://labuladong.online/algo/)，[数组双指针](https://labuladong.online/algo/)**

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
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size(), n = matrix[0].size();
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        # 初始化在右上角
        i = 0
        j = n - 1
        while i < m and j >= 0:
            if matrix[i][j] == target:
                return True
            if matrix[i][j] < target:
                # 需要大一点，往下移动
                i += 1
            else:
                # 需要小一点，往左移动
                j -= 1
        # while 循环中没有找到，则 target 不存在
        return False
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func searchMatrix(matrix [][]int, target int) bool {
    m, n := len(matrix), len(matrix[0])
    // 初始化在右上角
    i, j := 0, n-1
    for i < m && j >= 0 {
        if matrix[i][j] == target {
            return true
        }
        if matrix[i][j] < target {
            // 需要大一点，往下移动
            i++
        } else {
            // 需要小一点，往左移动
            j--
        }
    }
    // while 循环中没有找到，则 target 不存在
    return false
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var searchMatrix = function(matrix, target) {
    let m = matrix.length, n = matrix[0].length;
    // 初始化在右上角
    let i = 0, j = n - 1;
    while (i < m && j >= 0) {
        if (matrix[i][j] === target) {
            return true;
        }
        if (matrix[i][j] < target) {
            // 需要大一点，往下移动
            i++;
        } else {
            // 需要小一点，往左移动
            j--;
        }
    }
    // while 循环中没有找到，则 target 不存在
    return false;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_search-a-2d-matrix-ii" data="G24xI5JQzlMA1CqBO1T68BdxIyPQJkAABxR269zGvoAhcmhnurJqV64Cc/oZ3g1DUfksiw8e0UXXJR5wH0gG52xUWX2you279fhhNsB2OTn6e2vnMK/Gz7++DEqxyUspZXCDFMiW/7SWxmWTLRD/EggbwK0CBNub+ZNXugvwBciVcWeSErLQtbIVlp2uuotqjKs8gzEXZyI2tqwhxdDvK6rHdeV5ZevqVX0WLuEZstfVLwy8FBZI5xCCpK+nY7NYKiYFb9HexIe74zFrR5d+xcBx6nxdLaCqez+JpQz/DbrwasnP9vlAf9HVxe5OW2nDMBXGCtfViQLPqhXIjfXW9qhfn890gCizalSuA4yqfpBhNUKndw0MCNbjW9vTcnQtdImyfqBxqMfurDKjY7g7u7lcLbF6as7OM7wmN8dDYnE9V+esM5za9uEhsWS+s0NGn+ENFx0TSyMx5qCr68yPntmjq2Ebye7x7cHsR6D5geZ6MkQOFpH1k/pUnAyPGdFdnK9YV8dSOPaHVSHenrk0bDFCLZ3O0KsyiyDCypTcNb4gZxB1LVw/odJZL715YNlDhWnEQfkoc5DZN83D2B8y/WfKFMzmU2b3wQu+a7rw6qUS5+PVjIfvBDGZQrB9KiB74+aEjDhUYo+DiwQPFFDEQp9Y7pA9HDPBTmYqBEI/seHGmUz/BNu9jTwDeWFR8bNw9KDRXZ9BUYASzCP1Ovt4pBjjv8fBMsfwytMyuePhBnqzBJzmvKPkuZPejUadgIcoAYwMe+D+WUxTmXrUohmjx5MuU0t2qPR6qBx6VBkkxFrvPEV68j7MGViCXWxLWuvKAlH1KDq8Y3+O/Ty5+ygxCEx7hhGQn4QeIVZlnMKcbMEEGYQoIJlchpYYm/ecLDhkIXVUBXw+Ecc8e8bH7u/8/a1MXd6UmaDnX1F6h/XtcqEXJJGchuToeciWFP3TLbPqT0gNbIkljkSTqBSiSyGXkdTAllhAqqP9FVFDWmJRJUR3mKQfSEArqQaNBCGTxLGofGSM/7mq544EIZMAdDf7Sx6ChElUDtGZ+8lnEtBOqsEgQSgkcSIqRdWQLb2EDSQIhQRixmHF4Qqqoypgn9B8lJnzLboZx+i7eSkVUOaoGKLFFPNAAjqTarCQxNHjU8HVQeEToH70PExQtAqIaktgR/PocvgiVqxqtCr/NP2HvzTIZF7de1+arcOutFD8oTm6a8y3F4FM+tcoj8zyIN9Ic2H0QZT2QisYZqFmBS/Yz0jy2HFqE3ZEIDniMVHmJV4MOV5KjL2cQ/TJ51affpvGpekicJ25QBiESrW5ttXJdTjmgjJWoLbU9jqltjszo/QUyCak2SQ0h5TWiVgURaNA7dyYqTFLY3ZHQSQLgHFleByKyMfhUufjSOHwcbQM16z9VMWVxmbxmT0iAzJq81Sx9BAaRww1+1RywlfOZXak80pcpwoE7NRakEcoRK+qnjA9esy2WA/EJpdLJs4ufEl/zi6pkp5nl93wjme91yPs3iU5S4n6a4iMxx2CULNHUk6PJadIe3g5UQ5TKPzefR8pW5HW9E9OhUJZBiWtx6mP8YrT87AmWangztVtMBB2diYl/3fPTNngZVH1iXAmsnZHuQoQhk4p05DSLxAYISJwk10ZYSZDyRhcgQkDBRguyTphd7w/8kgz4vOKJ+iwNJx4Zfu84+tTbxhyjMiN28KV0cJJGutX3jgaBqo4p0d0YoSJsstlUxuVw5GacCLzdvIwEECcjez/CCPVZ7IBXWgZBBFvOGjRhZaBn+Qe/SH7YzJQyi+LJagZaBjWFeN2sPk9XEH9RkSTu4k6Y4aJXqIM6Rr/fn8aiZOwDlFZDlxkZL4u0XFXONFVoLXrJ1fMEx1is+FF/VmU7sBBfUNdiV7ASiTJM1E6NvGMf9KVK7DRkx6ujv2Jf0Pd6JUkn2s+aKcAj6xEwAa++kjODuvS00yTXFcCQs6tUQZw43UqAI1mh2N7YkhGwcLv9sYgGxg1fceTX9j/eieEGhVaD/Nx9yLoOJ9G0jyIJPrmEvUNwb3O2IkXb00NI+XC/MaKukJcJwwMHzHxUBCDWNFLmqbYBg+IYV5N3voaBugYeEYfU5tjms7iJmnqSWV7nuKdQ/Ux1cY1XYp0FINNUtu2vydOCJdtPZAy4in79/sT/3Qw0Yqj8zYMVKAw6cgcOYEGAyoBecA1cuVOzGQ0NHeu6rgJER7EmQxSfMplwd4v8/u1RF22jrFHpIFXN3yjkjnZVIVZMNLraSNvFLLSSLsuWh1mt/XhLuZYBFeKlBefqF5tuHvF9jYCkU3WVyDIsulcyLbpQNbNDOQzdSDXqAM5Oh3IupmBPJoOZMV0IMelAxkrM5B/0oFskg7khnQg02MG8jZA6vLZRfb0xxkZ4RZH9SNvk1M+4oU5bMWFYRsuDNtxYdiBCyOLkMJjGDbhxGjIiJOCLTgxGgripGALToyGijgp2IITo6EhTgq24MRo7IjTisYXRAohfUZUBtc+e+udpnAFSC+0wfjSc4/r9UlKKR1NJR0LZjFqBxNTTxaX1NhsBkBJ+yMHB+lh+8p/qoxJUgY9wc+isHrTiat5jHuHWrJOQzsB7pHebZKIXRlC2r9cf5JWibTkfx/86l16k47r8e+wT+/eJrSFgOhfh/EN611z33j79q118aDVZHdzn/Ci5om8meAi3OSiULOGMHv/ie8CN47R5cGJxP7yqVZNcoM3om2NqO1uwlW7ly9NjM7zq26iZFtH1e2qQYJOx3c08ath96uVGo5ewonyv8L/f/4aHFlYbUm4yZEwVzblNsGF/xDaA5kC0VNzOjktbS9ZXbGhKaUCGiTIJglKGb2RgWf5iuWFZxLhjVsXHv02ymz8rK4Jkg5WpBPRvqwBNS8zWDmdGCvKYkssjyiWN2DehBASCSJ0edxttXI6EyLE8nzB5pxpzxNV1fJBjnKh/+LaNXJI+Q5FtdcQ0f57rEsBImkgUQay0sDiNDPa3Ar3ayXALeqJ+MX8neUNFJupSYNAKzczpsrk+5ulAg=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-a-2d-matrix-ii"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer 04. 二维数组中的查找 🟠](/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof)

</div>

</details>
</div>

