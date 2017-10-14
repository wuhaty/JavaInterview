package Question.leetcode;

import java.util.Stack;

/**
 * Created by gump on 2017/10/14.
 */
public class Q522 {
    public static void main(String argc[]){
        Q522 q = new Q522();
        String d[] = {"a","b","c","d","e","f","a","b","c","d","e","f"};
        System.out.println(q.findLUSlength(d));
    }



    public int findLUSlength(String[] strs) {
        Stack<String> temp = new Stack<>();
        Stack<String> pre = new Stack<>();
        for (String s:strs) {
            if (s.length() > (temp.isEmpty()?0:temp.peek().length())){
                boolean mod = false;
                for (String p:pre) {
                    char c[] = p.toCharArray();
                    int i = 0,j=0;
                    while (i<s.length() && j<c.length){
                        if (c[j] == s.charAt(i)){
                            i++;
                        }
                        j++;
                    }
                    if (i==s.length()){
                        mod = true;
                        break;
                    }
                }
                if (mod) continue;
                temp.push(s);
            }else if (s.length() == temp.peek().length()){
                if (temp.contains(s)){
                    temp.remove(s);
                    pre.push(s);
                }else{
                    temp.push(s);
                    pre.push(s);
                }
            }
        }

        if (temp.isEmpty()) return -1;
        else return temp.peek().length();
    }
}
