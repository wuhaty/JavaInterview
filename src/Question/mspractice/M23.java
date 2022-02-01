package Question.mspractice;

import Question.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class M23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode n:lists) {
            if (n != null){
                q.offer(n);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;

        while (!q.isEmpty()){
            ListNode n = q.poll();
            pre.next = n;
            pre = n;
            if (n.next != null){
                q.offer(n.next);
            }
        }

        return dummyHead.next;
    }
}
