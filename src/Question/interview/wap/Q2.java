package Question.interview.wap;

import java.util.*;

/**
 * Created by gump on 2017/9/24.
 */

import java.util.LinkedList;
import java.util.Scanner;


public class Q2 {
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        sc.nextLine();
        LinkedList<Integer> q = new LinkedList<>();

        while (s-->0){
            String op = sc.next();
            int n = -1;

            if (op.startsWith("push")){
                n = sc.nextInt();
                if (op.equals("push_front")){
                    q.addFirst(n);
                }else if(op.equals("push_back")){
                    q.add(n);
                }
                continue;
            }else if (op.startsWith("pop")){
                if (q.size()==0){
                    System.out.println("Error");
                    continue;
                }

                if (op.equals("pop_front")){
                    int head = q.peek();
                    q.pollFirst();
                    System.out.println(head);
                }else if(op.equals("pop_back")){
                    int tail = q.getLast();
                    q.pollLast();
                    System.out.println(tail);
                }
                continue;
            }else if (op.equals("reverse")){
                for (int i = 0; i < q.size()/2; i++) {
                    int temp = q.get(i);
                    q.set(i,q.get(q.size()-i-1));
                    q.set(q.size()-i-1,temp);
                }
                continue;
            }else{
                if (q.size()==0){
                    System.out.println("Error");
                    continue;
                }
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < q.size(); i++) {
                    max = Math.max(q.get(i),max);
                }
                System.out.println(max);
            }
        }
    }

}
