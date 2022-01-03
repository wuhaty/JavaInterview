package Question.leetcode;

import Question.leetcode.common.ListNode;

import java.util.List;

/**
 * Created by gump on 2017/8/26.
 */
public class Q234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast!=null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;
        while (slow!= null && fast != null){
            if (slow.val!=fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head !=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }


    public boolean isPalindrome2021(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!= null) {
            slow = slow.next;

            if (fast.next == null){
                break;
            }else {
                fast = fast.next.next;
            }
        }


        ListNode reverse = reverse2021(slow);
        while (head!= null && reverse != null){
            if (head.val != reverse.val) return false;
            head = head.next;
            reverse = reverse.next;
        }

        return true;
    }

    private ListNode reverse2021(ListNode slow) {
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        return pre;
    }
}
