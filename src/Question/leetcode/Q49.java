package Question.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2017/5/24.
 */
public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,LinkedList<String>> map = new HashMap<>();
        for (String s:strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = new String(c);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }else {
                LinkedList<String> list = new LinkedList<String>(){{add(s);}};
                map.put(str,list);
            }
        }

        List<List<String>> result = new LinkedList<>();
        result.addAll(map.values());
        return result;
    }
}
