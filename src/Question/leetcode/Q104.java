package Question.leetcode;

/**
 * Created by gump on 2017/9/23.
 */
public class Q104 {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1+ Math.max(left,right);
    }
}
