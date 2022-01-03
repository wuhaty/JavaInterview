package Question.sword;


import Question.leetcode.common.ListNode;

public class O6 {

    int res[];

    public int[] reversePrint(ListNode head) {
        dfs(head,0);
        return res;
    }

    private int dfs(ListNode head,int index) {
        if (head == null) {
            res = new int[index];
            return 0;
        }

        int currentIndex = dfs(head.next,index+1);
        res[currentIndex] = head.val;
        return currentIndex + 1;
    }
}
