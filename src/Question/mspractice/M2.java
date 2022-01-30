package Question.mspractice;

import Question.leetcode.common.ListNode;

public class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1, q = l2, preP = null;
        int adder = 0;

        while (q != null || adder != 0){
            if (p == null) {
                p = new ListNode(0);
                preP.next = p;
            }

            int sum = p.val + (q == null? 0: q.val) + adder;
            adder = sum/10;
            p.val = sum%10;
            preP = p;
            p = p.next;
            q = (q==null?null:q.next);
        }

        return l1;
    }
}
