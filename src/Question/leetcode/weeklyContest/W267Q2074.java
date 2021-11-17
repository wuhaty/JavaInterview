package Question.leetcode.weeklyContest;

public class W267Q2074 {
    public static void main(String[] args) {
        W267Q2074 q = new W267Q2074();
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
//        ListNode n6 = new ListNode(6);
//        ListNode n7 = new ListNode(7);
//        ListNode n8 = new ListNode(8);
//        ListNode n9 = new ListNode(9);
//        ListNode n10 = new ListNode(10);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//        n8.next = n9;
//        n9.next = n10;

        q.reverseEvenLengthGroups(n1);
    }


    public ListNode reverseEvenLengthGroups(ListNode head) {
        int groupIndex = 1;
        ListNode res = head;
        ListNode pre = null;

        // Count number of nodes in total.
        ListNode ptr = head;
        int total = 0;
        while (ptr != null) {
            total++;
            ptr = ptr.next;
        }

        int numOfNodes = 1;
        while (head != null) {
            numOfNodes = Math.min(numOfNodes, total);
            total -= numOfNodes;
            int count = 0;

            if (numOfNodes % 2 == 1) {
                while (count != numOfNodes && head != null) {
                    count++;
                    pre = head;
                    head = head.next;
                }
            }else{
                ListNode end = head;
                while (count != numOfNodes && end != null) {
                    count++;
                    end = end.next;
                }
                ListNode newNode = reverseNode(head,numOfNodes);
                head = end;
                ListNode temp = pre.next;
                pre.next.next = end;
                pre.next = newNode;
                pre = temp;
            }
            numOfNodes++;
        }

        return res;
    }

    private ListNode reverseNode(ListNode head, int count) {
        ListNode pre = null;

        while (head != null && count >0) {
            count--;
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }


    public ListNode reverseEvenLengthGroups2(ListNode head) {
        // Check corner case with null.
        if (head == null) {
            return null;
        }

        // Count number of nodes in total.
        ListNode ptr = head;
        int total = 0;
        while (ptr != null) {
            total++;
            ptr = ptr.next;
        }

        int numOfNodes = 1;
        ListNode cur = head, pre = null;
        while (cur != null) {
            numOfNodes = Math.min(numOfNodes, total);
            total -= numOfNodes;
            if (numOfNodes % 2 == 1) {
                // Odd: Move pointers.
                int cnt = 0;
                while (cur != null && cnt++ < numOfNodes) {
                    pre = cur;
                    cur = cur.next;
                }
            } else {
                // Even: Reverse List
                ListNode[] res = reverseList(cur, numOfNodes);
                pre.next = res[0];
                pre = cur;
                cur = res[1];
            }
            numOfNodes++;
        }
        return head;
    }

    // Reverse from node with n nodes.
    private ListNode[] reverseList(ListNode node, int n) {
        ListNode pre = null, cur = node, post = null;
        while (n-- > 0) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        node.next = cur;
        return new ListNode[]{pre, post};
    }
}
