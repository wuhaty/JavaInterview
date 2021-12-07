package Question.leetcode.mock.m20211207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combine {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,1,k,new LinkedList<>());
        return res;
    }

    private void backtrack(int n, int i, int k, LinkedList<Integer> l) {
        if (l.size()==k){
            res.add(new ArrayList<>(l));
            return;
        }

        if (i>n)return;
        //add current number
        l.add(i);
        backtrack(n,i+1,k,l);
        l.removeLast();
        backtrack(n,i+1,k,l);
    }
}
