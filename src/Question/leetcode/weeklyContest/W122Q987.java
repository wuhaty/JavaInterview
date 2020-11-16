package Question.leetcode.weeklyContest;

import Question.leetcode.common.TreeNode;

import java.util.*;


public class W122Q987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,TreeSet<Integer>>> m = new TreeMap<>();

        helper(0,0,root,m);

        List<List<Integer>> res = new LinkedList<>();

        for (TreeMap<Integer,TreeSet<Integer>> t:m.values()) {
            List<Integer> temp = new LinkedList<>();
            t.values().forEach(temp::addAll);
            res.add(temp);
        }

        return res;
    }

    private void helper(int x, int y, TreeNode root, TreeMap<Integer, TreeMap<Integer,TreeSet<Integer>>> m) {
        if (!m.containsKey(x)){
            TreeMap<Integer,TreeSet<Integer>> s = new TreeMap<>();
            TreeSet<Integer> q = new TreeSet<>();
            q.add(root.val);
            s.put(y,q);
            m.put(x,s);
        }else{
            TreeMap<Integer,TreeSet<Integer>> xx = m.get(x);
            xx.putIfAbsent(y,new TreeSet<>());
            TreeSet<Integer> yy = xx.get(y);
            yy.add(root.val);
        }

        if (root.left != null) helper(x-1,y+1,root.left,m);
        if (root.right != null) helper(x+1,y+1,root.right,m);
    }
}
