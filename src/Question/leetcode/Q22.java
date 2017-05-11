package Question.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2017/5/11.
 */
public class Q22 {

    public static void main(String argc[]) {
        Q22 q = new Q22();
        q.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generate(result,"",0,0,n);
        return result;
    }

    private void generate(List<String> result, String s, int open, int close, int max) {
        if(s.length() == 2*max){
            result.add(s);
            return;
        }

        if (open<max) generate(result,s+"(",open+1,close,max);

        if (close<open) generate(result,s+")",open,close+1,max);
    }


    public List<String> generateParenthesisOri(int n) {
        List<String> result = new LinkedList<>();

        int i = 0;
        while (i++ < n) {
            if (result.isEmpty()) {
                result.add("()");
            } else {
                int size = result.size();
                while (size-- > 0) {
                    String s = result.remove(0);
                    for (int j = 0; j < s.length(); j++) {
                        String temp = s.substring(0, j) + "()" + s.substring(j, s.length());
                        if (!result.contains(temp)) {
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<String> generateParenthesisDP(int n)
    {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i)
        {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j)
            {
                for (final String first : lists.get(j))
                {
                    for (final String second : lists.get(i - 1 - j))
                    {
                        list.add("(" + first + ")" + second);
                    }
                }
            }
            lists.add(list);
        }
        return lists.get(lists.size() - 1);
    }
}
