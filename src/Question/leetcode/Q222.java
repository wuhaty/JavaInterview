package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q222 {

    public static void main(String argc[]){
        Q222 q =new Q222();
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;

        System.out.println(q.countNodes(n1));
    }

    public int countNodes(TreeNode root) {
        int count = 0;
        int h = height(root);

        while (root!=null){
            if(height(root.right)==h-1){
                count+= 1<<h;
                root = root.right;
            }else{
                count+=1<<(h-1);
                root = root.left;
            }
            h--;
        }

        return count;
    }

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left =root,right = root;
        int h = 0;
        while (right!=null){
            h++;
            left = left.left;
            right = right.right;
        }
        if(left==null) return (1<<h)-1;
        else return 1 + countNodes2(root.left) + countNodes2(right);
    }

    private int height(TreeNode root) {
        return root==null?-1:1+height(root.left);
    }
}
