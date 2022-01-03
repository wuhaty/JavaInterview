package Question.leetcode;

import Question.leetcode.common.ListNode;

import java.util.List;

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

    public ListNode swapPairs2021Recur(ListNode head) {
        if (head == null || head.next ==null){
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs2021Recur(newHead.next);
        newHead.next = head;

        return newHead;
    }

    public ListNode swapPairs2021(ListNode head) {
        if (head == null) return null;

        ListNode s = head;
        ListNode f = head.next;
        ListNode res = head.next;

        if (res == null) return s;

        while (s != null && f != null) {
            ListNode sn = s.next.next;
            ListNode fn = (f.next == null ? null : f.next.next);

            if (fn == null) {
                s.next = sn;
            } else {
                s.next = fn;
            }
            f.next = s;
            s = sn;
            f = fn;
        }

        return res;
    }
}
