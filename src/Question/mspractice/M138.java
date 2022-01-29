package Question.mspractice;

import java.util.HashMap;
import java.util.Map;

public class M138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;
        M138 m = new M138();
        m.copyRandomList(n0);
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node> m = new HashMap<>();

        Node cur = head;
        Node pre = null;

        while (cur != null){
            Node newNode = null;
            if (m.containsKey(cur)){
                newNode = m.get(cur);
            }else {
                newNode = new Node(cur.val);
                m.put(cur,newNode);
            }

            if (cur.random != null) {
                Node randomNode = cur.random;
                m.putIfAbsent(randomNode,new Node(randomNode.val));
                newNode.random = m.get(randomNode);
            }

            if (pre != null){
                pre.next = newNode;
            }
            pre = newNode;
            cur = cur.next;
        }

        return m.get(head);
    }
}
