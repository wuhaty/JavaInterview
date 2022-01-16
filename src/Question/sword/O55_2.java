package Question.sword;

import Question.leetcode.common.TreeNode;

public class O55_2 {


    public boolean isBalanced(TreeNode root) {
        return postOrder(root)>=0;
    }

    private int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);


        boolean isBalanced = Math.abs(left-right) <=1;

        if (left == -1 || right == -1 || !isBalanced){
            return -1;
        }else {
            return Math.max(left,right) + 1;
        }
    }
}
