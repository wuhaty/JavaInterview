package Question.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q17_2 {
    char maps[][] = {
      null,null,
            {'a', 'b', 'c'}
            , {'d', 'e', 'f'}
            , {'g', 'h', 'i'}
            , {'j', 'k', 'l'}
            , {'m', 'n', 'o'}
            , {'p', 'q', 'r', 's'}
            , {'t', 'u', 'v'}
            , {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (digits.isEmpty()) return res;
        backtrack(digits.toCharArray(),0,sb,res);
        return res;
    }

    private void backtrack(char[] cs, int i, StringBuilder sb, List<String> res) {
        if (i==cs.length){
            res.add(sb.toString());
            return;
        }

        char input = cs[i];
        char map[] = maps[input-'0'];
        for (char c: map) {
            sb.append(c);
            backtrack(cs,i+1,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
