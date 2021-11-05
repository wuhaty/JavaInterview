package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2021/8/17.
 */
public class Q437 {
    Integer res = 0;
    Integer target = 0;
    Map<Integer,Integer> m = new HashMap<>();

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.right = r2;
        r2.right =r3;
        r3.right= r4;
        r4.right = r5;
        Q437 q =new Q437();
        q.pathSum(r1,3);
        System.out.println(q.res);
    }

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        m.put(0,1);
        preSum(root,0);
        return res;
    }

    private void preSum(TreeNode root, int curSum) {
        if (root==null)return;
        curSum +=root.val;

        if (m.containsKey(curSum-target)){
            res+=m.get(curSum-target);
        }
        m.put(curSum,m.getOrDefault(curSum,0)+1);
        preSum(root.left,curSum);
        preSum(root.right,curSum);
        m.put(curSum,m.get(curSum)-1);
    }

}
