package Question.mspractice.mock.d3;

import Question.leetcode.common.TreeNode;

public class q1 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean l = dfs(root.left,p,q);
        boolean r = dfs(root.right,p,q);


        if (l && r) ans = root;
        if ((root == p || root == q) && (l ||r)) ans = root;
        return l || r || root == p || root == q;
    }

}
