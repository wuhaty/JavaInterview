package Question.mspractice;

import Question.leetcode.common.ListNode;

public class M206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }
        return pre;
    }
}
