package Question.leetcode;

import Question.leetcode.common.ListNode;
import Question.leetcode.common.TreeNode;

import java.math.BigDecimal;
import java.util.LinkedList;
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

    public ListNode addTwoNumbers2021(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1.next!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2.next!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode h = new ListNode(0);
        int carrier = 0;
        while (!s1.isEmpty() && !s2.isEmpty()){
            int i1 = s1.pop();
            int i2 = s2.pop();

            int score = (i1+ i2 + carrier);

            ListNode n = new ListNode(score%10);
            n.next = h.next;
            h.next = n;
            carrier = (score/10);
        }

        while (!s1.isEmpty()){
            int i1 = s1.pop();
            int score = (i1 + carrier);
            ListNode n = new ListNode(score%10);
            n.next = h.next;
            h.next = n;
            carrier = (score/10);
        }

        while (!s2.isEmpty()){
            int i2 = s2.pop();
            int score = (i2 + carrier);
            ListNode n = new ListNode(score%10);
            n.next = h.next;
            h.next = n;
            carrier = (score/10);
        }

        if (carrier>0){
            ListNode n = new ListNode(carrier);
            n.next = h.next;
            h.next = n;
        }
        return h.next;
    }

    public ListNode addTwoNumbers2021_2(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        Stack<ListNode> more = s1;
        Stack<ListNode> less = s2;

        ListNode p = l1,q = l2;
        int count1= 0,count2=0;
        while (p != null) {
            s1.push(p);
            p = p.next;
            count1 ++;
        }

        while (q != null) {
            s2.push(q);
            q = q.next;
            count2 ++;
        }

        if (count1<count2) {
            more = s2;
            less = s1;
        }

        int carrier = 0;
        ListNode m = null;
        while (more.size() > 0) {
            m = more.pop();
            ListNode l = (less.size() == 0? null:less.pop());

            int sum = (m.val + (l == null?0:l.val) + carrier) ;
            carrier = sum /10;
            m.val = (sum%10);
        }

        if (carrier > 0) {
            ListNode n = new ListNode(carrier);
            n.next = m;
            m = n;
        }
        return m;
    }
}
