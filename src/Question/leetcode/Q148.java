package Question.leetcode;

/**
 * Created by gump on 2017/5/3.
 */
public class Q148 {
    public static void main(String argc[]){
        Q148 q = new Q148();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        System.out.println(q.sortList(n1));
    }


    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast=fast.next.next;
        }

        pre.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        head = merge(left,right);
        return head;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (left!=null || right!=null){
            if(left ==null || (right!=null && left.val >= right.val)){
                temp.next = right;
                temp = right;
                right = right.next;
                continue;
            }

            if(right ==null || (left!=null && left.val < right.val)){
                temp.next = left;
                temp = left;
                left = left.next;
                continue;
            }
        }
        return head.next;
    }


    public ListNode sortList2021(ListNode head) {
        if (null == head || head.next == null)  return head;

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        ListNode l1 = sortList2021(head);
        ListNode l2 = sortList2021(slow);


        return merge2021(l1,l2);
    }

    private ListNode merge2021(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0), l = p;

        while (l1!=null && l2 != null ) {
            if (l1.val<l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }


        if (l1!=null) p.next = l1;
        if (l2!=null) p.next = l2;

        return l.next;
    }
}
