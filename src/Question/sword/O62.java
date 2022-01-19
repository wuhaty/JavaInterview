package Question.sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class O62 {
    public static void main(String[] args) {
        O62 q = new O62();
        q.lastRemainingSim(5,2);
    }

    public int lastRemainingSim(int n, int m) {
        List<Integer> l = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            l.add(i);
        }

        int count = n;
        int idx = 0;
        while (count>1){
            idx = (idx + m) % count;
            l.remove(idx);
            count--;
        }

        return l.get(0);
    }

    public int lastRemaining(int n, int m) {
        return f(n,m);
    }

    private int f(int n, int m) {
        if (n==1) return 0;

        int x = f(n-1,m);
        return (m+x)%n;
    }
}
