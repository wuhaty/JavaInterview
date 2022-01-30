package Question.mspractice;

import Question.leetcode.common.ListNode;

public class M19 {

    int count = 0;
    ListNode newHead = null;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        newHead = head;
        dfs(newHead,null,n);
        return newHead;
    }

    private void dfs(ListNode head, ListNode prev, int n) {
        if (head == null) return;
        dfs(head.next,head,n);
        count++;
        if (count == n){
            if (prev == null) newHead = newHead.next;
            else {
                prev.next = head.next;
                head.next = null;
            }
        }
    }

    public ListNode removeNthFromEndFSP(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (n-->0){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (slow == head) return head.next;
        pre.next = slow.next;
        return head;
    }

}
