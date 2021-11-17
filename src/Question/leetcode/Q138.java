package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node,Node> m = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node h = head;

        while (h!=null) {
            Node cur = new Node(h.val);
            cur.next = h.next;
            h.next = cur;
            h = cur.next;
        }

        h = head;

        while (h != null) {
            Node cur = h.next;
            cur.random = (h.random == null? null:h.random.next);
            h = cur.next;
        }

        h = head;
        Node res = h.next;
        while (h != null) {
            Node cur = h.next;
            h.next = cur.next;
            h = h.next;
            if (h!=null){
                cur.next = h.next;
            }
        }

        return res;
    }

    public Node copyRandomListRecursive(Node head) {
        if (head == null) return null;

        if (!m.containsKey(head)){
            Node cur = new Node(head.val);
            m.put(head,cur);
            cur.next = copyRandomListRecursive(head.next);
            cur.random = copyRandomListRecursive(head.random);
        }
        return m.get(head);
    }

    public Node copyRandomListIterative(Node head) {
        Map<Node,Node> m = new HashMap<>();
        Node h = head;
        while (h!=null){
            Node cur = new Node(h.val);
            m.put(h,cur);
            h = h.next;
        }

        h = head;

        while (h!=null){
            Node cur = m.get(h);
            cur.random = m.getOrDefault(h.random,null);
            h = h.next;
        }
        return m.get(head);
    }
}
