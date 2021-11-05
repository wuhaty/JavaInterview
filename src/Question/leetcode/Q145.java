package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/8/9.
 */
public class Q145 {

    List<Integer> res = new LinkedList<>();


    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);

        return res;
    }
}
