package Question.sword;

import Question.leetcode.common.ListNode;

public class O18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode pre = fakeHead;

        
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
                cur = cur.next;
            }else {
                pre.next = cur.next;
                cur.next = null;
                break;
            }
        }
        return fakeHead.next;
    }
}
