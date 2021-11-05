package Question.leetcode.weeklyContest;

import Question.leetcode.common.TreeNode;

public class W173Q1339 {

    long total = 0;
    long res;

    public int maxProduct(TreeNode root) {
        total = s(root);
        s(root);
        return (int)(res%Integer.MAX_VALUE);
    }

    private long s(TreeNode root) {
        if (root ==null) return 0;
        long sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res,sub*(total-sub));
        return sub;
    }
}
