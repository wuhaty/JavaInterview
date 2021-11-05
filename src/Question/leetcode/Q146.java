package Question.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by gump on 2021/6/13.
 */
public class Q146 {

    public static void main(String[] args) {
        Q146 q = new Q146();
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }


//
//    static class LRUCache {
//        class DLinkedNode {
//            DLinkedNode prev;
//            DLinkedNode next;
//            int val;
//            int key;
//
//            public DLinkedNode(int val, int key) {
//                this.val = val;
//                this.key = key;
//            }
//
//            public DLinkedNode() {
//            }
//        }
//        int size;
//        int curSize;
//        Map<Integer,DLinkedNode> map = new HashMap<>();
//        DLinkedNode head;
//        DLinkedNode tail;
//
//        public LRUCache(int capacity) {
//            head = new DLinkedNode();
//            tail = new DLinkedNode();
//            head.next = tail;
//            tail.prev = head;
//            size = capacity;
//        }
//
//        public int get(int key) {
//            DLinkedNode n = map.get(key);
//
//            if (n==null) return -1;
//            removeNode(n);
//            moveToHead(n);
//            return n.val;
//        }
//
//        private void removeNode(DLinkedNode n) {
//            n.prev.next = n.next;
//            n.next.prev = n.prev;
//        }
//
//        private void moveToHead(DLinkedNode n) {
//            n.next = head.next;
//            n.prev = head;
//            head.next.prev = n;
//            head.next = n;
//        }
//
//        public void put(int key, int value) {
//            DLinkedNode n = map.get(key);
//
//            if (null == n) {
//                curSize ++;
//                n = new DLinkedNode(value,key);
//            }else {
//                n.val = value;
//                removeNode(n);
//            }
//
//            map.put(key,n);
//            moveToHead(n);
//            if (curSize > size) {
//                map.remove(tail.prev.key);
//                removeTail();
//                curSize--;
//            }
//        }
//
//        private void removeTail() {
//            DLinkedNode t = tail.prev;
//            t.prev.next = tail;
//            tail.prev = t.prev;
//        }
//    }

    static class LRUCache {

        class  DNode{
            DNode pre;
            DNode next;
            Integer val;
            Integer key;

            public DNode(Integer key,Integer val) {
                this.key = key;
                this.val = val;
            }
        }


        HashMap<Integer,DNode> m = new HashMap<>();
        int cap = 0;
        DNode head = new DNode(-1,-1);
        DNode tail = new DNode(-1,-1);

        public LRUCache(int capacity) {
            cap = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!m.containsKey(key)) return -1;

            DNode res = m.get(key);
            removeFromList(res);
            addToHead(res);

            return res.val;
        }

        private void removeFromList(DNode cur) {
            cur.pre.next= cur.next;
            cur.next.pre = cur.pre;
        }

        private void addToHead(DNode cur) {
            DNode h = head.next;
            cur.next = h;
            h.pre = cur;
            head.next = cur;
            cur.pre = head;
        }

        public void put(int key, int value) {
            if (m.containsKey(key)) {
                DNode target = m.get(key);
                target.val  = value;
                removeFromList(target);
                addToHead(target);
            }else {
                if (m.size() == cap){
                    m.remove(tail.pre.key);
                    removeFromList(tail.pre);
                }
                DNode target = new DNode(key,value);
                m.put(key,target);
                addToHead(target);
            }
        }
    }
}
