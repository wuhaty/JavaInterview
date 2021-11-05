package Question.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gump on 2021/8/9.
 */
public class Q429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        q.offer(root);
        while (!q.isEmpty()) {
            int end = q.size();
            List<Integer> l = new LinkedList<>();
            while (end >0){
                Node n = q.poll();
                l.add(n.val);
                if (n.children != null) {
                    for (Node cn:n.children) {
                        q.offer(cn);
                    }
                }
                end--;
            }
            res.add(l);
        }

        return res;
    }
}
