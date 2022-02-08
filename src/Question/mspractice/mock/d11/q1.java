package Question.mspractice.mock.d11;

import Question.leetcode.common.TreeNode;

import java.util.*;

public class q1 {
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delete = new HashSet<>();
        for (int v:to_delete) {
            delete.add(v);
        }

        dfs(root,true,delete);
        return res;
    }

    private boolean dfs(TreeNode root,boolean isAdd, Set<Integer> delete) {
        if (root == null) return false;

        if (delete.contains(root.val)){
            if (dfs(root.left,true,delete)) root.left = null;
            if (dfs(root.right,true,delete)) root.right = null;
            return true;
        }else {
            if (isAdd) res.add(root);
            if (dfs(root.left,false,delete)) root.left = null;
            if (dfs(root.right,false,delete)) root.right = null;
        }
        return false;
    }
}
