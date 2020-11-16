package Question.leetcode;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Created by gump on 2017/12/19.
 */
public class Q445 {

    public static void main(String argc[]){
        Q445 q = new Q445();
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        q.addTwoNumbers(l1,l2);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();

        while (l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int adder = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || adder!=0){
            int v1 = s1.isEmpty()?0:s1.pop();
            int v2 = s2.isEmpty()?0:s2.pop();

            int sum = v1+v2+adder;
            ListNode temp = new ListNode(sum%10);
            adder = sum/10;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
