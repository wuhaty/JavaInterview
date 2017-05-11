package Question.leetcode;

/**
 * Created by gump on 2017/5/10.
 */
public class Q543 {
    int max= 0;

    public static void main(String argc[]){
        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);

//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;

        Q543 q =new Q543();
        q.getHeight(n1);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode root) {
        if(root == null) return -1;

        int left = 1+getHeight(root.left);
        int right = 1+getHeight(root.right);

        max = Math.max(left+right,max);

        return Math.max(left,right);
    }
}
