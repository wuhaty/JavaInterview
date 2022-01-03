package Question.leetcode;

import Question.leetcode.common.ListNode;

public class Q142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode f = head;
        ListNode s = head;


        while (f!= null && s!= null) {
            s = s.next;

            if (f.next != null) {
                f = f.next.next;
                if (f != null && f==s) {
                    break;
                }
            }
        }

        if (f!=s) return null;

        s = head;
        while (s!=f) {
            s = s.next;
            f = f.next;
        }

        return s;
    }

    public ListNode detectCycle2021(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (s!=null && f!=null) {
            s = s.next;

            if (f.next !=null) {
                f = f.next.next;
                if (f!= null && f==s) {
                    break;
                }
            }
        }

        if (f != s) return null;

        s = head;

        while (s!=f){
            s = s.next;
            f = f.next;
        }
        return s;
    }
}
