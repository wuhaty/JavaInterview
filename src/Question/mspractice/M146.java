package Question.mspractice;

import java.util.HashMap;
import java.util.Map;

public class M146 {

    class DNode{
        DNode next;
        DNode prev;
        int key;
        int val;

        public DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DNode head;
    DNode tail;
    Integer capacity;
    Map<Integer,DNode> m;

    public M146(int capacity) {
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.prev = head;
        this.m = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (m.containsKey(key)){
            DNode n = m.get(key);
            deleteNode(n);
            addtoFront(n);
            return n.val;
        }else {
            return -1;
        }
    }


    public void put(int key, int value) {
        if (m.containsKey(key)){
            DNode n = m.get(key);
            n.val = value;
            deleteNode(n);
            addtoFront(n);
        }else {
            DNode n = new DNode(key,value);
            if (m.size() >= capacity){
                m.remove(tail.prev.val);
                deleteNode(tail.prev);
            }
            m.put(key,n);
            addtoFront(n);
        }
    }


    private void deleteNode(DNode n) {
        DNode pre = n.prev;
        DNode next = n.next;
        pre.next = next;
        next.prev = pre;
    }

    private void addtoFront(DNode n) {
        DNode oldHead = head.next;
        head.next = n;
        n.next = oldHead;
        n.prev = head;
        oldHead.prev = n;
    }
}
