package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q551 {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        char input[] = s.toCharArray();
        for (int i = 0; i < input.length; i++) {

            if(input[i]!='L'){
                l=0;
            } else if(input[i]=='L'){
                l++;
            } if(input[i] == 'A'){
                a++;
            }

            if(l>2 || a >= 2) return false;
        }
        return true;
    }
}
