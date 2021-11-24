package Question.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q117 {
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
    };

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            Node pre = null;
            while (size>0){
                Node n = q.poll();

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
                if (pre != null) pre.next = n;
                pre = n;
                size--;
            }
        }

        return root;
    }

}
