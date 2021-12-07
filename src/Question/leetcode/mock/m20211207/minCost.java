package Question.leetcode.mock.m20211207;

import java.util.TreeSet;

public class minCost {

    TreeSet<Integer> s = new TreeSet<>();
    int res = 0;

    public static void main(String[] args) {
        minCost q = new minCost();
        int[] cuts= {7,8,9,2,1};
        q.minCost(10,cuts);
    }

    public int minCost(int n, int[] cuts) {
        for (int c:cuts) {
            s.add(c);
        }

        cut(n,0,n);
        return res;
    }

    private void cut(int n, int left, int right) {
        if (Math.abs(right-left)<=1 || s.isEmpty()) return;
        int targetCut = left+(right-left)/2;
        double targetCutDouble = left+(right-left+0.0)/2;

        Integer currentRightCut = s.ceiling(targetCut);
        Integer currentLeftCut = s.floor(targetCut);

        if (currentLeftCut == null && currentRightCut == null)return;
        if ((currentLeftCut == null || currentLeftCut<left)
                && (currentRightCut ==null || currentRightCut>right)) return;
        res +=n;

        Integer currentCut = currentLeftCut;
        if (currentLeftCut!= null && currentRightCut!= null &&
                Math.abs(currentRightCut-targetCutDouble)<Math.abs(currentLeftCut-targetCutDouble)){
            currentCut = currentRightCut;
        }else if (currentLeftCut == null){
            currentCut = currentRightCut;
        }

        s.remove(currentCut);
        cut(currentCut-left,left,currentCut);
        cut(right-currentCut,currentCut,right);
    }
}
