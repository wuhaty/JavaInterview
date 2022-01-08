package Question.sword;

import Question.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O28 {
    public boolean isSymmetricDFS(TreeNode root) {
        if(root == null) return true;

        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r== null) return false;

        return l.val == r.val && dfs(l.left,r.right) && dfs(l.right,r.left);
    }


    public boolean isSymmetricIter(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);

        while (!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();

            if (l == null && r == null) {
                continue;
            }

            if (l == null || r == null || l.val != r.val) {
                return false;
            }

            q.offer(l.left);
            q.offer(r.right);
            q.offer(l.right);
            q.offer(r.left);
        }

        return true;
    }

}
