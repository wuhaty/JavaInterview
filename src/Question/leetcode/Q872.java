package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/8/14.
 */
public class Q872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        dfs(root1,l1);
        dfs(root2,l2);

        return l1.equals(l2);
    }

    private void dfs(TreeNode root2, List<Integer> l2) {
        if (root2 == null) return;

        if (root2.left == null && root2.right ==null){
            l2.add(root2.val);
        }

        dfs(root2.left,l2);
        dfs(root2.right,l2);
    }
}
