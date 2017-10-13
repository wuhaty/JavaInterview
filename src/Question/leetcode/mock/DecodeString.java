package Question.leetcode.mock;

import java.util.Stack;

/**
 * Created by gump on 2017/7/10.
 */
public class DecodeString {

    int i = 0;

    public static void main(String argc[]) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeStringWithStack("3[a2[c]]"));
    }

    private String decodeStringWithStack(String s) {
        String result = "";

        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int i = 0;
        int n = s.length();
        while (i < n){
            if (Character.isDigit(s.charAt(i))){
                int count = 0;
                while (Character.isDigit(s.charAt(i))){
                    count = count*10 + (s.charAt(i++) - '0');
                }
                countStack.push(count);
            }else if (s.charAt(i) == '['){
                strStack.push(result);
                result = "";
                i++;
            }else if (s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(strStack.pop());
                int count = countStack.pop();
                while (count-->0){
                    sb.append(result);
                }
                result = sb.toString();
                i++;
            }else
                result += s.charAt(i++);
        }
        return result;
    }

    public String decodeStringWithRecur(String s) {
        return recur(s);
    }

    private String recur(String s) {
        String result = "";
        int n = s.length();

        int count = 0;
        while (i < n) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= 0) {
                count = count * 10 + (s.charAt(i++) - '0');
            } else if (s.charAt(i) == '[') {
                i++;
                String temp = recur(s);
                for (int j = 0; j < count; j++) {
                    result += temp;
                }
                count = 0;
            } else if (s.charAt(i) == ']') {
                i++;
                return result;
            } else
                result += s.charAt(i++);
        }
        return result;
    }
}
