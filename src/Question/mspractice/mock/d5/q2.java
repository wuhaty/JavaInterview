package Question.mspractice.mock.d5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class q2 {

    Set<Integer> used;
    Set<Integer> unused;

    public static void main(String[] args) {
        q2 q = new q2(3);
        q.get();
        q.get();
        q.check(2);
        q.get();
        q.check(2);
    }

    public q2(int maxNumbers) {
        used = new HashSet<>();
        unused = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            unused.add(i);
        }
    }

    public int get() {
        int target = -1;
        for (int i:unused) {
            target = i;
            used.add(i);
            break;
        }
        unused.remove(target);
        return target;
    }

    public boolean check(int number) {
        return used.contains(number);
    }

    public void release(int number) {
        used.remove(number);
        unused.add(number);
    }
}
