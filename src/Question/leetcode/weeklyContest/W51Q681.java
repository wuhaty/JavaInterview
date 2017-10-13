package Question.leetcode.weeklyContest;

import java.util.Arrays;

/**
 * Created by gump on 2017/9/24.
 */
public class W51Q681 {
    int min = Integer.MAX_VALUE;
    String result = "";
    public static void main(String argc[]){
        W51Q681 q  =new W51Q681();
        System.out.println(q.nextClosestTime("19:34"));
    }


    public String nextClosestTime(String time) {
        int n = time.length();
        char[] choice = new char[n-1];
        choice[0] =time.charAt(0);
        choice[1] =time.charAt(1);
        choice[2] =time.charAt(3);
        choice[3] =time.charAt(4);

        if (choice[0] ==choice[1]
                && choice[1]==choice[2]
                && choice[2]==choice[3]) return time;

        StringBuilder sb = new StringBuilder();

        int ori = Integer.parseInt(time.substring(0,2))*60 +Integer.parseInt(time.substring(3));

        dfs(choice,sb,0,ori);

        return result;
    }

    private void dfs(char[] choice, StringBuilder sb, int start,int ori) {
        if (start == 4){
            int score = Integer.parseInt(sb.substring(0,2))*60 +Integer.parseInt(sb.substring(2));
            if (score ==  ori) return;
            int d = score > ori? score-ori : 1440+score-ori;
            if (min>d){
                min = d;
                result = sb.substring(0,2)+":"+sb.substring(2);
            }
            return;
        }

        for (int i = 0; i < choice.length; i++) {
            if (start == 0 && choice[i]>'2') continue;
            if (start == 1 && (Integer.parseInt(sb.substring(0,1))*10 + choice[i] - '0')>23) continue;
            if (start == 2 && choice[i] >'5') continue;
            if (start == 3 && (Integer.parseInt(sb.substring(2))*10 + choice[i] - '0')>59) continue;
            sb.append(choice[i]);
            dfs(choice,sb,start+1,ori);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
