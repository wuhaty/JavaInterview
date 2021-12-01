package Question.leetcode;

public class Q160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        int countA = 0;
        int countB = 0;
        ListNode bigger = headA;
        ListNode smaller = headB;

        while (p!=null){
            countA++;
            p=p.next;
        }

        while (q!=null){
            countB++;
            q=q.next;
        }

        if (countB>countA){
            bigger = headB;
            smaller = headA;
        }
        int d = Math.abs(countA-countB);
        while (d>0){
            bigger = bigger.next;
            d--;
        }

        while (smaller != null && bigger != null) {
            if (smaller == bigger) {
                return smaller;
            }
            smaller = smaller.next;
            bigger = bigger.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeOpt(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA,pb = headB;
        while (pa != pb) {
            pa = pa == null? headB:pa.next;
            pb = pb == null? headA:pb.next;
        }
        return pa;
    }
}
