package Question.interview.ea;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    class DLinkedNode{
        int key;
        Object val;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, Object val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer,DLinkedNode> m;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LruCache(int size) {
        capacity = size;
        m = new HashMap<>();
        head = new DLinkedNode(0,0);
        tail = new DLinkedNode(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public Object get(int key){
        if (m.containsKey(key)){
            DLinkedNode n = m.get(key);
            deleteFromList(n);
            addToFront(n);
            return n.val;
        }else {
            return null;
        }
    }

    public void put(int key,Object val){
        if (m.containsKey(key)) {
            DLinkedNode target = m.get(key);
            target.val  = val;
            deleteFromList(target);
            addToFront(target);
        }else {
            if (m.size() == capacity){
                m.remove(tail.pre.key);
                deleteFromList(tail.pre);
            }
            DLinkedNode target = new DLinkedNode(key,val);
            m.put(key,target);
            addToFront(target);
        }
    }

    private void addToFront(DLinkedNode n) {
        DLinkedNode oldHead = head.next;
        head.next = n;
        n.pre = head;
        n.next = oldHead;
        oldHead.pre = n;
    }

    private void deleteFromList(DLinkedNode n) {
        DLinkedNode next = n.next;
        DLinkedNode pre = n.pre;
        pre.next = next;
        next.pre = pre;
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);
        cache.put(1,"one");
        cache.put(2,"two");
        cache.put(3,"three");

        //key 1 should equals to one
        System.out.println("1:" + cache.get(1));

        //key 2 should be eliminated
        cache.put(4,"four");
        System.out.println("2:" + cache.get(2));
        System.out.println("4:" + cache.get(4));
    }
}
