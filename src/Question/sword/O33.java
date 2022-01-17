package Question.sword;

import java.util.Stack;

public class O33 {

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder,0,postorder.length-1);
    }

    private boolean verify(int[] postorder, int l, int r) {
        if (l>=r) return true;
        int root = postorder[r];

        int i = l;
        while (postorder[i]<root) i++;
        int j = i;
        while (postorder[j]>root) j++;

        return j==r && verify(postorder,l,i-1) && verify(postorder,i,r-1);
    }

    public boolean verifyPostorderIter(int[] postorder) {
        //reverse post order: m\r\l

        if (postorder == null) return false;
        Stack<Integer> s = new Stack<>();
        Integer root = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >=0 ; i--) {
            //exceed limit
            if (postorder[i] > root) return false;
            while (!s.isEmpty() && s.peek()>postorder[i]){
                //find minimal parent
                root = s.pop();
            }
            //right child
            s.push(postorder[i]);
        }
        return true;
    }
}
