package Question.sword;

import Question.leetcode.common.TreeNode;

public class O26 {
    public boolean isSubStructure(TreeNode ta, TreeNode tb) {
        return (ta != null && tb != null) && (dfsCompare(ta,tb) || isSubStructure(ta.left,tb) || isSubStructure(ta.right,tb));
    }

    private boolean dfsCompare(TreeNode ta, TreeNode tb) {
        if (tb == null) return true;
        if (ta == null) return false;

        if (ta.val != tb.val) return false;
        return dfsCompare(ta.left,tb.left) && dfsCompare(ta.right,tb.right);
    }
}
