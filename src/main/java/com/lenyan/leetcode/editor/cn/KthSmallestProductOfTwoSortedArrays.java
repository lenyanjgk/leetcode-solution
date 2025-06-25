//2040  两个有序数组的第 K 小乘积 kth-smallest-product-of-two-sorted-arrays
//2025-06-25 09:13:22

package com.lenyan.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestProductOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new KthSmallestProductOfTwoSortedArrays().new Solution();
    }

        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public long kthSmallestProduct(int[] a, int[] b, long k) {
                int i0 = lowerBound(a, 0); // 四个区域的水平分界线
                int j0 = lowerBound(b, 0); // 四个区域的垂直分界线

                int n = a.length;
                int m = b.length;
                List<Long> corners = Arrays.asList((long) a[0] * b[0], (long) a[0] * b[m - 1], (long) a[n - 1] * b[0], (long) a[n - 1] * b[m - 1]);
                long left = Collections.min(corners) - 1;
                long right = Collections.max(corners);

                while (left + 1 < right) {
                    long mid = left + (right - left) / 2;
                    if (check(a, b, i0, j0, k, mid)) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                return right;
            }

            private boolean check(int[] a, int[] b, int i0, int j0, long k, long mx) {
                int n = a.length;
                int m = b.length;
                long cnt = 0;

                if (mx < 0) {
                    // 右上区域
                    int i = 0;
                    int j = j0;
                    while (i < i0 && j < m) { // 不判断 cnt < k 更快
                        if ((long) a[i] * b[j] > mx) {
                            j++;
                        } else {
                            cnt += m - j;
                            i++;
                        }
                    }

                    // 左下区域
                    i = i0;
                    j = 0;
                    while (i < n && j < j0) {
                        if ((long) a[i] * b[j] > mx) {
                            i++;
                        } else {
                            cnt += n - i;
                            j++;
                        }
                    }
                } else {
                    // 右上区域和左下区域的所有数都 <= 0 <= mx
                    cnt = (long) i0 * (m - j0) + (long) (n - i0) * j0;

                    // 左上区域
                    int i = 0;
                    int j = j0 - 1;
                    while (i < i0 && j >= 0) {
                        if ((long) a[i] * b[j] > mx) {
                            i++;
                        } else {
                            cnt += i0 - i;
                            j--;
                        }
                    }

                    // 右下区域
                    i = i0;
                    j = m - 1;
                    while (i < n && j >= j0) {
                        if ((long) a[i] * b[j] > mx) {
                            j--;
                        } else {
                            cnt += j - j0 + 1;
                            i++;
                        }
                    }
                }

                return cnt >= k;
            }

            private int lowerBound(int[] nums, int target) {
                int left = -1;
                int right = nums.length;
                while (left + 1 < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] >= target) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                }
                return right;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)


}

//给你两个 从小到大排好序 且下标从 0 开始的整数数组 nums1 和 nums2 以及一个整数 k ，请你返回第 k （从 1 开始编号）小的 nums1
//[i] * nums2[j] 的乘积，其中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
//
//
//
// 示例 1：
//
// 输入：nums1 = [2,5], nums2 = [3,4], k = 2
//输出：8
//解释：第 2 小的乘积计算如下：
//- nums1[0] * nums2[0] = 2 * 3 = 6
//- nums1[0] * nums2[1] = 2 * 4 = 8
//第 2 小的乘积为 8 。
//
//
// 示例 2：
//
// 输入：nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
//输出：0
//解释：第 6 小的乘积计算如下：
//- nums1[0] * nums2[1] = (-4) * 4 = -16
//- nums1[0] * nums2[0] = (-4) * 2 = -8
//- nums1[1] * nums2[1] = (-2) * 4 = -8
//- nums1[1] * nums2[0] = (-2) * 2 = -4
//- nums1[2] * nums2[0] = 0 * 2 = 0
//- nums1[2] * nums2[1] = 0 * 4 = 0
//第 6 小的乘积为 0 。
//
//
// 示例 3：
//
// 输入：nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
//输出：-6
//解释：第 3 小的乘积计算如下：
//- nums1[0] * nums2[4] = (-2) * 5 = -10
//- nums1[0] * nums2[3] = (-2) * 4 = -8
//- nums1[4] * nums2[0] = 2 * (-3) = -6
//第 3 小的乘积为 -6 。
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 5 * 10⁴
// -10⁵ <= nums1[i], nums2[j] <= 10⁵
// 1 <= k <= nums1.length * nums2.length
// nums1 和 nums2 都是从小到大排好序的。
//
//
// Related Topics 数组 二分查找 👍 62 👎 0
