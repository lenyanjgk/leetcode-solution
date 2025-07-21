package tongyuan;

import java.util.HashSet;

public class FindDuplicate {
    public static int findnums(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return num;
            seen.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1}; // 示例数组
        System.out.println(findnums(nums)); // 输出: 1
    }
}