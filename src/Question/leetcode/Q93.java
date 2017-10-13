package Question.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/8/21.
 */
public class Q93 {
    public static void main(String argc[]){
        Q93 q= new Q93();
        q.restoreIpAddresses("");
    }


    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        dfs(s,0,"",result);
        return result;
    }

    private void dfs(String s, int i, String s1, ArrayList<String> strings) {
        if (i==4) {
            strings.add(s1);
            return;
        }

        for (int j = 0; j <s.length() ; j++) {
            if (s.substring(0,j+1).startsWith("0") && j>0) return;

            int ip = Integer.parseInt(s.substring(0,j+1));
            if(ip>255) return;
            if(s.length() - j -1 <= (3-i)*3
                    && s.length() - j -1 >= (3-i)) {
                String temp = s1;
                temp+=ip;
                if (i<=2) temp+=".";
                dfs(s.substring(j+1),i+1,temp,strings);
            }
        }
    }
}
