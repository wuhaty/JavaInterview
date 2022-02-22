package Question.mspractice;

import Question.leetcode.common.TreeNode;

public class M337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);

        return Math.max(res[0],res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0,0};

        int[] l =dfs(root.left);
        int[] r =dfs(root.right);

        int selected = root.val + l[1] + r[1];
        int notSelect = Math.max(l[0],l[1]) + Math.max(r[0],r[1]);

        return new int[]{selected,notSelect};
    }
}
