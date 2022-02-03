package Question.mspractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M22 {
    List<String> res = new LinkedList<>();

    public List<String> generateParenthesisBacktrack(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb,0,0,n);
        return res;
    }

    private void backtrack(StringBuilder sb, int l, int r, int n) {
        if (l == r && l == n){
            res.add(sb.toString());
            return;
        }

        if (l<n){
            sb.append('(');
            backtrack(sb,l+1,r,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (r<l){
            sb.append(')');
            backtrack(sb,l,r+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
