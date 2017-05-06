package Question.leetcode;

/**
 * Created by gump on 2017/5/6.
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        char input[] = strs[0].toCharArray();
        int i=0;
        while (i<input.length){
            for (String s:strs) {
                if(i>s.length()-1 || s.charAt(i)!=input[i]) return sb.toString();
            }
            sb.append(input[i]);
            i++;
        }
        return sb.toString();
    }
}
