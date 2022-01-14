package Question.sword;

import Question.leetcode.common.TreeNode;

public class O54 {
    Integer counter = 0;
    Integer res = 0;
    public int kthLargest(TreeNode root, int k) {
        counter = k;
        rml(root);
        return res;
    }

    private void rml(TreeNode root) {
        if (root == null) return;

        rml(root.right);
        counter--;
        if (counter==0) {
            res = root.val;
            return;
        }else if (counter<0){
            return;
        }
        rml(root.left);
    }
}
