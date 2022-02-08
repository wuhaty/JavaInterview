package Question.leetcode;

public class Q510 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node inorderSuccessor(Node root) {
        if (root.right != null){
            Node ans = root.right;
            root = root.right;
            while (root.left != null){
                root = root.left;
                ans = root;
            }
            return ans;
        }else {
            while (root.parent != null && root.parent.right == root){
                root = root.parent;
            }

            return root.parent;
        }
    }
}
