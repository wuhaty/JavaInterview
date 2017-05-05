package Question.leetcode;

/**
 * Created by gump on 2017/5/5.
 */
public class Q541 {
    public String reverseStr(String s, int k) {
        char str[] = s.toCharArray();
        for(int i =0 ;i<str.length;i+=(2*k)){
            reverseSub(str,i,Math.min(str.length-1,i+k-1));
        }
        return new String(str);
    }


    public void reverseSub(char str[],int i ,int j){
        while (i<j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;j--;
        }
    }
}
