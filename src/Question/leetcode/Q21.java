package Question.leetcode;

/**
 * Created by gump on 2021/6/27.
 */
public class Q21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;

            }else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1!=null) {
            cur.next = l1;
        }


        if (l2!=null) {
            cur.next = l2;
        }

        return dummyNode.next;
    }

    public ListNode mergeTwoLists2021(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(-1);
        ListNode pre = h;

        while (l1 != null && l2 != null) {
            ListNode tar = (l1.val<l2.val? l1:l2);
            pre.next = tar;

            if (l1.val<l2.val){
                l1 = l1.next;
            }else {
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if (l1 != null || l2 != null) {
            pre.next = (l1==null?l2:l1);
        }

        return h.next;
    }
}
