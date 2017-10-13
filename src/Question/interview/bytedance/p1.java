package Question.interview.bytedance;

import java.util.*;

/**
 * Created by gump on 2017/9/29.
 */
public class p1 {

    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String words[] = new String[n];
            long score[] = new long[10];
            ArrayList<Character> headList = new ArrayList<Character>();

            for (int i = 0; i < n; i++) {
                words[i] = sc.nextLine();
                char input[] = words[i].toCharArray();

                for (int j = input.length-1; j >=0 ; j--) {
                    score[input[j]-'A'] += Math.pow(10,input.length-1-j);
                }
                headList.add(input[0]);
            }

            Map<Character,Long> map = new TreeMap<>();

            for (int i = 0; i < score.length; i++) {
                if (score[i]!=0) map.put((char) ('A' +(i)),score[i]);
            }
            List<Map.Entry<Character,Long>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list,new Comparator<Map.Entry<Character,Long>>() {
                @Override
                public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                    return o1.getValue() > o2.getValue() ? -1 : 1;
                }
            });

            if (list.size() == 10) {
                for (int i = 9; i >= 0; i--) {
                    if (!headList.contains(list.get(i).getKey())) {
                        list.remove(i);
                        break;
                    }
                }
            }
            int number = 9;// 最大的数字
            long result = 0;
            for (Map.Entry<Character,Long> e:list) {
                result+=(e.getValue()*number);
                number--;
            }
            System.out.print(result);
        }
    }
}
