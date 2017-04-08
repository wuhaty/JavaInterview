package Question.leetcode;

/**
 * Created by gump on 2017/4/8.
 */
public class Q467 {
    public int findSubstringInWraproundString(String p) {
        if(p==null || p.length() ==0) return 0;

        char s[] = p.toCharArray();
        int result[] = new int[26];
        int maxLength = 0;
        int sum=0;

        for(int i=0;i<s.length;i++){
            if(i>0 && (s[i]-s[i-1]==-1 || (s[i] - s[i-1])==-25)){
                maxLength ++;
            }else{
                maxLength = 1;
            }
         }

        for(int i=0;i<26;i++){
            sum+=result[i];
        }

        return sum;
    }

    public static void main(String argc[]) {
        Q467 q = new Q467();
        q.findSubstringInWraproundString("zab");
    }
}
