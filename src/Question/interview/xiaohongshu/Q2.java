package Question.interview.xiaohongshu;

import java.util.*;

public class Q2 {

    static class ListWithIndex {
        public List<Integer> l;
        public int i;

        ListWithIndex(List<Integer> list, int index) {
            this.l = list;
            this.i = index;
        }
    }


    public static void main(String[] args) {
        Q2 q = new Q2();

        List<List<Integer>> l = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            l.add(new LinkedList<>());
        }
        Random random = new Random();
        for (List<Integer> list : l) {
            for (int i = 0; i < 5; i++) {
                list.add(random.nextInt(10));
            }
            list.sort((Comparator.comparingInt(o -> o)));
        }

        List<Integer> res = merge(l);
        for (Integer i : res) {
            System.out.println(i + '\t');
        }
    }

    public static List<Integer> merge(List<List<Integer>> lists) {
        List<Integer> res = new LinkedList<>();

        PriorityQueue<List<Integer>> q = new PriorityQueue<>((o1, o2) -> {
            if (!o1.isEmpty() && !o2.isEmpty()) {
                return o1.get(0) - o2.get(0);
            } else {
                return 0;
            }
        });

        int limit = 0;
        for (List<Integer> l : lists) {
            limit += l.size();
            q.offer(l);
        }

        while (limit-- > 0) {
            List<Integer> l = q.poll();
            res.add(l.get(0));
            l.remove(0);
            if (l.size() != 0) {
                q.offer(l);
            }
        }

        return res;
    }
}
