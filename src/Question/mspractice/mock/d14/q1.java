package Question.mspractice.mock.d14;

import Question.leetcode.common.ListNode;

public class q1 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        ListNode dummyHead2 = new ListNode(0);
        dummyHead2.next = head;
        ListNode pre = dummyHead2;

        while (head!=null){
            if (head.val<x){
                ListNode next = head.next;
                tail.next = head;
                tail = tail.next;

                pre.next = next;
                head.next = null;
                head = next;
            }else {
                pre = head;
                head = head.next;
            }
        }

        tail.next = dummyHead2.next;
        return dummyHead.next;
    }
}
