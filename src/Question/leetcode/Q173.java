package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.Stack;

public class Q173 {

    TreeNode cur = null;
    Stack<TreeNode> s = new Stack<>();

    public Q173(TreeNode root) {
        this.cur = root;
    }

    public int next() {
        while (this.cur != null) {
            s.push(this.cur);
            this.cur = this.cur.left;
        }

        this.cur = s.pop();
        int res = this.cur.val;
        cur = this.cur.right;

        return res;
    }

    public boolean hasNext() {
        return cur != null || s.size()!=0;
    }
}
