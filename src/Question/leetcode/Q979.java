package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/10/19.
 */
public class Q979 {
    int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        ans += Math.abs(l) + Math.abs(r);
        return root.val + l + r -1;
    }
}
