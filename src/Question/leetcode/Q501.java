package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/5/30.
 */
public class Q501 {

    Integer max_fre = 0;
    Integer fre = 0;
    Integer pre = null;
    List<Integer> result = new LinkedList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        Integer cur = root.val;
        if (cur.equals(pre)) {
            fre ++;
        }else {
            fre = 1;
        }
        addResult(cur);
        pre = cur;
        inorder(root.right);
    }


    public void addResult(Integer cur){
        if (fre.equals(max_fre)) {
            result.add(cur);
        }else if (fre > max_fre) {
            max_fre = fre;
            result = new LinkedList<>();
            result.add(cur);
        }
    }
}
