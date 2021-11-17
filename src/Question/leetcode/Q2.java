package Question.leetcode;

/**
 * Created by gump on 2021/1/19.
 */
public class Q2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);

        Q2 q = new Q2();
        q.addTwoNumbers2021(l1,l2);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean add = false;
        ListNode curL1 = l1;
        ListNode head = l1;

        while (l1 != null && l2 != null) {
            l1.val = (l1.val + l2.val + (add? 1:0));

            if (l1.val >= 10) {
                l1.val -= 10;
                add = true;
            }else{
                add = false;
            }
            curL1 = l1;

            l1 = l1.next;
            l2 = l2.next;
        }

        //either l1 or l2 is empty
        while (l1 != null) {
            l1.val = (l1.val + (add? 1:0));

            if (l1.val >= 10) {
                l1.val -= 10;
                add = true;
            }else{
                add = false;
            }

            curL1 = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            curL1.next = new ListNode((l2.val + (add? 1:0)));

            ListNode newNode = curL1.next;

            if (newNode.val >= 10) {
                newNode.val -= 10;
                add = true;
            }else{
                add = false;
            }

            l2 = l2.next;
            curL1 = curL1.next;
        }

        if (add) {
            curL1.next = new ListNode(1);
        }

        return head;
    }

    public ListNode addTwoNumbers2021(ListNode l1, ListNode l2) {
        int carrier = 0;
        ListNode pre = null;
        ListNode res = l2;
        while (carrier != 0 || l1 != null){
            if (l2 == null) {
                l2 = new ListNode(0);
                pre.next = l2;
            }

            l2.val += ((l1==null?0:l1.val) + carrier);
            if (l2.val >= 10) {
                l2.val = (l2.val % 10);
                carrier = 1;
            }else {
                carrier = 0;
            }
            pre = l2;
            l2 = l2.next;
            if (l1 != null) {
                l1 = l1.next;
            }
        }

        return res;
    }
}
