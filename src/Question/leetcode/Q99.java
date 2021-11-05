package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/4/22.
 */
public class Q99 {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }



    public void recoverTree2021(TreeNode root) {
        traverse2021(root);

        Integer t = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = t;
    }

    private void traverse2021(TreeNode root) {
        if (null == root) return;

        if (root.left != null) {
            traverse2021(root.left);
        }

        Integer cur = root.val;

        if (cur < prevElement.val) {
            if (firstElement == null && secondElement ==null) {
                firstElement = prevElement;
                secondElement = root;
            }else {
                secondElement = root;
            }
        }else {
            prevElement = root;
        }

        traverse2021(root.right);
    }


    public static void main(String[] args) {
        Q99 q = new Q99();

        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n6 = new TreeNode(6);
        TreeNode n4 = new TreeNode(4);
        n5.left = n4;
        n5.right = n6;
        n4.left = n2;
        n4.right = n3;

        q.recoverTree2021(n5);
        System.out.println("Hi");
    }
}
