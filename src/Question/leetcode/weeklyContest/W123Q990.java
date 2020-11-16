package Question.leetcode.weeklyContest;

import java.util.*;

public class W123Q990 {
    public static void main(String args[]){
        W123Q990 q = new W123Q990();
        String a[] = {"a==b","b!=c","c==a"};
        q.equationsPossible(a);
    }


    public boolean equationsPossible(String[] equations) {
        Map<Character, List<Character>> m = new HashMap<>();

        for (String s:equations) {
            char e[] = s.toCharArray();
            if (e[1] == '='){
                if (e[0] == e[3]) continue;
                else {
                    m.putIfAbsent(e[0],new LinkedList<>());
                    m.putIfAbsent(e[3],new LinkedList<>());
                    m.get(e[0]).add(e[3]);
                    m.get(e[3]).add(e[0]);
                }
            }else{
                if (e[0] == e[3]) return false;
                else {
                    m.putIfAbsent(e[0],new LinkedList<>());
                    m.putIfAbsent(e[3],new LinkedList<>());
                }
            }
        }

        for (String s:equations) {
            char e[] = s.toCharArray();
            if (e[1] == '!' && check(e[0],e[3],m,new HashSet<>())){
                return false;
            }
        }
        return true;
    }

    private boolean check(char c, char c1, Map<Character, List<Character>> m,HashSet<Character> s) {
        if (c == c1) return true;
        s.add(c);
        for (char k : m.get(c)) {
            if (!s.contains(k) && check(k,c1,m,s)) return true;
        }
        return false;
    }
}
