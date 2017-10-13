package Question.interview.bytedance;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/2.
 */
public class p3 {
    static int result = 0;
    public static void main(String argc[]){
        Scanner sc= new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int K = sc.nextInt();
            String input[] = new String[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.next();
            }
            ArrayList<String> perms = new ArrayList<>();
            dfs(input,0,perms);

            for (String s:perms) {
                judge(s,K);
            }
            System.out.println(result);
        }
    }

    private static void dfs(String[] input, int index,ArrayList<String> perms) {
        if (index == input.length-1){
            String temp = "";
            for (int i = 0; i < input.length; i++) {
                temp += input[i];
            }
            perms.add(temp);
            return;
        }

        for (int i = index; i < input.length; i++) {
            String temp = input[index];
            input[index] = input[i];
            input[i] = temp;
            dfs(input,index+1,perms);
            temp = input[index];
            input[index] = input[i];
            input[i] = temp;
        }
    }

    private static void judge(String s,int k) {
        int len = s.length();
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.substring(0,i).equals(s.substring(len-i,len))
                    && s.substring(i,len).equals(s.substring(0,len-i))){
                count++;
            }
        }
        if (count == k) result++;
//        String ori = sb.toString();
//        int i = 0;
//        int m = 0;
//        while (i<sb.length()){
//            char temp = sb.charAt(0);
//            sb.deleteCharAt(0);
//            sb.append(temp);
//            if (sb.toString().equals(ori)){
//                m++;
//            }
//            i++;
//        }
//        if (m==k) result++;
    }
}
