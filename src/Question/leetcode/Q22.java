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
        List<String> res = q.generateParenthesis2021Backtrack(2);
        System.out.print(res);
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

    public List<String> generateParenthesis2021DP(int n) {
        List<List<String>> res = new LinkedList<>();
        res.add(Collections.singletonList(""));

        //loop n times
        for (int i = 1; i <= n; i++) {

            List<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                for (String first : res.get(j)) {
                    for (String second: res.get(i-j-1)) {
                        tmp.add("(" + first + ")" + second);
                    }
                }
            }

            res.add(tmp);
        }

        return res.get(n-1);
    }


    public List<String> generateParenthesis2021Backtrack(int n) {
        List<String> res = new LinkedList<>();
        backtrack(res,0,0,0,n,new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int i, int open, int close, int n, StringBuilder sb) {
        if (i >= 2*n) {
            res.add(sb.toString());
        }

        if (open<n) {
            sb.append("(");
            backtrack(res,i+1,open+1,close,n,sb);
            sb.deleteCharAt(i);
        }

        if (close<open) {
            sb.append(")");
            backtrack(res,i+1,open,close+1,n,sb);
            sb.deleteCharAt(i);
        }

    }
}
