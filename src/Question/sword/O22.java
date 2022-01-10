package Question.sword;

import Question.leetcode.common.ListNode;

public class O22 {
    int count = 0;

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;

        ListNode n = getKthFromEnd(head.next,k);
        count++;
        if (count == k) return head;
        return n;
    }

    public ListNode getKthFromEndFS(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0){
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
