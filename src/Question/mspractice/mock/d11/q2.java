package Question.mspractice.mock.d11;

import Question.leetcode.common.TreeNode;

public class q2 {

    class TreeNodeWithDepth{
        TreeNode n;
        int depth;

        public TreeNodeWithDepth(TreeNode n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).n;
    }

    private TreeNodeWithDepth dfs(TreeNode root) {
        if (root == null) return new TreeNodeWithDepth(null,0);

        TreeNodeWithDepth l = dfs(root.left);
        TreeNodeWithDepth r = dfs(root.right);

        if (l.depth == r.depth) return new TreeNodeWithDepth(root,l.depth+1);
        else return l.depth>r.depth? new TreeNodeWithDepth(l.n,l.depth+1):new TreeNodeWithDepth(r.n,r.depth+1);
    }
}
