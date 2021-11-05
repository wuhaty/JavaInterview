package Question.leetcode;

/**
 * Created by gump on 2021/1/29.
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode res = reverseList(next);
        next.next = head;
        head.next = null;
        return res;
    }

    public ListNode iterative_reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return head;
    }

}
