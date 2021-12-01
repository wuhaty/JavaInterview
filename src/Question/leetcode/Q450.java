package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/5/30.
 */
public class Q450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) return null;
        if (root.val == key && root.left == null && root.right == null) return null;


        if (root.val == key) {
            if (root.right!=null) {
                TreeNode min = findMin(root.right,key);
                root.val = min.val;
                root.right = deleteNode(root.right,min.val);
                return root;
            }else {
                root.val = root.left.val;
                root.left.val = key;
            }
        }

        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right,key);
        return root;
    }

    private TreeNode findMin(TreeNode node,int key){
        while(node.left != null && node.val != key){
            node = node.left;
        }
        return node;
    }

    public TreeNode deleteNode2021(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode2021(root.right,key);
        }else if (root.val > key) {
            root.left = deleteNode2021(root.left,key);
        }else {
            if (root.left == null) {
                return root.right;
            }else if (root.right == null){
                return root.left;
            }

            TreeNode min = findMin2021(root.right);
            root.val = min.val;
            root.right = deleteNode2021(root.right,min.val);
        }

        return root;
    }

    private TreeNode findMin2021(TreeNode root) {
        while (root!= null && root.left != null) {
            root = root.left;
        }
        return root;
    }


    public TreeNode deleteNode2021_2(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode2021_2(root.left,key);
        }else if (key > root.val){
            root.right = deleteNode2021_2(root.right,key);
        }else {
            if (root.left == null && root.right == null) return null;
            if (root.right == null) return root.left;
            TreeNode pre = root;
            TreeNode rightMin = root.right;
            while (rightMin.left!=null){
                pre = rightMin;
                rightMin = rightMin.left;
            }
            rightMin.left = root.left;
            if (rightMin!=root.right){
                pre.left = rightMin.right;
                rightMin.right = root.right;
            }
            return rightMin;
        }

        return root;
    }
}
