<p>给定一个整数数组 <code>nums</code>&nbsp;和一个整数目标值 <code>target</code>，请你在该数组中找出 <strong>和为目标值 </strong><em><code>target</code></em>&nbsp; 的那&nbsp;<strong>两个</strong>&nbsp;整数，并返回它们的数组下标。</p>

<p>你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。</p>

<p>你可以按任意顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,7,11,15], target = 9
<strong>输出：</strong>[0,1]
<strong>解释：</strong>因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,4], target = 6
<strong>输出：</strong>[1,2]
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,3], target = 6
<strong>输出：</strong>[0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
 <li><strong>只会存在一个有效答案</strong></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以想出一个时间复杂度小于 <code>O(n<sup>2</sup>)</code> 的算法吗？</p>

<details><summary><strong>Related Topics</strong></summary>数组 | 哈希表</details><br>

<div>👍 18925, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/nsum/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

大家都喜欢幽默的人，如果你想调侃自己经常拖延，可以这样调侃下自己（手动狗头）：

背单词背了半年还是 abandon, abandon，刷题刷了半年还是 two sum, two sum...

言归正传，这道题不难，但由于它是 LeetCode 第一题，所以名气比较大，解决这道题也可以有多种思路，我这里说两种最常见的思路。

第一种思路就是靠排序，把 `nums` 排序之后就可以用 [数组双指针技巧汇总](https://labuladong.online/algo/essential-technique/array-two-pointers-summary/) 中讲到的左右指针来求出和为 `target` 的两个数。

不过因为题目要求我们返回元素的索引，而排序会破坏元素的原始索引，所以要记录值和原始索引的映射。

进一步，如果题目拓展延伸一下，让你求三数之和、四数之和，你依然可以用双指针技巧，我在 [一个函数秒杀 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/) 中写一个函数来解决所有 N 数之和问题。

第二种思路是用哈希表辅助判断。对于一个元素 `nums[i]`，你想知道有没有另一个元素 `nums[j]` 的值为 `target - nums[i]`，这很简单，我们用一个哈希表记录每个元素的值到索引的映射，这样就能快速判断数组中是否有一个值为 `target - nums[i]` 的元素了。

简单说，数组其实可以理解为一个「索引 -> 值」的哈希表映射，而我们又建立一个「值 -> 索引」的映射即可完成此题。

**详细题解：[一个方法团灭 nSum 问题](https://labuladong.online/algo/practice-in-action/nsum/)**

</div>

**标签：[双指针](https://labuladong.online/algo/)，哈希表，[数组](https://labuladong.online/algo/)**

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
    vector<int> twoSum(vector<int>& nums, int target) {
        // 维护 val -> index 的映射
        unordered_map<int, int> valToIndex;
        for (int i = 0; i < nums.size(); i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.find(need) != valToIndex.end()) {
                return {valToIndex[need], i};
            }
            // 存入 val -> index 的映射
            valToIndex[nums[i]] = i;
        }
        return {};
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 维护 val -> index 的映射
        val_to_index = {}
        for i in range(len(nums)):
            # 查表，看看是否有能和 nums[i] 凑出 target 的元素
            need = target - nums[i]
            if need in val_to_index:
                return [val_to_index[need], i]
            # 存入 val -> index 的映射
            val_to_index[nums[i]] = i
        return []
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

func twoSum(nums []int, target int) []int {
    // 维护 val -> index 的映射
    valToIndex := make(map[int]int)
    for i, num := range nums {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        need := target - num
        if j, ok := valToIndex[need]; ok {
            return []int{j, i}
        }
        // 存入 val -> index 的映射
        valToIndex[num] = i
    }
    return nil
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，但可能缺失注释。必要时请对照我的 java 代码查看。

var twoSum = function(nums, target) {
    // 维护 val -> index 的映射
    let valToIndex = new Map();
    for (let i = 0; i < nums.length; i++) {
        // 查表，看看是否有能和 nums[i] 凑出 target 的元素
        let need = target - nums[i];
        if (valToIndex.has(need)) {
            return [valToIndex.get(need), i];
        }
        // 存入 val -> index 的映射
        valToIndex.set(nums[i], i);
    }
    return null;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_two-sum" data="Gw4qIxGmdKsBUIuDeAw3lVKCSyTKtpwVs453f5I/qUmqtEJkXrfeae27uXJYgI7fbdKoAEmO0NfTZYboKqjNJZ7qcb6jR49K2ztFrukdMPhKlpu/v23jDxURPLpEHDqCZqMV+U9zZYFTSIkU0C+BsLMlUGXHuZZt98/8fcVsCUA2kykxCUvWVLuTp3RV9vxnbMbTxkURPbj5Rc/1/5a7wFv7/nde2CfSzcLl7gwDT0WZn9o7WJIO9bn71cdaMy15vy+zBi26BZJ8+g+Y7SkE7/9B1+hxEmsVyzKcg1qLf6V48M/JGqjdVkRi14r3nVP62FkALfTJr6gJDn17nVn05jYBlpRTMSwdTPo8EwTTOE/tyaO8sNciGLHwxMecvd4dT8sC4PR4lhx2vIgtuDwxYYWK7YSA5GW/5c4lu7QmVK/iPTwuTun1Y5yMCkOgiJjksj4Cg2NZtHtLIiDzI1y/o0y11GQbOPW4XYdxYLl44bZoj0ijuUNX2IqPtdmOBhOA7IBCfR8c1owh35GMxsbmTK3p/BdP13fMToWtfNJ+ZXVHTH2U0DH9vSJQRJrMtObU8ukPjTpqJ/lGvRmfEnyWkIImh7buNGzrXybVdIENjo83DTIBj7QY9bj86+mLhiZXcKQPkzuImxFvT0Y3fIojA3sw7vXBG7mfDDIBr2ITPWHmydGA99cHkJ5SOZty+JrjAlv4GvtsCCeOtiUTcafUzjkJCApyjYjuCebRErdwmhB1BHW/7B4a2NXvSLuAGIIUYTW+mZ/IisXH7FngMDXuOp6UhrjM+/J83OFPuD29e0nW7oSPu+/WmycV/4OBuAm7MXs4pmB3UF5T8aClVctRRkWSMdUSVDSW7iwfhZT7Cpw4qFTwkSWsJ8yZmUqFwOgaVVjPoRTqDk4ULx2tMlVzVNYeAjNVEzTEohxZfoIbwAmDygWfWMKmIDSMqVwI5DGqmlnP4RTuHsl7z9pGCVVyVG9docxUSVDsAXWwfAbAgRMGVQo+s4TFoiNkpkoh0HKUXljPkRTpDk0UYkrITOUcZT0mJKbyFNF5VNaesOAeVAb57IoxbMNwYnJjlE8p1dhLjL2Owem1hL2quktnXuvUr9Tc8QX6l4k1jTJOo4e5uclu7zUnNf7E/s7sNtcOjndqTS/4V3S3z729sYC5DjHyvTk7YpowKzQw2vZy3eXmk/YvY1uxNOqa/YhyHLdOev52MZ+E4eeaEP+6CykKhpx3hPKNY1bOpMeb9BViL2smn730SJQRmq/EyP0t6KJHBXrpkj4yqaYSD5A9DF3n3NZXxwGq+/u6hkJkr+0UFK+IREFNuJuHoCZdHAkqdWbqgtp4YWNQaimqBMV1o3hQAqcmBEXGA+oDmbvRGWkFmE1DnP7cczrOJJrtRRqfkhbWr/rv8uWvBTn1ms9JtESRFXfwrmvozJznXjodVshYeoLYQH6aX4Lph+2HyfX6blZ6oqFt4yaufpPbRDhRIGStLhaaaTLcrIhFQ8qo5DK1M2AkU0B3rSuUwESoXawxq5HR0OZzX/Sa+YfOjIeGkS0AAVQbV5oyWQZ++JH3hkI3khUH4QxJQGmisNq82UUNGqLmsLVclQQGwl5MVHbtg5nWumRv9laEhkyT2KhroUBHNuw1QEUmMZIahlYTrsgkRpwMX4dJ14oR0xMybDuAPiOmISzSRD7jubgI14mSypDxmvs4s+s5oG7z+nQ5kNOz50yyACGaieo3rj6lNG05adXk0kXzEuyU1PFF/jm9aOSgHEEzuC6W1RIvE5VS6fKaV+niENloibotp78U372G3HPFl6lA3wKi1mCHhN1bGGpf+tDULaYODOUAhX2vlSN4/HW4eRi19AG0L8Wg58bBn3NsoA2UyCOzVFVcdiT5DI0Qm1dVAUo6w2VHcMxOcA0pTPUBYZJtWMNFtzCuvyx0X7mmWAhHo8lFz1SESBhK5rpqoBmLNtlX58FStwsFU0wKPGm1L6lWk0120YaW1BKbZtOZdJAqRnZxFtFkd9nv82jsTU+UoUHuQDqSUOwJfX26FB+JJ5tdUYUOQJBvnvaROkIYDAVwgEhAqTIkNpjItznxyyUn3FCyfmUaKAgR6bQAy+RylktUojs3DSJskN0Yd1YdGiFbgiito+2z2TWXM9ESi3wtq57/7qWiH5YBAhW+hHO2kd09nAiRiAImMhCruIhoaJUZbfkoGtpCKAE6gIIeYJfnbKDYZgOls3igEAbYZS0bKFLZQMnJASkg2UA5yAaKO/FAqQbIvpb5hTKDizEz6GaF0PYVLNdUABcDzwEDL+FisAC5R+AYeAYu8CK4QVVCcIEn4AJPwQVeAjeoygQu8Bhc4EVwg6oSwAUeggu8CJ4Gh8Oqek6oZBbM09+x9kbrTKg0Gyhg/7oxPb8vz6ZpmnZ2piexuyHxfnfQTIuPRPM/e0ss2kHpfj/LbBcsu2qy1Iuqh05onEh2hPBv2rdlxfrGO1n6zG2w1AjJMVsWdJ+GRFJURC1tznLBjtl/Jdc1VLUrKjkNBvNd9dlzPlxN/9meZj+Xs6s6QvB2O+oyvQ2x3vHXYdeU/jgclVMszGdbE0YPoWvldbKVLMPcBTdeLw2YZnyECZTDD3YKF+pOfrcwqWbE47Zti7ysq8xueIWMskXwybOKerzHy8Ck8xlevdGc/oSrphXuti9p0stjWKAsaquyi7g0ffU2YCe4g/+iYeEZry/SYP8yv1nwVcfnPdfnBcKCnspwGdlfVzAtfOObSUg4dac/bPvq1t0c2j434iCEp0V/Oc9CYL6COTIg2pt9KSCQhL4tScAibYsTaPBaitHX6Pp82ep1DQ=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_two-sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [15. 三数之和 🟠](/problems/3sum)
  - [167. 两数之和 II - 输入有序数组 🟠](/problems/two-sum-ii-input-array-is-sorted)
  - [18. 四数之和 🟠](/problems/4sum)
  - [剑指 Offer 57. 和为s的两个数字 🟢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [剑指 Offer II 007. 数组中和为 0 的三个数 🟠](/problems/1fGaJU)

</div>

</details>
</div>





