package Question.leetcode;

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
}
