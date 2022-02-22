package Question.mspractice;

import java.util.HashMap;
import java.util.Map;

public class M146_2 {

    class DlinkedNode{
        int key;
        int val;
        DlinkedNode pre;
        DlinkedNode next;

        public DlinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DlinkedNode head;
    DlinkedNode tail;
    Map<Integer,DlinkedNode> m;
    int capacity;

    public M146_2(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>();
        head = new DlinkedNode(0,0);
        tail = new DlinkedNode(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (m.containsKey(key)){
            DlinkedNode n = m.get(key);
            deleteFromList(n);
            moveToFront(n);
            return n.val;
        }else {
            return -1;
        }
    }

    private void moveToFront(DlinkedNode n) {
        DlinkedNode oldHead = head.next;
        head.next = n;
        n.pre = head;
        n.next = oldHead;
        oldHead.pre = n;
    }

    private void deleteFromList(DlinkedNode n) {
        DlinkedNode next = n.next;
        DlinkedNode pre = n.pre;
        pre.next = next;
        next.pre = pre;
    }

    public void put(int key, int value) {
        if (m.containsKey(key)){
            DlinkedNode n = m.get(key);
            n.val = value;
            deleteFromList(n);
            moveToFront(n);
            m.put(key,n);
        }else {
            DlinkedNode n = new DlinkedNode(key,value);
            if (m.size() >= capacity){
                m.remove(tail.pre.key);
                deleteFromList(tail.pre);
            }
            moveToFront(n);
            m.put(key,n);
        }
    }
}
