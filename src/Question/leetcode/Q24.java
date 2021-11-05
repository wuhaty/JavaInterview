package Question.leetcode;

/**
 * Created by gump on 2021/1/29.
 */
public class Q24 {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;

        if (cur != null) {
            ListNode next = cur.next;
            while (next != null) {
                Integer t = cur.val;
                cur.val = next.val;
                next.val = t;
                cur = next.next;
                if (cur == null) break;
                next = cur.next;
            }
        }
        return head;
    }
}
