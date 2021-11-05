package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gump on 2021/8/17.
 */
public class Q257 {
    List<List<String>> res = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> path = new LinkedList<>();
        dfs(root,path);
        return res.stream().map(strings -> String.join("->",strings)).collect(Collectors.toList());
    }

    private void dfs(TreeNode root, LinkedList<String> path) {
        if (root ==null) return;

        path.add(String.valueOf(root.val));

        if (root.left == null && root.right == null){
            List<String> l = new LinkedList<>();
            l.addAll(path);
            res.add(path);
        }

        dfs(root.left,path);
        dfs(root.right,path);
        path.removeLast();
    }
}
