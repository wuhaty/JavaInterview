package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q146_3 {

    class DNode{
        DNode pre;
        DNode next;
        int key;
        int val;

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DNode head;
    DNode tail;
    Map<Integer,DNode> m;
    int capacity;

    public static void main(String[] args) {
        Q146_3 q= new Q146_3(2);
        q.put(2,1);
        q.put(1,1);
        q.put(2,3);
        q.put(4,1);
        q.get(1);
        q.get(2);
    }

    public Q146_3(int _capacity) {
        m = new HashMap<>();
        this.capacity = _capacity;
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (m.containsKey(key)){
            DNode newHead = m.get(key);
            deleteNode(newHead);
            addToFront(newHead);
            return newHead.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)){
            DNode n = m.get(key);
            n.val = value;
            deleteNode(n);
            addToFront(n);
            m.put(key,n);
        }else {
            DNode n = new DNode(key,value);
            if (m.size() >= capacity){
                DNode oldTail = tail.pre;
                deleteNode(oldTail);
                m.remove(oldTail.key);
            }
            addToFront(n);
            m.put(key,n);
        }
    }


    private void addToFront(DNode newHead) {
        DNode oldHead = head.next;
        head.next = newHead;
        newHead.next = oldHead;
        oldHead.pre = newHead;
        newHead.pre = head;
    }

    private void deleteNode(DNode newHead) {
        DNode pre = newHead.pre;
        DNode next = newHead.next;
        pre.next = next;
        next.pre = pre;
    }
}
