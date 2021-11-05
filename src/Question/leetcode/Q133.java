package Question.leetcode;

import java.sql.Connection;
import java.util.*;

/**
 * Created by gump on 2017/4/22.
 */

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class Q133 {

    public Node cloneGraph(Node node) {
        if(node == null )return null;

        LinkedList<Node> q = new LinkedList<>();
        Map<Integer,Node> m = new HashMap<>();

        Node result = new Node(node.val);
        m.put(result.val,result);
        q.offer(node);

        while (!q.isEmpty()){
            Node it = q.poll();
            for (Node i:it.neighbors) {
                if(!m.containsKey(i.val)){
                    m.put(i.val,new Node(i.val));
                    q.offer(i);
                }
                m.get(it.val).neighbors.add(m.get(i.val));
            }
        }

        return result;
    }

    Map<Integer,Node> m = new HashMap<>();

    public Node cloneGraph2021(Node node) {
        if (node == null) return null;

        if (m.containsKey(node.val)) return m.get(node.val);

        Node clone = new Node(node.val);
        m.put(node.val,clone);

        for (Node n:node.neighbors) {
            clone.neighbors.add(cloneGraph2021(n));
        }
        return clone;
    }


}
