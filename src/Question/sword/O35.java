package Question.sword;

import java.util.HashMap;
import java.util.Map;

public class O35 {
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

    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Map<Node,Node> m = new HashMap<>();

        Node iterator = head;
        while (iterator != null) {
            m.put(iterator,new Node(iterator.val));
            iterator = iterator.next;
        }

        iterator = head;
        while (iterator != null) {
            Node cur = m.get(iterator);
            if (iterator.next != null) {
                cur.next = m.get(iterator.next);
            }

            if (iterator.random != null){
                cur.random = m.get(iterator.random);
            }
            iterator = iterator.next;
        }

        return m.get(head);
    }

    public Node copyRandomListWithoutHash(Node head) {
        if (head == null) return null;

        //insert nodes
        for (Node oldNode = head; oldNode != null; oldNode = oldNode.next.next) {
            Node newNode = new Node(oldNode.val);
            newNode.next = oldNode.next;
            oldNode.next = newNode;
        }

        Node res = head.next;
        for (Node oldNode = head; oldNode != null; oldNode = oldNode.next.next) {
            Node newNode = oldNode.next;
            newNode.random = (oldNode.random == null? null: oldNode.random.next);
        }


        for (Node oldNode = head; oldNode != null; oldNode = oldNode.next) {
            Node newNode = oldNode.next;
            oldNode.next = oldNode.next.next;
            newNode.next = newNode.next == null? null:newNode.next.next;
        }
        return res;
    }
}
