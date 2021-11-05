package Question.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gump on 2021/9/1.
 */
public class Q9 {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        if (x == 0) return true;
        Deque<Integer> q = new LinkedList<>();

        while (x >0) {
            q.offer(x%10);
            x/=10;
        }

        while (q.size()>1){
            int start = q.poll();
            int end = q.pollLast();

            if (start != end) return false;
        }
        return q.size()<=1;
    }
}
