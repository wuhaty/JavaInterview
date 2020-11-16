package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2017/4/23.
 */
public class Q538 {
    /**
     * 变形中序遍历,右中左
     */
    int parent= 0;
    public TreeNode convertBST(TreeNode root) {
        if(root.right!=null){
            convertBST(root.right);
        }
        root.val+=parent;
        parent =root.val;

        if(root.left!=null){
            convertBST(root.left);
        }

        return root;
    }

    public static void main(String argc[]){
        TreeNode n = new TreeNode(5);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(13);
        n.left = n1;
        n.right = n2;
        Q538 q = new Q538();
        q.convertBST(n);
    }
}
