package Question.mspractice.mock.d6;

import Question.leetcode.common.ListNode;

public class q3 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            slow = slow.next;
            if (fast.next == null) break;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (slow != fast) return null;
        slow = head;

        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
