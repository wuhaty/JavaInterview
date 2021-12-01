package Question.leetcode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Q706 {

    int BASE = 769;
    List<int[]> container[];


    public Q706() {
        container = new List[BASE];
        for (int i = 0; i < BASE; i++) {
            container[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);

        for (int[] l:container[h]) {
            if (l[0] == key) {
                l[1] = value;
                return;
            }
        }
        int l[] = new int[2];
        l[0] = key;
        l[1] = value;
        container[h].add(l);
    }

    public int get(int key) {
        int h = hash(key);

        if (container[h].size() == 0) {
            return -1;
        }

        for (int[] l:container[h]) {
            if (l[0] == key) {
                return l[1];
            }
        }

        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        container[h].removeIf(l -> key == l[0]);
    }

    public int hash(int key){
        return key%BASE;
    }
}
