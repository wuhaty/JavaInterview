package Question.leetcode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q394 {

    int p = 0;

    public static void main(String[] args) {
        Q394 q = new Q394();
        q.decodeStringOPT("3[a2[c]]");
    }

    public String decodeStringOri(String s) {
        if (s == null || s.isEmpty()) return s;

        char[] cs = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i<cs.length){
            if (Character.isLetter(cs[i])) sb.append(cs[i++]);
            else if (Character.isDigit(cs[i])){
                int repeatTimes = 0;
                int j = i;
                while (Character.isDigit(cs[j])){
                    repeatTimes = repeatTimes *10 + cs[j] - '0';
                    j++;
                }

                int leftScore = 1;
                j++;
                int left = j;
                while (j<s.length() && leftScore >0){
                    if (cs[j] == '[') leftScore++;
                    if (cs[j] == ']') leftScore--;
                    j++;
                }

                String sub = decodeStringOri(s.substring(left,j-1));
                for (int k = 0; k < repeatTimes; k++) {
                    sb.append(sub);
                }
                i = j;
            }
        }
        return sb.toString();
    }

    public String decodeStringOPT(String s) {
        Deque<String> stk = new LinkedList<>();
        char cs[] = s.toCharArray();
        while (p<cs.length){
            char ch = cs[p];
            if (Character.isDigit(ch)){
                int n = getNum(cs);
                stk.push(String.valueOf(n));
            }else if (ch == '[' || Character.isLetter(ch)){
                stk.push(String.valueOf(ch));
                p++;
            }else {
                p++;

                List<String> l = new LinkedList<>();
                while (!stk.isEmpty() && !stk.peek().equals("[")){
                    l.add(stk.pop());
                }

                Collections.reverse(l);
                String str = getString(l);

                //pop '['
                stk.pop();
                int repeatTimes = Integer.parseInt(stk.pop());
                StringBuilder sb = new StringBuilder();
                while (repeatTimes-->0){
                    sb.append(str);
                }
                stk.push(sb.toString());
            }
        }

        StringBuilder retv = new StringBuilder();
        while(!stk.isEmpty())
            retv.insert(0, stk.pop());
        return retv.toString();
    }

    private String getString(Iterable<String> l) {
        StringBuilder sb = new StringBuilder();
        for (String s:l) {
            sb.append(s);
        }
        return sb.toString();
    }

    private int getNum(char[] cs) {
        int res = 0;
        while (p < cs.length && Character.isDigit(cs[p])){
            res = res *10 + cs[p++] - '0';
        }
        return res;
    }
}
