package Question.leetcode;

import Question.leetcode.common.ListNode;

/**
 * Created by gump on 2021/1/29.
 */
public class Q141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public boolean hasCycle2021(ListNode head) {
        ListNode fast = head,slow = head;

        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) return true;
        }

        return false;
    }
}
