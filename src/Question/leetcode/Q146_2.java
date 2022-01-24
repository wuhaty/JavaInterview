package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q146_2 {

    public static void main(String[] args) {
        Q146_2 q =new Q146_2(2);
        q.put(1,1);
        q.put(2,2);
        q.get(1);
        q.put(3,3);
        q.get(2);
    }

    class DlinkedNode{
        int val;
        int key;
        DlinkedNode pre;
        DlinkedNode next;

        public DlinkedNode(int val,int key) {
            this.val = val;
            this.key = key;
        }
    }

    Map<Integer,DlinkedNode> m;
    DlinkedNode head;
    DlinkedNode tail;
    int size;

    public Q146_2(int capacity) {
        m = new HashMap<>();
        head = new DlinkedNode(0,0);
        tail = new DlinkedNode(0,0);
        head.next = tail;
        tail.pre = head;
        size = capacity;
    }

    public int get(int key) {
        if (m.containsKey(key)){
            DlinkedNode n = m.get(key);
            deleteNode(n);
            moveToFront(n);
            return m.get(key).val;
        }else {
            return -1;
        }
    }


    public void put(int key, int value) {
        if (m.containsKey(key)){
            DlinkedNode n = m.get(key);
            n.val = value;
            deleteNode(n);
            moveToFront(n);
        }else {
            DlinkedNode n = new DlinkedNode(key,value);
            if (m.size() >= size){
                DlinkedNode last = tail.pre;
                if (last != head){
                    m.remove(last.key);
                    deleteNode(last);
                }
                moveToFront(n);
            }else {
                moveToFront(n);
            }
            m.put(key,n);
        }
    }

    private void deleteNode(DlinkedNode n) {
        DlinkedNode pre = n.pre;
        DlinkedNode next = n.next;
        pre.next = next;
        next.pre = pre;
    }


    private void moveToFront(DlinkedNode n) {
        DlinkedNode h = head.next;
        n.next = h;
        h.pre = n;
        head.next = n;
        n.pre = head;
    }
}
