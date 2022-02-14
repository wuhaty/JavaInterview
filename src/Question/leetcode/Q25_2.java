package Question.leetcode;

import Question.leetcode.common.ListNode;

public class Q25_2 {

    public static void main(String[] args) {
        Q25_2 q = new Q25_2();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        q.reverseKGroup(n1,2);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode tail = dummyHead;

        while (cur != null){
            ListNode left = cur;
            int i = 0;
            while (cur!= null && i < k){
                cur = cur.next;
                i++;
            }

            if (i != k) {
                return dummyHead.next;
            }

            ListNode[] rNodes = reverseNode(left,k);
            ListNode newHead = rNodes[0];
            ListNode newTail = rNodes[1];

            tail.next = newHead;
            newTail.next = cur;
            tail = newTail;
        }

        return dummyHead.next;
    }

    private ListNode[] reverseNode(ListNode left, int k) {
        ListNode pre = null;
        ListNode p = left;

        while (k-- > 0){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{pre,left};
    }
}
