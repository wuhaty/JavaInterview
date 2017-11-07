package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2017/11/7.
 */
public class W56Q443 {

    public static void main(String argc[]){
        W56Q443 q= new W56Q443();
        char d[] = {'a','a','a','b','b','c','c','c'};
        System.out.println(q.compress(d));
    }


    public int compress(char[] chars) {
        if (chars.length==1) return 1;

        int result =0;
        int count = 1;
        char c = chars[0];

        for (int i = 1; i <chars.length; i++) {
            if (chars[i]==c) {
                count++;
                continue;
            }else{
                chars[result] = c;
                result++;
                if (count>1){
                    String temp = String.valueOf(count);
                    for (int j = 0; j < temp.length(); j++) {
                        chars[result++] = temp.charAt(j);
                    }
                }
                count=1;
                c= chars[i];
            }
        }

        if (c==chars[chars.length-1]){
            chars[result] = c;
            result++;
            if (count>1){
                String temp = String.valueOf(count);
                for (int j = 0; j < temp.length(); j++) {
                    chars[result++] = temp.charAt(j);
                }
            }
        }
        return result;
    }
}
