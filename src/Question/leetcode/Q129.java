package Question.leetcode;

/**
 * Created by gump on 2018/1/6.
 */
public class Q129 {
    static int sum =0;

    public static void main(String argc[]){
        Q129 q =new Q129();
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        n1.left = n2;
        System.out.println(q.sumNumbers(n1));
    }

    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root, int temp) {
        if (root == null) return 0;
        if (root.left ==null && root.right==null) {
            return temp*10 + root.val;
        }

        temp= (temp*10+root.val);

        int left =0,right = 0;

        if (root.left!=null){
            left = helper(root.left,temp);
        }

        if (root.right!=null){
            right = helper(root.right,temp);
        }
        return left + right;
    }
}
