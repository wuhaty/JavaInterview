package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q58 {
    public int lengthOfLastWord(String s) {
        char input[] = s.toCharArray();
        int count = 0;
        for (int i = input.length-1; i >=0 ; i--) {
            if((input[i]<'a' || input[i]>'z') && (input[i]<'A' || input[i]>'Z')){
                if(count==0){
                    continue;
                }else{
                    return count;
                }
            }else{
                count++;
            }
        }
        return count;
    }
}
