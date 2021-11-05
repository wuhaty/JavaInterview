package Question.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/5/2.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Q147 {
    public ListNode insertionSortListTimeConsuming(ListNode head) {
        if(head==null) return null;
        ListNode start = head;

        while (start.next!=null){
            ListNode newNode = start.next;
            ListNode scanner = head;
            int temp = newNode.val;
            while (scanner != newNode){
                if(scanner.val <= newNode.val){
                    scanner = scanner.next;
                    continue;
                }else {
                    int r =scanner.val;
                    scanner.val = temp;
                    temp = r;
                }
                scanner = scanner.next;
            }
            newNode.val = temp;
            start = start.next;
        }
        return head;
    }

    private ListNode insertionSortList(ListNode head) {
        if(head==null) return head;

        ListNode helper = new ListNode(0);
        ListNode cur = head;
        ListNode pre = helper;
        ListNode next = null;

        while (cur!=null){
            next = cur.next;

            while (pre.next !=null && pre.next.val < cur.val){
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur= next;
        }
        return helper.next;
    }


    private ListNode insertionSortList2020(ListNode head) {
        if (head == null) return head;

        ListNode helper = new ListNode(Integer.MIN_VALUE);
        ListNode pre = helper;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null){
            next = cur.next;

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }

    public static void main(String argc[]){
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        Q147 q = new Q147();
        q.insertionSortList(n1);
    }


}
