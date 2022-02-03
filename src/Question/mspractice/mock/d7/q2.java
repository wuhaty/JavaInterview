package Question.mspractice.mock.d7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q2 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            while (size-->0){
                Node n = q.poll();
                l.add(n.val);
                for (Node child:n.children) {
                    q.offer(child);
                }
            }
            res.add(l);
        }

        return res;
    }
}
