package Question.leetcode;

import Question.leetcode.common.ListNode;

public class Q25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyHead.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] reverse = reverse(head,tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = nex;
        }

        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode head,ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;

        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return new ListNode[]{tail,head};
    }
}
