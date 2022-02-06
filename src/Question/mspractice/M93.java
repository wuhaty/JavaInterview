package Question.mspractice;

import java.util.LinkedList;
import java.util.List;

public class M93 {
    List<String> res = new LinkedList<>();

    public static void main(String[] args) {
        M93 q = new M93();
        q.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        backtrack(s,"",0,0);
        return res;
    }

    private void backtrack(String s, String tmp, int i,int count) {
        if (count>4) return;
        if (i == s.length() && count==4){
            res.add(tmp.substring(0,tmp.length()-1));
            return;
        }

        //1 step
        int first = i+1 <= s.length()?Integer.parseInt(s.substring(i,i+1)):-1;
        if (first != -1){
            backtrack(s,tmp+first+".",i+1,count+1);
        }

        //2 steps
        int second = i+2 <= s.length()? Integer.parseInt(s.substring(i,i+2)):0;
        if (second >=10){
            backtrack(s,tmp+second+".",i+2,count+1);
        }

        //3 steps
        int third = i+3 <= s.length()? Integer.parseInt(s.substring(i,i+3)):0;
        if (third>=100 && third<=255){
            backtrack(s,tmp+third+".",i+3,count+1);
        }
    }
}
