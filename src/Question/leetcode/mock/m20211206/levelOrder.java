package Question.leetcode.mock.m20211206;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
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
    };
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new LinkedList<>();
            while (size>0){
                Node n = q.poll();
                l.add(n.val);

                for (Node c:n.children) {
                    q.offer(c);
                }
                size--;
            }
            res.add(l);
        }

        return  res;
    }
}
