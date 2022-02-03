package Question.mspractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M301 {
    Set<String> set = new HashSet<>();
    int max,len;

    public static void main(String[] args) {
        M301 m = new M301();
        m.removeInvalidParentheses(")(f");
    }


    public List<String> removeInvalidParentheses(String s) {
        int left = 0,right = 0;

        int open = 0,close = 0;
        for (char c:s.toCharArray()) {
            if (c == '('){
                open++;
            }else if (c == ')'){
                if (open!=0) open--;
                else close++;
            }
        }

        len = s.length() - open - close;

        for (char c:s.toCharArray()) {
            if (c == '('){
                left++;
            }else if (c == ')'){
                right++;
            }
        }

        max = Math.min(left,right);
        dfs(0,"",s,0,open,close);

        return new ArrayList<>(set);
    }

    private void dfs(int index, String str, String s, int score,int left, int right) {
        if (left <0 || right < 0 || score<0 || score > max) return;
        if (left ==0 && right == 0 && str.length() == len) {
            set.add(str);
        }
        if (index == s.length()) return;

        char c = s.charAt(index);

        if (c == '('){
            dfs(index + 1, str + "(" , s ,score + 1,left,right);
            dfs(index + 1, str , s ,score,left-1,right);

        }else if(c == ')'){
            dfs(index + 1, str + ")" , s ,score -1,left,right);
            dfs(index + 1, str , s ,score,left,right-1);

        }else {
            dfs(index + 1, str + c , s, score,left,right);
        }
    }
}
