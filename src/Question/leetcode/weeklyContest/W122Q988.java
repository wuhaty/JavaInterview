package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2019/2/10.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class W122Q988 {

    public static void main(String args[]){
        W122Q988 q = new W122Q988();
    }


    public String smallestFromLeaf(TreeNode root) {
        return helper(root,"");
    }


    public String helper(TreeNode root, String res){
        if (root == null) return null;

        char temp = (char)('a' + root.val);
        res = temp + res;

        String left = null;
        String right = null;

        if (root.left == null && root.right == null) return res;    //leaf node

        if (root.left !=null) left = helper(root.left,res);
        if (root.right!=null) right = helper(root.right,res);

        if (left == null) return right;
        if (right == null) return left;
        else return left.compareTo(right) >0 ? right:left;
    }

}
