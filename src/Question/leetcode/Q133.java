package Question.leetcode;

import java.sql.Connection;
import java.util.*;

/**
 * Created by gump on 2017/4/22.
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
public class Q133 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null )return null;

        LinkedList<UndirectedGraphNode> q = new LinkedList<>();
        Map<Integer,UndirectedGraphNode> m = new HashMap<>();

        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        m.put(result.label,result);
        q.offer(node);

        while (!q.isEmpty()){
            UndirectedGraphNode it = q.poll();
            for (UndirectedGraphNode i:it.neighbors) {
                if(!m.containsKey(i.label)){
                    m.put(i.label,new UndirectedGraphNode(i.label));
                    q.offer(i);
                }
                m.get(it.label).neighbors.add(m.get(i.label));
            }
        }

        return result;
    }
}
