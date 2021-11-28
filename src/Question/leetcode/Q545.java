package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root.left != null && root.right !=null){
            res.add(root.val);
        }

        TreeNode p = root.left;

        while (p!=null){
            if (p.left == null && p.right == null) break;

            res.add(p.val);
            if (p.left == null) p=p.right;
            else p = p.left;
        }

        addLeaves(root,res,root);
        int end = res.size();

        p = root.right;

        while (p!=null){
            if (p.left == null && p.right == null) break;

            res.add(end,p.val);
            if (p.right == null) p=p.left;
            else p = p.right;
        }


        return res;
    }

    private void addLeaves(TreeNode cur, List<Integer> res,TreeNode root) {
        if (cur == null) return;
        if (cur.left==null && cur.right == null && cur != root) {
            res.add(cur.val);
        }

        addLeaves(cur.left,res,root);
        addLeaves(cur.right,res,root);
    }
}
