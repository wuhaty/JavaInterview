package Question.leetcode;

import Question.leetcode.common.TreeNode;

public class Q450_3 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key){
            if (root.left != null && root.right != null){
                TreeNode pre = root;
                TreeNode next = root.right;

                //find successor of root
                while (next.left != null){
                    pre = next;
                    next = next.left;
                }

                if (pre == root){
                    //next doesnt have left node
                    pre.right = next.right;
                }else {
                    //next left must be null , so just move next.right as parent's left
                    pre.left = next.right;
                }

                root.val = next.val;

            }else if (root.left == null){
                return root.right;
            }else {
                return root.left;
            }

        }else if (root.val < key){
            root.right = deleteNode(root.right,key);
        }else {
            root.left = deleteNode(root.left,key);
        }

        return root;
    }
}
