package Question.leetcode;

import Question.leetcode.common.ListNode;

public class Q92_2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        int count = 1;

        while (count != left){
            pre = head;
            head = head.next;
            count++;
        }

        ListNode p = head;

        while (count <= right){
            head = head.next;
            count++;
        }

        ListNode next = head;
        ListNode[] rNodes = reverse(p,right-left+1);
        ListNode newHead = rNodes[0];
        ListNode newTail = rNodes[1];

        pre.next = newHead;
        newTail.next = next;

        return dummyHead.next;
    }

    private ListNode[] reverse(ListNode p, int i) {
        ListNode pre = null;
        ListNode cur = p;
        while (i-- >0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return new ListNode[]{pre,p};
    }
}
