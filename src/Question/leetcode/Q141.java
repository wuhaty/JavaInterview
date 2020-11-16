package Question.leetcode;

public class Q141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode f = head;
        ListNode s = head;

        while (s != null && f != null) {
            s = s.next;
            if (f != null && f.next != null) {
                f = f.next.next;
                if (s != null && f!=null && s == f) return true;
            }

        }
        return false;
    }
}
