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


}
