package Question.mspractice;

import Question.leetcode.common.TreeNode;

public class M450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key){
            if (root.left != null && root.right != null){
                TreeNode pre = root;
                TreeNode next = root.right;

                while (next.left != null){
                    pre = next;
                    next = next.left;
                }

                if (pre == root){
                    pre.right = next.right;
                }else {
                    pre.left = next.right;
                }
                root.val = next.val;

            }else if (root.left != null){
                return root.left;
            }else {
                return root.right;
            }
        }else if (root.val < key){
            root.right = deleteNode(root.right,key);
        }else {
            root.left = deleteNode(root.left,key);
        }

        return root;
    }
}
