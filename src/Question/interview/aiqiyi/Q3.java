package Question.interview.aiqiyi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by gump on 2017/10/28.
 */
public class Q3 {

    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            Queue<String> q = new LinkedList<>();
            q.offer("A");
            q.offer("T");
            q.offer("C");
            q.offer("G");

            while (!q.isEmpty()){
                String temp = q.poll();
                if (!s.contains(temp)){
                    System.out.println(temp.length());
                    break;
                }
                q.offer(temp+"A");
                q.offer(temp+"T");
                q.offer(temp+"C");
                q.offer(temp+"G");
            }
        }
    }
}
