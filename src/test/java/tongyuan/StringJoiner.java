package tongyuan;

import java.util.List;

public class StringJoiner {

    public String joinStrings(List<String> stringList, String split) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < stringList.size(); i++) {
            ans.append(stringList.get(i));
            if (i < stringList.size() - 1) {
                ans.append(split);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
//        List<String> stringList = List.of("ab", "2");
        String split = "&&";
//        String ans = joinStrings(stringList, split);
//        System.out.println(ans);
    }
}