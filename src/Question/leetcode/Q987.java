package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by gump on 2021/8/9.
 */
public class Q987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> res = new LinkedList<>();
        helper(res, root, 0, 0);

        List<List<Integer>> ans = new LinkedList<>();
        Collections.sort(res, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        for (int i = 0; i < res.size();) {
            int j = i;

            List<Integer> l = new LinkedList<>();
            while (res.get(j)[1] == res.get(i)[1]){
                l.add(res.get(j)[2]);
                j++;
            }
            i=j;
            ans.add(l);
        }
        return ans;
    }

    private void helper(List<int[]> res, TreeNode root, int r, int c) {
        if (root == null) return;

        helper(res, root.left, r + 1, c - 1);

        int[] a = new int[3];
        a[0] = r;
        a[1] = c;
        a[2] = root.val;
        res.add(a);

        helper(res, root.right, r + 1, c + 1);
    }
}
