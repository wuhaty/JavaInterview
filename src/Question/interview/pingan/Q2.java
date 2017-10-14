package Question.interview.pingan;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/14.
 */
public class Q2 {
    static int min = Integer.MAX_VALUE;
    public static void main(String argc[]){
        Scanner sc= new Scanner(System.in);
        while (sc.hasNext()){
            String start = sc.next();
            String end = sc.next();
            int n = sc.nextInt();
            String dict[] = new String[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                dict[i] = sc.nextLine();
            }

            List<List<String>> result = new LinkedList<>();
            List<String> temp = new LinkedList<>();
            temp.add(start);

            dfs(result,temp,dict,end);

            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < result.get(i).size(); j++) {
                    if (j==result.get(i).size()-1) System.out.println(result.get(i).get(j));
                    else{
                        System.out.print(result.get(i).get(j));
                        System.out.print(" ");
                    }
                }
            }
        }
    }

    private static void dfs(List<List<String>> result, List<String> temp, String[] dict, String end) {
        if (judge(temp.get(temp.size()-1),end)){
            temp.add(end);
            List<String> l = new LinkedList<>();

            if (temp.size()<=min){
                if (temp.size()<min){
                    result.clear();
                    min = temp.size();
                }
                l.addAll(temp);
                result.add(l);
            }
            temp.remove(end);
            return;
        }

        for (int j = 0; j < dict.length; j++) {
            if (!temp.contains(dict[j]) && judge(dict[j],temp.get(temp.size()-1))){
                temp.add(dict[j]);
                dfs(result,temp,dict,end);
                temp.remove(dict[j]);
            }
        }
    }

    private static boolean judge(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int count =0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i]!=c2[i]){
                count++;
            }
            if (count>1) return false;
        }
        return true;
    }
}
