package Question.sword;

import Question.leetcode.common.ListNode;

public class O52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        int countP=0, countQ=0;

        while (p != null) {
            p = p.next;
            countP ++;
        }

        while (q != null) {
            q = q.next;
            countQ ++;
        }

        ListNode longer = headB;
        ListNode shorter = headA;
        if (countP > countQ) {
            longer = headA;
            shorter = headB;
        }

        int diff = Math.abs(countP-countQ);
        while (diff-- > 0){
            longer = longer.next;
        }

        while (longer != null && shorter != null && longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }
}
