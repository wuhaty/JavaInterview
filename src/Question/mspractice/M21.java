package Question.mspractice;

import Question.leetcode.common.ListNode;

public class M21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode p = list1, q = list2;

        while (p!= null || q != null){
            if (p == null) {
                pre.next = q;
                break;
            }

            if (q == null){
                pre.next = p;
                break;
            }

            if (p.val < q.val){
                pre.next = p;
                pre = p;
                p = p.next;
            }else {
                pre.next = q;
                pre = q;
                q = q.next;
            }
        }

        return dummyHead.next;
    }
}
