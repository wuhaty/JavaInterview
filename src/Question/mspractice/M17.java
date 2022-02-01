package Question.mspractice;

import java.util.LinkedList;
import java.util.List;

public class M17 {
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
        if (digits==null || digits.isEmpty()) return res;

        StringBuilder sb = new StringBuilder();
        char[] cs = digits.toCharArray();
        backtrack(sb,0,cs,res);

        return res;
    }

    private void backtrack(StringBuilder sb, int i, char[] cs, List<String> res) {
        if (i == cs.length){
            res.add(sb.toString());
            return;
        }

       for (int k = 0; k < maps[cs[i]-'0'].length; k++) {
           sb.append(maps[cs[i]-'0'][k]);
           backtrack(sb,i+1,cs,res);
           sb.deleteCharAt(sb.length()-1);
       }
    }
}
