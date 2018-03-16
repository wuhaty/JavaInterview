package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2018/1/6.
 */
public class Q721 {

    public static void main(String argc[]){
        Q721 q = new Q721();
        List<List<String>> accounts = new LinkedList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        q.accountsMerge(accounts);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> parents = new HashMap<>();
        Map<String,String> owns = new HashMap<>();
        Map<String,Set<String>> union = new HashMap<>();
        List<List<String>> res = new LinkedList<>();

        for (List<String> accs:accounts) {
            for (int i = 1; i < accs.size(); i++) {
                parents.put(accs.get(i),accs.get(i));
                owns.put(accs.get(i),accs.get(0));
            }
        }

        for (List<String> accs:accounts) {
            String parent = find(accs.get(1),parents);
            for (int i = 2; i < accs.size(); i++) {
                parents.put(find(accs.get(i),parents),parent);
            }
        }

        for (List<String> accs:accounts) {
            String p = find(accs.get(1),parents);
            if (!union.containsKey(p)) union.put(p,new TreeSet<>());

            for (int i = 1; i < accs.size(); i++) {
                union.get(p).add(accs.get(i));
            }
        }

        for (String mail:union.keySet()) {
            List<String> temp = new LinkedList<>();
            temp.add(owns.get(mail));
            temp.addAll(union.get(mail));
            res.add(temp);
        }
        return res;
    }

    private String find(String s, Map<String, String> parents) {
        String p = parents.get(s);
        return p.equals(s) ? p:find(p,parents);
    }

    public List<List<String>> accountsMergeOri(List<List<String>> accounts) {
        List<List<String>> result = new LinkedList<>();
        Map<String,List<Set<String>>> map = new HashMap<>();

        for (List<String> l:accounts) {
            String name = l.get(0);
            boolean flag = true;
            for (int i = 0; i < l.size(); i++) {
                if (i==0 && !map.containsKey(name)) {
                    map.putIfAbsent(name,new LinkedList<>());
                    map.get(name).add(new TreeSet<>(l.subList(1,l.size())));
                    continue;
                }

                for (int j = 0; j < map.get(name).size(); j++) {
                    List<Set<String>> tempList = map.get(name);
                    int k = 0;
                    while (k<tempList.size()){
                        Iterator<Set<String>> iter = tempList.iterator();
                        while (iter.hasNext()){
                            Set<String> temp = iter.next();
                            if (temp.contains(l.get(i))){
                                flag = false;
                                //merge 2 list
                                temp.addAll(l.subList(1,l.size()));
                                break;
                            }
                        }
                        k++;
                    }
                }
            }
            //no match add new
            if (flag){
                map.get(name).add(new TreeSet<>(l.subList(1,l.size())));
            }
        }

        for (String key:map.keySet()) {
            for (Set<String> l:map.get(key)) {
                List<String> ls = new LinkedList<>();
                ls.add(key);
                ls.addAll(l);
                result.add(ls);
            }
        }
        return result;
    }
}
