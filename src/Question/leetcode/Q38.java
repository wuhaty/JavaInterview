package Question.leetcode;

/**
 * Created by gump on 2017/5/8.
 */
public class Q38 {

    public static void main(String argc[]){
        Q38 q = new Q38();
        System.out.println(q.countAndSay(5));
    }


    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);

        while (--n>0){
            StringBuilder temp = new StringBuilder();
            int i = 0;
            int j = i;
            while (i<sb.length()){
                while (j<sb.length() && sb.charAt(j) == sb.charAt(i)){
                    j++;
                }
                temp.append(j-i);
                temp.append(sb.charAt(i));
                i=j;
            }
            sb =temp;
        }
        return sb.toString();
    }
}
