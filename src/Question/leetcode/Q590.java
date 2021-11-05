package Question.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by gump on 2021/8/9.
 */
public class Q590 {
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

    public List<Integer> postorder(Node root) {
        Stack<Node> s = new Stack<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        s.push(root);

        while (!s.isEmpty()) {
            Node n = s.pop();
            res.add(res.size(),n.val);

            if (n.children!=null) {
                for (Node cn:n.children) {
                    s.push(cn);
                }
            }
        }

        return res;
    }
}
