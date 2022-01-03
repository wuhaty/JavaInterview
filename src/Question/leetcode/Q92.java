package Question.leetcode;

import Question.leetcode.common.ListNode;

import java.util.Random;

public class Q92 {

    public ListNode reverseBetweenIter(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode iter = dummyHead;
        for (int i = 0; i < left-1; i++) {
            iter = iter.next;
        }

        ListNode reverseEnd = iter;

        for (int i = 0; i < right-left+1; i++) {
            reverseEnd = reverseEnd.next;
        }

        ListNode rightNode = reverseEnd.next;
        ListNode reverseOriStart = iter.next;
        reverseEnd.next = null;
        iter.next = null;

        ListNode reverseHead = reverse(reverseOriStart);

        iter.next = reverseHead;
        reverseOriStart.next = rightNode;

        return dummyHead.next;
    }

    private ListNode reverse(ListNode cur) {
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseBetweenOpt(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        for (int i = 0; i < left -1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next = cur.next;

        for (int i = 0; i < right-left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}
