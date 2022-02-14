package Question.interview.xiaohongshu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q3 {

        public static void main(String[] args) {
            Q3 m = new Q3();
            String[] input = new String[]{"abc","bcd","abcd","a"};
            m.sort(input);
            for(String s : input){
                System.out.println(s);
            }
        }

        public void sort(String[] strs){
            Arrays.sort(strs, String::compareTo);
        }
}