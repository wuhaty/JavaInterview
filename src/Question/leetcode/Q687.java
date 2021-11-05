package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2021/8/22.
 */
public class Q687 {

    int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;

        postOrder(root);

        return max;
    }

    private Integer postOrder(TreeNode root) {
        if (root == null) return 0;

        Integer left = postOrder(root.left);
        Integer right = postOrder(root.right);


        int ls = 0;
        int rs = 0;
        if (root.left != null && root.val == root.left.val){
            ls += left +1;
        }

        if (root.right != null && root.val == root.right.val){
            rs +=right+1;
        }

        max = Math.max(max,ls+rs);

        return Math.max(rs,ls);
    }
}
