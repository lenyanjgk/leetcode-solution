package tongyuan;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter {

    public static List<String> splitString(String input, String split) {
        List<String> ans = new ArrayList<>();
        int splitLength = split.length();
        int start = 0;

        for (int i = 0; i <= input.length() - splitLength; i++) {
            if (input.substring(i, i + splitLength).equals(split)) {
                ans.add(input.substring(start, i));
                start = i + splitLength;
                i = start - 1;
            }
        }
        ans.add(input.substring(start));
        return ans;
    }

    public static void main(String[] args) {
        String input = "ab&&2";
        String split = "&&";
        List<String> ans = splitString(input, split);
        System.out.println(ans); // 输出: [ab, 2]
    }
}