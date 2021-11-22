package Question.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gump on 2021/7/2.
 */
public class Q116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connectRecusive(Node root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        root.left.next = root.right;

        if (root.next != null) {
            root.right.next =  root.next.left;
        }

        connectRecusive(root.left);
        connectRecusive(root.right);
        return root;
    }


    public Node connect(Node root) {
        if (root == null) return root;

        Node head = root;
        while (head.left != null) {
            Node leftmost = head.left;
            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next  =head.next.left;
                }
                head = head.next;
            }

            head = leftmost;
        }
        return root;
    }


    public Node connect2021(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node pre = null;
            while (size > 0){
                Node n = q.poll();

                if (pre != null) {
                    pre.next = n;
                }
                pre = n;
                size--;
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
        }

        return root;
    }

    public Node connect2021Recur(Node root) {
        if (root == null || root.left == null || root.right == null ) {
            return root;
        }

        root.left.next  = root.right;

        if (root.next != null){
            root.right.next = root.next.left;
        }

        connect2021Recur(root.left);
        connect2021Recur(root.right);
        return root;
    }
}
