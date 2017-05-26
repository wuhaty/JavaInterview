package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/5/22.
 */
public class Q140 {
    public static void main(String argc[]){
        Q140 q =new Q140();
        String temp[] = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = Arrays.asList(temp);
        q.wordBreak("catsanddog",wordDict);
    }



    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict,new HashMap<>());
    }

    private List<String> dfs(String s,List<String> wordDict, HashMap<String,List<String>> map) {
        if (map.containsKey(s)){
            return map.get(s);
        }

        LinkedList<String> res = new LinkedList<>();

        if (s.length()==0){
            res.add("");
            return res;
        }

        for (String dict :wordDict) {
            if (s.startsWith(dict)){
                List<String> list = dfs(s.substring(dict.length()),wordDict,map);

                for (String str:list){
                    res.add(dict + (str.isEmpty()? "":" ")+str);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}
