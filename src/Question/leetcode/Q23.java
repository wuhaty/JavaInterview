package Question.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gump on 2021/1/29.
 */
public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode n:lists) {
            if (n!=null){
                q.offer(n);
            }
        }

        ListNode cur = new ListNode(0);
        ListNode head = null;

        while (!q.isEmpty()) {
            ListNode n = q.poll();
            cur.next = n;
            cur = n;
            if (head == null) {
                head = cur;
            }

            if (n.next != null) {
                q.offer(n.next);
            }
        }

        return head;
    }
}
