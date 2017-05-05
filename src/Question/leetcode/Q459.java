package Question.leetcode;

/**
 * Created by gump on 2017/5/5.
 */
public class Q459 {

    public static void main(String argc[]){
        Q459 q = new Q459();
        System.out.println(q.repeatedSubstringPattern("aaaa"));
    }



    public boolean repeatedSubstringPattern(String s) {
        if(s.length() %2 != 0) return false;

        int i = s.length()-1;
        while (i>0){
            if(s.length() % i !=0){
                i--;continue;
            }else{
                String subS = s.substring(0,i);
                int m = s.length()/i;
                StringBuilder sb = new StringBuilder();
                while (m-->0){
                    sb.append(subS);
                }
                if(sb.toString().equals(s)) return true;
                i--;
            }
        }
        return false;
    }
}
