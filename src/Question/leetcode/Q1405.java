package Question.leetcode;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1405 {
    public static void main(String[] args) {
        Q1405 q = new Q1405();
        System.out.println(q.longestDiverseString(7,1,0));
    }



    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<AbstractMap.SimpleEntry<Character,Integer>> q = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Character, Integer>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Character, Integer> o1, AbstractMap.SimpleEntry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        q.offer(new AbstractMap.SimpleEntry<>('a',a));
        q.offer(new AbstractMap.SimpleEntry<>('b',b));
        q.offer(new AbstractMap.SimpleEntry<>('c',c));

        StringBuilder sb = new StringBuilder();
        int cur = 0;
        char curChar = ' ';
        while (true) {
            AbstractMap.SimpleEntry<Character,Integer> e = q.poll();

            if (e.getValue() == 0) return sb.toString();

            if (e.getKey() != curChar) {
                cur = 1;
                curChar = e.getKey();
                e.setValue(e.getValue()-1);
                sb.append(e.getKey());
                q.offer(e);
            }else{
                cur ++;
                if (cur >= 3) {
                    //need to replace
                    AbstractMap.SimpleEntry<Character,Integer> e2 = q.poll();
                    if (e2.getValue() == 0) return sb.toString();

                    q.offer(e);
                    curChar = e2.getKey();
                    e2.setValue(e2.getValue()-1);
                    q.offer(e2);
                    sb.append(e2.getKey());
                    cur = 1;
                }else{
                    e.setValue(e.getValue()-1);
                    sb.append(e.getKey());
                    q.offer(e);
                }
            }
        }
    }
}
