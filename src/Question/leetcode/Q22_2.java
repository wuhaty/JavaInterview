package Question.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q22_2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();

        backtrack(res,n,0,0,new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, int n, int l, int r, StringBuilder sb) {
        if (l==r && l == n) {
            res.add(sb.toString());
            return;
        }

        if (l<n) {
            sb.append('(');
            backtrack(res,n,l+1,r,sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if (r<=l){
            sb.append(')');
            backtrack(res,n,l+1,r,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
