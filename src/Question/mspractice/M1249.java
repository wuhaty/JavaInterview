package Question.mspractice;

import java.util.Stack;

public class M1249 {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();

        int leftCount = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                leftCount ++;
                sb.append('(');
            }else if (cs[i] == ')'){
                if (leftCount>0){
                    leftCount--;
                    sb.append(')');
                }
            }else {
                sb.append(cs[i]);
            }
        }

        for (int i = sb.length()-1; i >=0 && leftCount>0 ; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                leftCount--;
            }
        }

        return sb.toString();
    }
}
