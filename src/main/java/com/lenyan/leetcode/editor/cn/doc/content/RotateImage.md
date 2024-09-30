<p>给定一个 <em>n&nbsp;</em>×&nbsp;<em>n</em> 的二维矩阵&nbsp;<code>matrix</code> 表示一个图像。请你将图像顺时针旋转 90 度。</p>

<p>你必须在<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地</a></strong> 旋转图像，这意味着你需要直接修改输入的二维矩阵。<strong>请不要 </strong>使用另一个矩阵来旋转图像。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="height: 188px; width: 500px;" /> 
<pre>
<strong>输入：</strong>matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>输出：</strong>[[7,4,1],[8,5,2],[9,6,3]]
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="height: 201px; width: 500px;" /> 
<pre>
<strong>输入：</strong>matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
<strong>输出：</strong>[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == matrix.length == matrix[i].length</code></li> 
 <li><code>1 &lt;= n &lt;= 20</code></li> 
 <li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li> 
</ul>

<p>&nbsp;</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 矩阵</details><br>

<div>👍 1942, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这题看起来复杂，但只要掌握了规律就很简单。

先把二维矩阵沿对角线反转，然后反转矩阵的每一行，结果就是顺时针反转整个矩阵。

**详细题解：[二维数组的花式遍历技巧](https://labuladong.online/algo/practice-in-action/2d-array-traversal-summary/)**

</div>

**标签：[数据结构](https://labuladong.online/algo/)，[数组](https://labuladong.online/algo/)**

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
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (auto& row : matrix) {
            ::reverse(row.begin(), row.end());
        }
    }

    // 反转一维数组
    void reverse(vector<int>& arr) {
        int i = 0, j = arr.size() - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        # 先沿对角线反转二维矩阵
        for i in range(n):
            for j in range(i, n):
                # swap(matrix[i][j], matrix[j][i])
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # 然后反转二维矩阵的每一行
        for row in matrix:
            self.reverse(row)

    # 反转一维数组
    def reverse(self, arr):
        i, j = 0, len(arr) - 1
        while j > i:
            # swap(arr[i], arr[j])
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线反转二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func rotate(matrix [][]int) {
    n := len(matrix)
    // 先沿对角线反转二维矩阵
    for i := 0; i < n; i++ {
        for j := i; j < n; j++ {
            // swap(matrix[i][j], matrix[j][i]);
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        }
    }
    // 然后反转二维矩阵的每一行
    for i := range matrix {
        reverse(matrix[i])
    }
}

// 反转一维数组
func reverse(arr []int) {
    i, j := 0, len(arr)-1
    for j > i {
        // swap(arr[i], arr[j]);
        arr[i], arr[j] = arr[j], arr[i]
        i++
        j--
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var rotate = function(matrix) {
    let n = matrix.length;
    // 先沿对角线反转二维矩阵
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            // swap(matrix[i][j], matrix[j][i]);
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    // 然后反转二维矩阵的每一行
    for (let row of matrix) {
        reverse(row);
    }

    // 反转一维数组
    function reverse(arr) {
        let i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            let temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_rotate-image" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_rotate-image"></div></div>
</details><hr /><br />

**类似题目**：
  - [151. 反转字符串中的单词 🟠](/problems/reverse-words-in-a-string)
  - [54. 螺旋矩阵 🟠](/problems/spiral-matrix)
  - [59. 螺旋矩阵 II 🟠](/problems/spiral-matrix-ii)
  - [61. 旋转链表 🟠](/problems/rotate-list)
  - [剑指 Offer 29. 顺时针打印矩阵 🟢](/problems/shun-shi-zhen-da-yin-ju-zhen-lcof)
  - [剑指 Offer 58 - I. 翻转单词顺序 🟢](/problems/fan-zhuan-dan-ci-shun-xu-lcof)

</div>

</details>
</div>

