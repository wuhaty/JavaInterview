package Question.leetcode;

import Question.leetcode.common.TreeNode;
import com.sun.source.tree.Tree;

public class Q450_2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key == root.val) return delete(root,key);
        else if (key<root.val) {
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }

        return root;
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root.left == null && root.right == null){
            return null;
        }

        if (root.left == null) {
            TreeNode next = findNext(root);
            root.val = next.val;
            root.right = deleteNode(root.right,root.val);
        }else {
            TreeNode prev = findPrev(root);
            root.val = prev.val;
            root.left = deleteNode(root.left,root.val);
        }

        return root;
    }

    private TreeNode findPrev(TreeNode root) {
        TreeNode res = root.left;
        while (res.right != null){
            res = res.right;
        }
        return res;
    }

    private TreeNode findNext(TreeNode root) {
        TreeNode res = root.right;
        while (res.left != null){
            res = res.left;
        }
        return res;
    }

    private TreeNode deleteOri(TreeNode root, int key) {
        TreeNode pre = root;
        if (root.left == null && root.right == null) return null;


        if (root.left == null){
            TreeNode cur = root.right;
            while (cur.left != null) {
                pre = cur;
                cur = cur.left;
            }

            root.val = cur.val;
            if (pre == root) {
                pre.right = cur.right;
            }else {
                pre.left = cur.right;
            }
        }else {
            TreeNode cur = root.left;

            while (cur.right != null) {
                pre = cur;
                cur = cur.right;
            }

            root.val = cur.val;
            if (pre == root) {
                pre.left = cur.left;
            }else {
                pre.right = cur.left;
            }
        }

        return root;
    }
}
