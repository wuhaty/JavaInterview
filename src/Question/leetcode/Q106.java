package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2017/10/13.
 */
public class Q106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder);
    }

    private TreeNode helper(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length-1]);


//        root.left = ;
//        root.right= ;
        return root;
    }
}
