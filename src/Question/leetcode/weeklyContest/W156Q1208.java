package Question.leetcode.weeklyContest;

public class W156Q1208 {

    public static void main(String args[]){
        W156Q1208 q = new W156Q1208();
        q.equalSubstring("abcd","bcdf",3);

    }

    public int equalSubstring(String s, String t, int maxCost) {
        if(s.length()==0 || s==null)
            return 0;
        int left=0;
        int right=0;
        int max = Integer.MIN_VALUE;
        for(right=0;right<t.length();right++){
            maxCost-=Math.abs(s.charAt(right)-t.charAt(right));
            if(maxCost<0){
                maxCost+=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
                if (maxCost>=0) max = Math.max(right-left+1,max);
            }
            max = Math.max(right-left+1,max);
        }
        return max;
    }
}
