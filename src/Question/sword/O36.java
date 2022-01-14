package Question.sword;

public class O36 {
    boolean LEFT = true;
    boolean RIGHT = false;

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        if (pre == null){
            head = root;
        }else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        inOrder(root.right);
    }
}
