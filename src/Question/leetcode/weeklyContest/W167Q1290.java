package Question.leetcode.weeklyContest;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class W167Q1290 {


    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int result = 0;
        while (p!=null){
            result *=2;
            if (p.val == 1){
                result +=1;
            }
            p = p.next;
        }
        return result;
    }
}
