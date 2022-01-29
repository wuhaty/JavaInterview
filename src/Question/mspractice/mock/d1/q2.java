package Question.mspractice.mock.d1;

import Question.leetcode.Q1;

import java.util.HashSet;
import java.util.Set;

public class q2 {

    public static void main(String[] args) {
        q2 q = new q2();
        q.numUniqueEmails(new String[]{"david@lee.tcode.com","davidle@e.tcode.com"});
    }
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();

        for (String s:emails) {
            String[] split = s.split("@");
            String local = split[0];
            String domain = split[1];

            int plus = local.indexOf('+');
            int dot = local.indexOf('.');

            if (plus <0 && dot <0){
                res.add(local+"@"+domain);
            }else {
                plus = (plus<0?local.length():plus);
                String str = local.substring(0,plus).replace(".","");
                res.add(str+"@"+domain);
            }
        }

        return res.size();
    }
}
