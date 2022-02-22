package Question.leetcode;

import java.util.*;

public class Q460 {

    class Node{
        int val;
        int key;
        int freq;

        public Node(int key, int val, int freq) {
            this.val = val;
            this.key = key;
            this.freq = freq;
        }
    }

    int capacity,minfreq;
    Map<Integer,Node> keyMap;
    Map<Integer, LinkedList<Node>> freqMap;

    public Q460(int capacity) {
        this.capacity = capacity;
        this.minfreq = 0;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) return -1;
        if (!keyMap.containsKey(key)) return -1;

        Node n = keyMap.get(key);
        int val = n.val, freq = n.freq;
        freqMap.get(freq).remove(n);

        if (freqMap.get(freq).isEmpty()){
            freqMap.remove(freq);
            if (minfreq == freq) {
                minfreq+=1;
            }
        }

        LinkedList<Node> l = freqMap.getOrDefault(freq+1,new LinkedList<>());
        l.offerFirst(new Node(key,val,freq+1));
        freqMap.put(freq + 1, l);
        keyMap.put(key,l.peekFirst());
        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)){
            Node n = keyMap.get(key);

            int freq = n.freq;
            freqMap.get(freq).remove(n);

            if (freqMap.get(freq).isEmpty()){
                freqMap.remove(freq);
                if (freq == minfreq){
                    minfreq += 1;
                }
            }

            LinkedList<Node> l = freqMap.getOrDefault(freq+1,new LinkedList<>());
            l.offerFirst(new Node(key,value,freq+1));
            freqMap.put(freq + 1,l);
            keyMap.put(key,l.peekFirst());
        }else {
            if (keyMap.size() == capacity){
                Node n = freqMap.get(minfreq).peekLast();
                keyMap.remove(n.key);
                freqMap.get(minfreq).pollLast();

                if (freqMap.get(minfreq).isEmpty()){
                    freqMap.remove(minfreq);
                }
            }

            LinkedList<Node> l = freqMap.getOrDefault(1,new LinkedList<>());
            l.offerFirst(new Node(key,value,1));
            freqMap.put(1,l);
            keyMap.put(key,l.peekFirst());
            minfreq = 1;
        }
    }

}
