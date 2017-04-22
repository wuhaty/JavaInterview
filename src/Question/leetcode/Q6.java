package Question.leetcode;

/**
 * Created by gump on 2017/4/22.
 */
public class Q6 {
    public String convert(String s, int numRows) {
        if(s.isEmpty()) return "";
        if(numRows==1) return s;
        StringBuilder sb[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int gap = numRows-2;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(count <numRows){
                sb[count%numRows].append(s.charAt(i));
            }else{
                sb[2*numRows-count-2].append(s.charAt(i));
            }
            count++;
            if(count == (gap+numRows)) count =0;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder j:sb) {
            result.append(j.toString());
        }
        return result.toString();
    }

    public static void main(String argc[]){
        Q6 q = new Q6();
        System.out.println(q.convert("PAYPALISHIRING",5));
    }
}
