package Question.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new LinkedList<>();

        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < source.length; i++) {
            char cs[] = source[i].toCharArray();
            sb = new StringBuilder();
            int j = 0;

            while (j<cs.length){
                if (!inBlock && j+1 < cs.length && cs[j] == '/' && cs[j+1] == '*'){
                    inBlock = true;
                    j++;
                }else if(inBlock && j+1 <cs.length && cs[j] == '*' && cs[j+1] == '/'){
                    inBlock = false;
                    j++;
                }else if (!inBlock && j+1 < cs.length && cs[j] == '/' && cs[j+1] == '/'){
                    break;
                }else if (!inBlock) {
                    sb.append(cs[j]);
                }
                j++;
            }

            if (!inBlock && sb.length()!=0) res.add(sb.toString());
        }

        return res;
    }
}
