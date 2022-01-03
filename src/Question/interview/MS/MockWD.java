package Question.interview.MS;

public class MockWD {


    class ListNode {
        Integer val;
        ListNode next;

        ListNode(Integer val) {
            this.val = val;
        }
    }

    /**
     * 两个单向链表判断是否相交
     *
     * @param args
     */


    public static void main(String[] args) {

    }

    // what if list node contains ring?
    private boolean check(ListNode a, ListNode b) {
        if (a == null || b == null) return false;

        ListNode bigger = a;
        ListNode smaller = b;

        int aLength = 0, bLength = 0;
        ListNode pa = a, pb = b;

        while (pa != null) {
            aLength++;
            pa = pa.next;
        }
        while (pb != null) {
            bLength++;
            pb = pb.next;
        }

        if (bLength > aLength) {
            bigger = b;
            smaller = a;
        }

        int diff = Math.abs(aLength - bLength);

        while (diff > 0) {
            bigger = bigger.next;
            diff--;
        }

        while (bigger != null && smaller != null) {
            if (bigger == smaller) return true;
            bigger = bigger.next;
            smaller = smaller.next;
        }
        return false;
    }
}
