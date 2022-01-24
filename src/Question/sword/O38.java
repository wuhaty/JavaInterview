package Question.sword;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class O38 {

    List<String> res = new LinkedList<>();

    public static void main(String[] args) {
        O38 q = new O38();
        q.permutation("abc");
    }

    public String[] permutation(String s) {
        if (s == null || s.isEmpty()) {
            return res.toArray(new String[0]);
        }

        char[] cs = s.toCharArray();

        backtrack(cs,0);

        return res.toArray(new String[0]);
    }

    private void backtrack(char[] cs, int i) {
        if (i == cs.length){
            res.add(new String(cs));
            return;
        }

        Set<Character> visited = new HashSet<>();
        for (int j = i; j < cs.length; j++) {
            if (visited.contains(cs[j])) continue;
            visited.add(cs[j]);
            swap(cs,i,j);
            backtrack(cs,i+1);
            swap(cs,i,j);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
