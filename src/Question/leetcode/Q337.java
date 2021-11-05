package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.HashMap;


/**
 * Created by gump on 2021/10/19.
 */
public class Q337 {

    HashMap<TreeNode,Integer> parentRobbedMap = new HashMap<>();
    HashMap<TreeNode,Integer> parentNotRobbedMap = new HashMap<>();


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;

        Q337 q = new Q337();
        System.out.println(q.rob(n1));
    }

    public int rob(TreeNode root) {
        return Math.max(rob(root,true),rob(root,false));
    }

    private Integer rob(TreeNode root, boolean parentRobbed) {
        if (root == null) return 0;


        if (!parentRobbed) {
            if (parentNotRobbedMap.containsKey(root)){
                return parentNotRobbedMap.get(root);
            }else{
                int score = Math.max(root.val +rob(root.left,true) + rob(root.right,true),
                        rob(root.left,false) + rob(root.right,false));
                parentNotRobbedMap.put(root,score);
                return parentNotRobbedMap.get(root);
            }
        }else{
            if (parentRobbedMap.containsKey(root)){
                return parentRobbedMap.get(root);
            }else{
                int score = rob(root.left,false) + rob(root.right,false);
                parentRobbedMap.put(root,score);
                return parentRobbedMap.get(root);
            }
        }
    }
}