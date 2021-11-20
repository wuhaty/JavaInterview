package Question.leetcode;

import java.util.*;

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


    public List<List<String>> groupAnagrams_2021(String[] strs) {
        Map<String,List<String>> m = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            m.putIfAbsent(new String(cs),new LinkedList<>());
            m.get(s).add(strs[i]);
        }

        return new LinkedList<>(m.values());
    }
}
