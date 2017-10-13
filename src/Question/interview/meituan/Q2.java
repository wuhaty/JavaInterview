package Question.interview.meituan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by gump on 2017/9/14.
 */
public class Q2 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int input = 0;
            Map<Integer,Boolean> Fmap = new HashMap<>();
            Map<Integer,Boolean> Amap = new HashMap<>();


            for (int i = 0; i < n; i++) {
                input = (input * 2 +sc.nextInt());
            }



            boolean firstRes = dfs(input,true,Fmap);

            if (firstRes) System.out.println("Alice");
            else System.out.println("Bob");
        }
    }

    private static boolean dfs(int input, boolean isFirst, Map<Integer, Boolean> map) {
        if (map.containsKey(input)){
            if (isFirst)
                return map.get(input);
            else
                return !map.get(input);
        }

        ArrayList<Integer> trans = getNum(input);
        boolean result = false;
        for (Integer after:trans) {
            if (!dfs(after,!isFirst,map)) {
                result = true;
                break;
            }
        }
        if(isFirst)
            map.put(input,result);
        else
            map.put(input,!result);

        return map.get(input);
    }


    public static ArrayList<Integer> getNum(int input){
        ArrayList<Integer> result = new ArrayList<>();
        String str = Integer.toBinaryString(input);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='1'){
                char temp[] = str.toCharArray();
                for (int j = i; j < str.length(); j++) {
                    temp[j] = (temp[j]=='1'?'0':'1');
                }
                result.add(Integer.valueOf(new String(temp),2));
            }
        }
        return result;
    }

}
